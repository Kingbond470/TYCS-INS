// Advanced encryption standard(aes)
import javax.crypto.*;
import java.security.spec.*;
import javax.crypto.spec.*;
public class AES {
	Cipher ec,dc;
	AES(SecretKey key,String algorithm)
	{
	try{
		ec=Cipher.getInstance(algorithm);
		dc=Cipher.getInstance(algorithm);
		ec.init(Cipher.ENCRYPT_MODE, key);
		dc.init(Cipher.DECRYPT_MODE, key);
 	}
 	catch(Exception e)
 		{
 		e.printStackTrace();
	}
	}
	public String encrypt(String str)
 	{
 	try
 		{
 		byte[] u=str.getBytes("UTF-8");
 		byte[] enc=ec.doFinal(u);
 		return new sun.misc.BASE64Encoder().encode(enc);
 	}
 	catch(Exception e)
 		{
 		e.printStackTrace();
 		}
 	return null;
 	}
 	public String decrypt(String str)
 	{
 	try
 	{
 		byte[] dec=new sun.misc.BASE64Decoder().decodeBuffer(str);
 		byte[] u=dc.doFinal(dec);
 		return new String(u,"UTF-8");
 	}
 	catch(Exception e)
 	{
 		e.printStackTrace();
 	}
 	return null;
 	}
 	public static void test()
 	{
 	try
 	{
 		System.out.println("");
 		String secstr="siddhi";
 		SecretKey
		deskey=KeyGenerator.getInstance("AES").generateKey();
 		AES dec=new AES(deskey,deskey.getAlgorithm());
 		String desencrypt=dec.encrypt(secstr);
 		String desdecp=dec.decrypt(desencrypt);
 		System.out.println(deskey.getAlgorithm()+"Encrypted Algorithm");
 		System.out.println("The secret text key is: "+secstr);
 		System.out.println("");
 		System.out.println("The Encrypted String: "+desencrypt);
 		System.out.println("");
 		System.out.println("The Length of String: "+desdecp.length());
 		System.out.println("");
 		System.out.println("TheLength of String: "+desencrypt.length());
 		System.out.println("");
 		System.out.println("The Decrypted String: "+desdecp);
 		System.out.println("");
 	}
 	catch(Exception e)
 		{
 		e.printStackTrace();
 		}
 	}
 	public static void main(String args[])
 	{
 		test();
 	}
}