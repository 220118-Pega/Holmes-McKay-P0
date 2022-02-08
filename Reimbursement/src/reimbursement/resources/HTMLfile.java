package reimbursement.resources;

import reimbursement.Request;

//this class creates the webpages used in the project

public class HTMLfile {
	public static HTMLFactory Portal()
	{
		HTMLFactory portal = new HTMLFactory();
		portal.setTitle("Reimbursement Portal");
		portal.setCss(".button {\r\n"
				+ "            border: none;\r\n"
				+ "            color: white;\r\n"
				+ "            padding: 16px 32px;\r\n"
				+ "            text-align: center;\r\n"
				+ "            text-decoration: none;\r\n"
				+ "            display: inline-block;\r\n"
				+ "            font-size: 16px;\r\n"
				+ "            margin: 4px 2px;\r\n"
				+ "            transition-duration: 0.4s;\r\n"
				+ "            cursor: pointer;\r\n"
				+ "        }\r\n"
				+ "\r\n"
				+ "        .button1 {\r\n"
				+ "            background-color: white; \r\n"
				+ "            color: black; \r\n"
				+ "            border: 2px solid #4CAF50;\r\n"
				+ "        }\r\n"
				+ "\r\n"
				+ "        .button1:hover {\r\n"
				+ "            background-color: #4CAF50;\r\n"
				+ "            color: white;\r\n"
				+ "        }"
				+ "        .button2 {\r\n"
				+ "            background-color: white;\r\n"
				+ "            color: black;\r\n"
				+ "            border: 2px solid #00758F;\r\n"
				+ "        }\r\n"
				+ "\r\n"
				+ "        .button2:hover {\r\n"
				+ "            background-color: #00758F;\r\n"
				+ "            color: white;\r\n"
				+ "        }\r\n"
				+ "\r\n"
				+ "        div.absolute {\r\n"
				+ "        position: absolute;\r\n"
				+ "        width: 80%;\r\n"
				+ "        bottom: 10px;\r\n"
				+ "        border: none\r\n"
				+ "        } \r\n"
				+ "\r\n"
				+ "        body {\r\n"
				+ "            height: 2000px;\r\n"
				+ "        }");
		portal.setBody("        <div class=\"w3-container w3-black\">\r\n"
				+ "            <h1>Reimbursement Portal</h1>\r\n"
				+ "        </div>\r\n"
				+ "\r\n"
				+ "        <br>\r\n"
				+ "\r\n"
				+ "        <form method=\"post\", action =\"/new_request\", style=\"margin: auto; width: 500px;\">\r\n"
				+ "            <button class=\"button button1\", type=\"submit\">Submit a reimbursement request</button>\r\n"
				+ "        </form>\r\n"
				+ "        <br>\r\n"
				+ "        <form method=\"post\", action =\"/view_requests\", style=\"margin: auto; width: 500px;\">\r\n"
				+ "            <button class=\"button button1\", type=\"submit\">View all reimbursement requests</button>\r\n"
				+ "        </form>\r\n"
				+ "        <br>\r\n"
				+ "        <form method=\"post\", action =\"/review_requests\", style=\"margin: auto; width: 500px;\">\r\n"
				+ "            <button class=\"button button1\", type=\"submit\">Review reimbursement requests</button>\r\n"
				+ "        </form>"
				+ ""
				+ "        <form method=\"post\" action = \"/logout\" style=\"margin: auto; width: 500px; display: inline-block; bottom: 200px; position: fixed;\">\r\n"
				+ "            <button class = \"button button2\" type=\"submit\" style=\"margin: 10px; width: 500px; left: 10px; position: fixed;\">Log out</button>\r\n"
				+ "        </form>\r\n"
				+ "        <form method=\"post\" action = \"/gotoportal\" style=\"margin: auto; width: 500px; display: inline-block; bottom: 200px; position: fixed;\">\r\n"
				+ "            <button class = \"button button2\" type=\"submit\" style=\"margin: 10px; width: 500px; right: 10px; position: fixed;\">Reimbursement Home</button>\r\n"
				+ "        </form>");
		
		portal.compile();
		return portal;
	}
	
