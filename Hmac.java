// Keyed- Hashing for messages authentication code
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.Formatter;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
public class Hmac
{
 	public static final String HMAC_SHA1_ALGORITHM="HmacSHA1";
 	private static String toHexString(byte[] bytes)
 	{
 		Formatter formatter=new Formatter();
 		for(byte b:bytes)
 		{
 			formatter.format("%02x",b);
 		}
 		return formatter.toString();
	 }
 	public static String calculateRFC2104HMAC(String data, String key)throws SignatureException,NoSuchAlgorithmException,InvalidKeyException
 	{
 		SecretKeySpec signingKey=new SecretKeySpec(key.getBytes(),HMAC_SHA1_ALGORITHM);
 		Mac mac=Mac.getInstance(HMAC_SHA1_ALGORITHM);
 		mac.init(signingKey);
 		return toHexString(mac.doFinal(data.getBytes()));
 	}
 	public static void main(String args[])throws Exception
 	{
 		System.out.println("Keyed-Hashing for Message Authentication Code(HMAC)");
 		String hmac=calculateRFC2104HMAC("data","key");
 		System.out.println(hmac);
 		assert hmac.equals("104152c5bfdca07bc633eebd46199f0255c9f49d");
 	}
}