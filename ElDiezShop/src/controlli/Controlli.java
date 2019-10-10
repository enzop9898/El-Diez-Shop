package controlli;

public class Controlli {
	public static boolean controlloPassword(String password) {
		boolean maiusc=false,number=false;
		if(password.length() < 8 || password.length()>16)
			return false;
		for(int i=0; i<password.length();i++)
		{
		char c=password.charAt(i);
		 if(Character.isUpperCase(c))
		 {
			 maiusc=true;
		 }
		}
		
			if(maiusc==false) return false;
		
		for(int i=0; i<password.length();i++)
		{
		char c=password.charAt(i);
		if(Character.isDigit(c))
		 {
			 number=true;
		 }
		}
			if(number==false) return false;

		return true;
	}
	
	public static boolean controlloUsername(String username)
	{
		if ((username.length() < 5) || (username.length() > 40))
			return false;
		else
			return true;
	}
}