	public static HTMLFactory Login()
	{
		HTMLFactory login = new HTMLFactory();
		login.setTitle("Log in");
		login.setBody("        <div class=\"w3-container w3-black\">\r\n"
				+ "            <h1>Reimbursement Portal</h1>\r\n"
				+ "        </div>\r\n"
				+ "\r\n"
				+ "        <br>\r\n"
				+ "        <p style=\"text-align: center;\">\r\n"
				+ "        <form method=\"post\", action=\"/login\">\r\n"
				+ "            <fieldset>\r\n"
				+ "                <legend>User Credentials</legend>\r\n"
				+ "            <label for=\"id\">Employee ID:</label>\r\n"
				+ "            <input type=\"number\" id=\"id\" name=\"id\">\r\n"
				+ "            <label for=\"password\">Password:</label>\r\n"
				+ "            <input type=\"password\" id=\"password\" name=\"password\">\r\n"
				+ "            <br>\r\n"
				+ "            <button type=\"submit\"> Log In </button>\r\n"
				+ "            </fieldset> \r\n"
				+ "        </form>\r\n"
				+ "        </p>");
		login.compile();
		return login;
	}

	public static HTMLFactory Submit()
	{
		HTMLFactory submit = new HTMLFactory();
		submit.setTitle("Submit a request");
		submit.setCss("form {\r\n"
				+ "                margin-left: 10%;\r\n"
				+ "            }\r\n"
				+ "\r\n"
				+ "            input {\r\n"
				+ "                width: 80%;\r\n"
				+ "                margin: 8px 0;\r\n"
				+ "                padding: 12px 20px;\r\n"
				+ "                box-sizing: border-box;\r\n"
				+ "                border: 2px solid #4CAF50;\r\n"
				+ "            }\r\n"
				+ "\r\n"
				+ "            input:focus {\r\n"
				+ "                background-color: solid #ebfdff;\r\n"
				+ "            }\r\n"
				+ "\r\n"
				+ "            label {\r\n"
				+ "                padding: 12px 12px 12px 0;\r\n"
				+ "                display: inline-block;\r\n"
				+ "                color: black;\r\n"
				+ "            }\r\n"
				+ "\r\n"
				+ "            select {\r\n"
				+ "                width: 80%;\r\n"
				+ "                padding: 16px 20px;\r\n"
				+ "                border-color: #4CAF50;\r\n"
				+ "                border-width: 2px;\r\n"
				+ "                background-color: solid white;\r\n"
				+ "            }\r\n"
				+ "\r\n"
				+ "            .button {\r\n"
				+ "            border: none;\r\n"
				+ "            color: white;\r\n"
				+ "            padding: 16px 32px;\r\n"
				+ "            text-align: center;\r\n"
				+ "            text-decoration: none;\r\n"
				+ "            display: inline-block;\r\n"
				+ "            font-size: 16px;\r\n"
				+ "            margin: 4px 2px;\r\n"
				+ "            transition-duration: 0.4s;\r\n"
				+ "            cursor: pointer;\r\n"
				+ "            width: 80%;\r\n"
				+ "            }\r\n"
				+ "\r\n"
				+ "            .button1 {\r\n"
				+ "                background-color: white; \r\n"
				+ "                color: black; \r\n"
				+ "                border: 2px solid #4CAF50;\r\n"
				+ "            }\r\n"
				+ "\r\n"
				+ "            .button1:hover {\r\n"
				+ "                background-color: #4CAF50;\r\n"
				+ "                color: white;\r\n"
				+ "            }\r\n"
				+ "\r\n"
				+ "            .description {\r\n"
				+ "                height: 200px;\r\n"
				+ "                resize: none;\r\n"
				+ "            }"
				+ ""
				+ "        .button2 {\r\n"
				+ "            background-color: white;\r\n"
				+ "            color: black;\r\n"
				+ "            border: 2px solid #00758F;\r\n"
				+ "        }\r\n"
				+ "\r\n"
				+ "        .button2:hover {\r\n"
				+ "            background-color: #00758F;\r\n"
				+ "            color: white;\r\n"
				+ "        }\r\n"
				+ "\r\n"
				+ "        div.absolute {\r\n"
				+ "        position: absolute;\r\n"
				+ "        width: 80%;\r\n"
				+ "        bottom: 10px;\r\n"
				+ "        border: none\r\n"
				+ "        } \r\n"
				+ "\r\n"
				+ "        body {\r\n"
				+ "            height: 2000px;\r\n"
				+ "        }");
		submit.setBody("<div class=\"w3-container w3-black\">\r\n"
				+ "            <h1>Reimbursement Portal</h1>\r\n"
				+ "        </div>\r\n"
				+ "\r\n"
				+ "        <form method=\"post\" action=\"/submit_request\">\r\n"
				+ "            <input type=\"number\" id=\"amount\" name=\"amount\" placeholder=\"Amount..\"  autocomplete=\"off\" required=\"true\" step=\".01\">\r\n"
				+ "            <br>\r\n"
				+ "            <select id=\"type\" name=\"type\">\r\n"
				+ "                <option value=\"LODGING\">Lodging</option>\r\n"
				+ "                <option value=\"TRAVEL\">Travel</option>\r\n"
				+ "                <option value=\"FOOD\">Food</option>\r\n"
				+ "                <option value=\"OTHER\">Other</option>\r\n"
				+ "            </select>\r\n"
				+ "            <br>\r\n"
				+ "            <input class=\"description\" type=\"text\" id = \"reason\" name = \"reason\" placeholder=\"Description..\" autocomplete=\"off\">\r\n"
				+ "            <br>\r\n"
				+ "            <button class=\"button button1\" type = \"submit\">Submit</button>\r\n"
				+ "        </form>"
				+ ""
				+ "        <form method=\"post\" action = \"/logout\" style=\"margin: auto; width: 500px; display: inline-block; bottom: 200px; position: fixed;\">\r\n"
				+ "            <button class = \"button button2\" type=\"submit\" style=\"margin: 10px; width: 500px; left: 10px; position: fixed;\">Log out</button>\r\n"
				+ "        </form>\r\n"
				+ "        <form method=\"post\" action = \"/gotoportal\" style=\"margin: auto; width: 500px; display: inline-block; bottom: 200px; position: fixed;\">\r\n"
				+ "            <button class = \"button button2\" type=\"submit\" style=\"margin: 10px; width: 500px; right: 10px; position: fixed;\">Reimbursement Home</button>\r\n"
				+ "        </form>");
		submit.compile();
		
		return submit;
	}

