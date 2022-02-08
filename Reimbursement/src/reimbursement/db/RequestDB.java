package reimbursement.db;
import reimbursement.Request;
import reimbursement.Type;
import reimbursement.resources.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import employees.Employee;

/**
 * @author McKay
 * This class allows access to the request table
 * and contains methods to modify that table
 */
public class RequestDB{
	private static final Logger logger = LogManager.getLogger();
	public static Request getRequest(int id)
	{
		{
			try (Connection conn=ConnectionFactory.getInstance().getConnection())
				{
					String query = "select * from requests where request_id = ?";
					PreparedStatement pstmt = conn.prepareStatement(query);
					pstmt.setInt(1, id);
					ResultSet rs = pstmt.executeQuery();
					if(rs.next())
					{
						return new Request(
								rs.getInt("request_id"),
								rs.getInt("employee_id"),
								rs.getDouble("amount"),
								rs.getDate("date_requested").toLocalDate(),
								Type.valueOf(rs.getString("reimbursement_type")),
								rs.getString("description"),
								rs.getString("status"));
					}
				}catch (SQLException e)
				{
					logger.error("SQL Error");
					e.printStackTrace();
				}
			return null;
		}
	}
	
	public static List<Request> get_Requests()
	{
		List<Request> mylist = new ArrayList<Request>();
		try (Connection conn=ConnectionFactory.getInstance().getConnection())
		{
			String query = "select * from requests order by request_id asc";
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				Request request = new Request(
						rs.getInt("request_id"),
						rs.getInt("employee_id"),
						rs.getDouble("amount"),
						rs.getDate("date_requested").toLocalDate(),
						Type.valueOf(rs.getString("reimbursement_type")),
						rs.getString("description"),
						rs.getString("status"));
				mylist.add(request);
			}
		} catch (SQLException e)
		{
			logger.error("SQL Error");
			e.printStackTrace();
		}
		return mylist;
	}
	
	//prints all requests of a certain approval status
	public static List<Request> listRequests(String status)
	{
		List<Request>mylist = new ArrayList<Request>();
		try (Connection conn=ConnectionFactory.getInstance().getConnection())
		{
			String query = "select * from requests where status = ? order by request_id asc";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1,status);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				Request request = new Request(
						rs.getInt("request_id"),
						rs.getInt("employee_id"),
						rs.getDouble("amount"),
						rs.getDate("date_requested").toLocalDate(),
						Type.valueOf(rs.getString("reimbursement_type")),
						rs.getString("description"),
						rs.getString("status"));
				mylist.add(request);
			}
		} catch (SQLException e)
		{
			logger.error("SQL Error");
			e.printStackTrace();
		}
		return mylist;
	}
	
	public static void addRequest(int employee_id,double amount,Type type,String reason)
	{
		try (Connection conn=ConnectionFactory.getInstance().getConnection())
		{
			String query = "insert into requests (employee_id, amount,date_requested,reimbursement_type,description,status) values"
					+ "(?,?::float8::numeric::money,current_date,?::rtype,?,'Pending');";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, employee_id);
			pstmt.setDouble(2,amount);
			pstmt.setString(3, type.name().toUpperCase());
			pstmt.setString(4, reason);
			@SuppressWarnings("unused")
			int affected_rows = pstmt.executeUpdate();
		}catch (SQLException e)
		{
			logger.error("SQL Error");
			e.printStackTrace();
		}
	}
	
	public static void updateStatus(int id, String new_status)
	{
		try (Connection conn=ConnectionFactory.getInstance().getConnection())
		{
			String query = "update requests set status = ? where request_id = ?;";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1,new_status);
			pstmt.setInt(2, id);
			@SuppressWarnings("unused")
			int affected_rows = pstmt.executeUpdate();
		} catch (SQLException e)
		{
			logger.error("SQL Error");
			e.printStackTrace();
		}
	}
	
	
}
