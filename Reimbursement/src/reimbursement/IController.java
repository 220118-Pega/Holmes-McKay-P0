package reimbursement;

import io.javalin.http.Handler;

public interface IController {
	Handler login();
	Handler gotoportal();
	Handler new_request();
	Handler submit();
	Handler view();
	Handler view_selected();
	Handler review();
	Handler review_selected();
	Handler logout();
	Handler approve();
	Handler deny();
}