	public static HTMLFactory View()
	{
		HTMLFactory view = new HTMLFactory();
		view.setTitle("View requests");
		view.setCss("      .button {\r\n"
				+ "            border: none;\r\n"
				+ "            color: white;\r\n"
				+ "            padding: 16px 32px;\r\n"
				+ "            text-align: center;\r\n"
				+ "            text-decoration: none;\r\n"
				+ "            display: inline-block;\r\n"
				+ "            font-size: 16px;\r\n"
				+ "            margin: 4px 2px;\r\n"
				+ "            transition-duration: 0.4s;\r\n"
				+ "            cursor: pointer;\r\n"
				+ "        }\r\n"
				+ "\r\n"
				+ "        .button2 {\r\n"
				+ "            background-color: white;\r\n"
				+ "            color: black;\r\n"
				+ "            border: 2px solid #00758F;\r\n"
				+ "        }\r\n"
				+ "\r\n"
				+ "        .button2:hover {\r\n"
				+ "            background-color: #00758F;\r\n"
				+ "            color: white;\r\n"
				+ "        }");
		view.setBody("<div class=\"w3-container w3-black\">\r\n"
				+ "            <h1>Reimbursement Portal</h1>\r\n"
				+ "        </div>\r\n"
				+ "\r\n"
				+ "        <form action=\"/view_requests_selected\" method=\"post\">\r\n"
				+ "            <fieldset>\r\n"
				+ "                <legend>Which requests would you like to view?</legend>\r\n"
				+ "                <input type=\"checkbox\" id=\"Pending\" name=\"Pending\" value=\"true\">\r\n"
				+ "                <label for = \"Pending\">Pending</label>\r\n"
				+ "                <br>\r\n"
				+ "                <input type=\"checkbox\" id=\"Approved\" name = \"Approved\" value=\"true\">\r\n"
				+ "                <label for = \"Approved\">Approved</label>\r\n"
				+ "                <br>\r\n"
				+ "                <input type=\"checkbox\" id=\"Declined\" name = \"Declined\" value=\"true\">\r\n"
				+ "                <label for = \"Declined\">Declined</label>\r\n"
				+ "                <br>\r\n"
				+ "                <button type=\"submit\">View requests</button>\r\n"
				+ "            </fieldset>\r\n"
				+ "        </form>"
				+ ""
				+ "        <form method=\"post\" action = \"/logout\" style=\"margin: auto; width: 500px; display: inline-block; bottom: 200px; position: fixed;\">\r\n"
				+ "            <button class = \"button button2\" type=\"submit\" style=\"margin: 10px; width: 500px; left: 10px; position: fixed;\">Log out</button>\r\n"
				+ "        </form>\r\n"
				+ "        <form method=\"post\" action = \"/gotoportal\" style=\"margin: auto; width: 500px; display: inline-block; bottom: 200px; position: fixed;\">\r\n"
				+ "            <button class = \"button button2\" type=\"submit\" style=\"margin: 10px; width: 500px; right: 10px; position: fixed;\">Reimbursement Home</button>\r\n"
				+ "        </form>");
		view.compile();
		return view;
	}

