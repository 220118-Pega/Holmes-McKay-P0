package reimbursement;

import java.time.*;



public class Request {	
	
	private int id;
	private int employee_id;
	private LocalDate date_submitted=LocalDate.now();
	private double amount;
	private Type type;
	private String approved;
	private String reason;
	
	
	public Request()
	{
		super();
	}
	
	

	
	public Request(int id, int employee_id, double amount, String reason, Type type) {
		super();
		this.id = id;
		this.employee_id = employee_id;
		this.amount = amount;
		this.type = type;
		this.reason = reason;
		this.approved = "Pending";
	}




	public Request(int request_id, int employee_id, double amount, LocalDate date, Type type, String description, String status) {
		this.id = request_id;
		this.employee_id=employee_id;
		this.amount=amount;
		this.date_submitted=date;
		this.type=type;
		this.reason=description;
		this.approved=status;
	}




	@Override
	public String toString() {
		if (id==0) return "Request [employee_id=" + employee_id + ", date_submitted=" + date_submitted + ", amount=$"
				+ String.format("%.2f",amount) + ", type=" + type + ", reason=" + reason + ", approved=" + approved + "]";
		return "<br>Request ID: " +id
				+ "<br>Employee ID: " + employee_id
				+ "<br>Date submitted: " + date_submitted
				+ "<br>Amount: $" + amount
				+ "<br>Type: " + type
				+ "<br>Description: " + reason
				+ "<br>Approval Status: " +approved;
	}
	
	

	public int getEmployee_id() {
		return employee_id;
	}

	public LocalDate getDate_submitted() {
		return date_submitted;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}


	public int getId() {
		return id;
	}

	public double getAmount() {
		return amount;
	}

	public Type getType() {
		return type;
	}

	public String getApproved() {
		return approved;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public void setType(Type type) {
		this.type = type;
	}
	
	public static Type readType(String input)
	{
		switch (input)
		{
		case "LODGING":
			return Type.LODGING;
		case "TRAVEL":
			return Type.TRAVEL;
		case "FOOD":
			return Type.FOOD;
		case "OTHER":
			return Type.OTHER;
		default:
			System.out.println("Invalid input");
			return null;
		}
	}

	public void setApproved(String string) {
		this.approved = string;
	}
	
	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}


	
	
}
