package reimbursement.resources;

import io.javalin.Javalin;
import reimbursement.RequestController;

public class Router {
	private Javalin app;
	private RequestController controller;
	public Router(Javalin app, RequestController controller)
	{
		this.app = app;
		this.controller = controller;
	} 
	public void setUpEndpoints() {
		
		app.post("/login",controller.login());
		
		app.post("/new_request", controller.new_request());
		
		app.post("/submit_request", controller.submit());
		
		app.post("view_requests", controller.view());
		
		app.post("/view_requests_selected", controller.view_selected());
		
		app.post("/review_requests", controller.review());
		
		app.post("/review_id", controller.review_selected());
		
		app.post("/logout", controller.logout());
		
		app.post("/approve", controller.approve());

		app.post("/decline", controller.deny());
		
		app.post("/gotoportal", controller.gotoportal());
	}
}
