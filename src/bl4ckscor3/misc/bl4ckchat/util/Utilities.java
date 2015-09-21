package bl4ckscor3.misc.bl4ckchat.util;

public class Utilities
{
	public static boolean isOnlyNumbers(String text)
	{
		try
		{
			Integer.parseInt(text);
		}
		catch(NumberFormatException e)
		{
			return false;
		}
		
		return true;
	}
}
