package reimbursement.ui;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;
import reimbursement.RequestController;
import reimbursement.resources.Router;

public class RESTDriver {
    
	public static void main(String[] args) {
		RequestController controller = new RequestController();
		Javalin app = Javalin.create(config -> {
			config.addStaticFiles("C://Users//McKay//Documents/p0_html_files/index", Location.EXTERNAL);
		}).start(7000);
		
		Router router = new Router(app,controller);
		router.setUpEndpoints();
	}
}

//TODO
/*
 * add logging and unit testing
 * comment
 * 
 * if time: add employee name in view requests
 * only show review requests option if user is a manager
 * add documentation
 */

/*
 * BUGS:
 * 
 */