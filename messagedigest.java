// implement message digest algorithm
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
public class messagedigest {
 	public static void main(String args[])
 	{
 		System.out.println("For null: "+md5(" "));
 		System.out.println("For simple text: "+md5("Siddhi"));
 		System.out.println("For simple number: "+md5("25062001"));
 	}
 	public static String md5(String input)
 	{
 		String md5=null;
 		if(null==input)
 			return null;
 		try
 		{
 			MessageDigest digest=MessageDigest.getInstance("MD5");
 			digest.update(input.getBytes(),0,input.length());
 			md5=new BigInteger(1,digest.digest()).toString(16);
 		}
 		catch(NoSuchAlgorithmException e)
 		{
 			e.printStackTrace();
 		}
 	return md5;
 	}
}