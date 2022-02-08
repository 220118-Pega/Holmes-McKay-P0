package employees;
import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;

public class Password {
	private String pw_encrypted=null;
	public static final char[] invalid_characters = {'\'','\"','\\','\t','\b','\r','\f','\n',' '};
	public Password(String password)
	{
		if (badPassword(password))
		{
			System.out.println("Password contains invalid characters.");
			return;
		}
		this.pw_encrypted=Password.encrypt(password);
	}
	public Password(String password, boolean encrypted)
	{
		if (encrypted)
		{
			if (badPassword(password))
			{
				System.out.println("Password contains invalid characters.");
				return;
			}
			this.pw_encrypted=password;
		}
		else
		{
			new Password(password);
		}
	}
	
	
	public static String encrypt(String base)
	{
		try
		{
			String encrypted= new String();
			MessageDigest m = MessageDigest.getInstance("MD5");
			m.update(base.getBytes());
			byte[] bytes = m.digest();
			StringBuilder s = new StringBuilder();
			for (int i=0;i<bytes.length;i++)
			{
				s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			encrypted=s.toString();
			return encrypted;
		}
		catch (NoSuchAlgorithmException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public String getPw_encrypted()
	{
		return this.pw_encrypted;
	}
	

	public static boolean badPassword(String password)
	{
		for (int i = 0; i < invalid_characters.length; i++)
		{
			if (password.indexOf(invalid_characters[i]) != -1) return true;
		}
		return false;
	}
}