	public static HTMLFactory Review()
	{
		HTMLFactory review = new HTMLFactory();
		review.setTitle("Review requests");
		review.setCss("                    .button {\r\n"
				+ "            border: none;\r\n"
				+ "            color: white;\r\n"
				+ "            padding: 16px 32px;\r\n"
				+ "            text-align: center;\r\n"
				+ "            text-decoration: none;\r\n"
				+ "            display: inline-block;\r\n"
				+ "            font-size: 16px;\r\n"
				+ "            margin: 4px 2px;\r\n"
				+ "            transition-duration: 0.4s;\r\n"
				+ "            cursor: pointer;\r\n"
				+ "        }\r\n"
				+ "\r\n"
				+ "        .button2 {\r\n"
				+ "            background-color: white;\r\n"
				+ "            color: black;\r\n"
				+ "            border: 2px solid #00758F;\r\n"
				+ "        }\r\n"
				+ "\r\n"
				+ "        .button2:hover {\r\n"
				+ "            background-color: #00758F;\r\n"
				+ "            color: white;\r\n"
				+ "        }");
		review.setBody("        <div class=\"w3-container w3-black\">\r\n"
				+ "            <h1>Reimbursement Portal</h1>\r\n"
				+ "        </div>\r\n"
				+ "        <form method=\"post\" action=\"/review_id\">\r\n"
				+ "            <input type = \"number\"id = \"request_id\" name=\"request_id\" placeholder=\"Enter the request ID..\">\r\n"
				+ "            <br>\r\n"
				+ "            <button type=\"submit\">Submit</button>\r\n"
				+ "        </form>\r\n"
				+ "\r\n"
				+ "        <form method=\"post\" action = \"/logout\" style=\"margin: auto; width: 500px; display: inline-block; bottom: 200px; position: fixed;\">\r\n"
				+ "            <button class = \"button button2\" type=\"submit\" style=\"margin: 10px; width: 500px; left: 10px; position: fixed;\">Log out</button>\r\n"
				+ "        </form>\r\n"
				+ "        <form method=\"post\" action = \"/gotoportal\" style=\"margin: auto; width: 500px; display: inline-block; bottom: 200px; position: fixed;\">\r\n"
				+ "            <button class = \"button button2\" type=\"submit\" style=\"margin: 10px; width: 500px; right: 10px; position: fixed;\">Reimbursement Home</button>\r\n"
				+ "        </form>");
		review.compile();
		return review;
	}
	
	public static HTMLFactory ReviewAppend(Request request)
	{
		HTMLFactory review = Review();
		String entry = request.toString();
		String added = "<div class = \"request\">" + entry + "</div>\r\n"
				+ "        <br>\r\n"
				+ "        <form method=\"post\" action=\"/approve\">\r\n"
				+ "            <button class=\"button button1\" type=\"submit\">Approve</button>\r\n"
				+ "        </form>\r\n"
				+ "        <form method=\"post\" action=\"/decline\">\r\n"
				+ "            <button class=\"button button1\" type=\"submit\">Deny</button>\r\n"
				+ "        </form>\r\n";
		String css_added = ("            .request{\r\n"
				+ "                margin:4px 2px;\r\n"
				+ "                width: 50%;\r\n"
				+ "                text-align: center;\r\n"
				+ "            }\r\n"
				+ "\r\n"
				+ "            .button1 {\r\n"
				+ "width: 80%;\r\n"
				+ "                background-color: white; \r\n"
				+ "                color: black; \r\n"
				+ "                border: 2px solid #4CAF50;\r\n"
				+ "            }\r\n"
				+ "\r\n"
				+ "            .button1:hover {\r\n"
				+ "width: 80%;/r/n"
				+ "                background-color: #4CAF50;\r\n"
				+ "                color: white;\r\n"
				+ "            }\r\n"
				+ "            form {\r\n"
				+ "                margin-left: 10%;\r\n"
				+ "            }");
		review.setCss(review.getCss()+css_added);
		review.setBody(review.getBody()+added);
		review.compile();
		return review;
	}
	
	
	
}