// DES Algorithm ......it uses the 16 rounds and each round perform the steps of substitution and transposition
import java.security.*;
import javax.crypto.*;
import java.security.spec.*;
import javax.crypto.spec.*;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

import java.security.Key;
import java.security.SecureRandom;

public class DES{
	public static void main(String args[]){
		testUsingSecretKey();
	}
	Cipher ecipher;
	Cipher dcipher;
	public DES(SecretKey key,String algorithm)
	{
		try
		{
			ecipher=Cipher.getInstance(algorithm);
			dcipher=Cipher.getInstance(algorithm);
			ecipher.init(Cipher.ENCRYPT_MODE,key);
			dcipher.init(Cipher.DECRYPT_MODE,key);	
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
				byte[] utf8=str.getBytes("UTF-8");
				byte[] enc=ecipher.doFinal(utf8);
				return new sun.misc.BASE64Encoder().encode(enc);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return null;
		}
		public String decrypt(String str){
			try{
				byte[] dec=new sun.misc.BASE64Decoder().decodeBuffer(str);
				byte[] u=dcipher.doFinal(dec);
				return new String(u,"UTF8");		
				}
			catch(Exception e){
				e.printStackTrace();
				}
			return null;
		}
		public static void testUsingSecretKey(){
			try{
				System.out.println("");
				String SecretString="Siddhi";
				KeyGenerator keyGen = KeyGenerator.getInstance("DES");
 				//keyGen.init(128);
        				SecretKey deskey = keyGen.generateKey();

				//KeyGenerator deskey = KeyGenerator.getInstance("DES").generateKey();
				//SecretKey deskey=KeyGenerator.getInsace("DES").generateKey();

				DES desEncrypter=new DES(deskey,deskey.getAlgorithm());
				String desEncrypted=desEncrypter.encrypt(SecretString);	
				String desDecrypted=desEncrypter.decrypt(desEncrypted);
				System.out.println("The secret string:"+SecretString);
				System.out.println("");
				System.out.println("");
				System.out.println("Encrypted string"+desEncrypted);
				System.out.println("");
				System.out.println("Length of string:"+desEncrypted.length());
				System.out.println("");
				System.out.println("Decrypted string:"+desDecrypted);
				System.out.println("");
				}
			catch(NoSuchAlgorithmException e){
				e.printStackTrace();
				}
		}		
	
}