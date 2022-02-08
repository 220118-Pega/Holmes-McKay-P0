package reimbursement;

import java.util.ArrayList;
import java.util.List;

import employees.Employee;
import employees.Password;
import employees.db.EmployeeDB;
import io.javalin.http.Handler;
import reimbursement.db.RequestDB;
import reimbursement.resources.HTMLFactory;
import reimbursement.resources.HTMLfile;


//this class contains the lambda functions needed by the router
public class RequestController implements IController{
	static Employee user;
	static boolean logged_in = false;
	static Request selected_request = new Request();
	HTMLFactory login = HTMLfile.Login();
	HTMLFactory portal = HTMLfile.Portal();
	HTMLFactory submit = HTMLfile.Submit();
	HTMLFactory view = HTMLfile.View();
	HTMLFactory review = HTMLfile.Review();
	
	public RequestController() {};
	@Override
	public Handler login() {
		// TODO Auto-generated method stub
		
		return ctx -> 
		{
			int id = Integer.parseInt(ctx.formParam("id"));
			String pwe = Password.encrypt(ctx.formParam("password"));
			user = EmployeeDB.getEmployee(id);
			boolean login_failed = false;
			if (user==null) login_failed=true;
			if (!(user.getPassword().getPw_encrypted().equals(pwe))) login_failed=true;
			if (login_failed)
			{
				login.addError("Invalid employee ID or password");
				ctx.html(login.toString());
				login.compile();
			}
			else 
			{
				logged_in=true;
				portal.addError("Welcome " + user.getName());
				ctx.html(portal.toString());
				portal.compile();
			}
		};
	}
	
	@Override
	public Handler new_request() {
		return ctx ->
		{
			ctx.html(submit.toString());
		};
	}
	
	@Override
	public Handler gotoportal() {
		// TODO Auto-generated method stub
		return ctx->
		{
			ctx.html(portal.toString());
		};
	}
	@Override
	public Handler submit() {
		// TODO Auto-generated method stub
		return ctx->
		{
			RequestDB.addRequest(user.getId(), 
					Double.valueOf(ctx.formParam("amount")), 
					Request.readType(ctx.formParam("type")),
					ctx.formParam("reason"));
			portal.addError("Request submitted successfully");
			ctx.html(portal.toString());
		};
	}
	@Override
	public Handler view() {
		// TODO Auto-generated method stub
		return ctx ->
		{
			ctx.html(view.toString());
		};
	}
	@Override
	public Handler view_selected() {
		// TODO Auto-generated method stub
		return ctx ->
		{
			List<Request> wanted = new ArrayList<Request>();
			if (ctx.formParam("Pending")!=null) 
			{
				for (Request request:RequestDB.listRequests("Pending"))
				{
					wanted.add(request);
				}
			}
			if (ctx.formParam("Approved")!=null)
			{
				for (Request request:RequestDB.listRequests("Approved"))
				{
					wanted.add(request);
				}
			}
			if (ctx.formParam("Declined")!=null)
			{
				for (Request request:RequestDB.listRequests("Declined"))
				{
					wanted.add(request);
				}
			}
			List<Request> authorized = new ArrayList<Request>();
			if (!user.isManager())
			{
				for (Request request: wanted)
				{
					if (request.getEmployee_id()==user.getId()) authorized.add(request);
				}
			}
			else
			{
				authorized=wanted;
			}
			authorized.sort(new RComparator());
			ctx.jsonStream(authorized);
		};
	}
	@Override
	public Handler review() {
		// TODO Auto-generated method stub
		return ctx ->
		{
			if (!user.isManager())
			{
				portal.addError("Only managers can review requests");
				ctx.html(portal.toString());
				portal.compile();
				return;
			}
			ctx.html(review.toString());
		};
	}
	@Override
	public Handler review_selected() {
		// TODO Auto-generated method stub
		return ctx ->
		{
			selected_request = RequestDB.getRequest(Integer.parseInt(ctx.formParam("request_id")));
			if (selected_request==null)
			{
				review.addError("Request ID not found");
				ctx.html(review.toString());
				review.compile();
				return;
			}
			if (user.getId()==selected_request.getEmployee_id())
			{
				review.addError("Managers may not review their own requests");
				ctx.html(review.toString());
				review.compile();
				return;
			}
			if (!(selected_request.getApproved().equals("Pending")))
			{
				review.addError("Request has already been " + selected_request.getApproved().toLowerCase());
				ctx.html(review.toString());
				review.compile();
				return;
			}
			
			HTMLFactory selected = HTMLfile.ReviewAppend(selected_request);
			ctx.html(selected.toString());
		};
	}
	@Override
	public Handler logout() {
		// TODO Auto-generated method stub
		return ctx ->
		{
			user=null;
			logged_in=false;
			ctx.html(login.toString());
		};
	}
	@Override
	public Handler approve() {
		// TODO Auto-generated method stub
		return ctx ->
		{
			selected_request.setApproved("Approved");
			RequestDB.updateStatus(selected_request.getId(), selected_request.getApproved());
			selected_request=null;
			portal.addError("Request approved");
			ctx.html(portal.toString());
			portal.compile();
			
		};
	}
	@Override
	public Handler deny() {
		// TODO Auto-generated method stub
		return ctx ->
		{
			selected_request.setApproved("Denied");
			RequestDB.updateStatus(selected_request.getId(), selected_request.getApproved());
			selected_request=null;
			portal.addError("Request denied");
			ctx.html(portal.toString());
			portal.compile();
		};
	}
	
	

	
	
}
