/**
 * 
 */
package employees;

/**
 * @author McKay
 * This class allows creation of the Employee object
 */
public class Employee {
	private int id;
	private boolean manager;
	private String last_name;
	private String first_name;
	private Password password=null;
	
	public Employee ()
	{
		super();
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", manager=" + manager + ", last_name=" + last_name + ", first_name=" + first_name
				+ "]";
	}

	public Employee (int id, String first_name, String last_name, boolean manager, String pw_encrypted)
	{
		this.id=id;
		this.first_name=first_name;
		this.last_name=last_name;
		this.manager=manager;
		this.password= new Password(pw_encrypted, true);
	}
	
	public String getName()
	{
		if (!(last_name==null)) return (first_name+" "+last_name);
		return first_name;
	}

	public void setPassword(Password password) {
		this.password = password;
	}
	
	public Password getPassword()
	{
		return this.password;
	}

	public int getId() {
		return id;
	}

	public boolean isManager() {
		return manager;
	}

	public String getLast_name() {
		return last_name;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setManager(boolean manager) {
		this.manager = manager;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	
	
	
}
