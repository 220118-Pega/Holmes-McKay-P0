/**
 * 
 */
package employees.db;
import employees.Employee;
import reimbursement.resources.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author McKay
 * This class allows access to the table containing employee information. 
 */
public class EmployeeDB {
	private static final Logger logger = LogManager.getLogger();
	
	public static Employee getEmployee(int id)
	{
		try (Connection conn=ConnectionFactory.getInstance().getConnection())
			{
				String query = "select * from employees where employee_id = ?";
				PreparedStatement pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, id);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next())
				{
					return new Employee(rs.getInt("employee_id"),rs.getString("first_name"), rs.getString("last_name"), rs.getBoolean("manager"),rs.getString("pw_encrypted"));
				}
			}catch (SQLException e)
			{
				logger.error("SQL Exception");
				e.printStackTrace();
			}
		return null;
	}
}
