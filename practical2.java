import java.util.Scanner;
//mono alphabetic substitution cipher
public class practical2{
    public static final String ALPHABET="abcdefghijklmnopqrstuvwxyz";
    public static final String Key="zyxwvutsrqponmlkjihgfedcba";
	//Encrypt function will return the cipher text
    public static String Encrypt(String plainText)
    {
        plainText=plainText.toLowerCase();   //converting into lowercase
        String cipherText="";
        for(int i=0;i<plainText.length();i++)
        {
            if(plainText.charAt(i)!=' ') 			//checking if the input does not contain the space
            {
                int charposition=ALPHABET.indexOf(plainText.charAt(i));	//finding the pos of character
                char replaceVal=Key.charAt(charposition);
                cipherText+=replaceVal;
            }
            else
            {
                cipherText+=' ';
            }
        }
        return cipherText;	
    }
	// Decrypt function will return the plainText
    public static String Decrypt(String cipherText)
    {
        cipherText=cipherText.toLowerCase();
        String plainText="";
        for(int i=0;i<cipherText.length();i++)
        {
            if(cipherText.charAt(i)!=' ')
            {
                int charposition=Key.indexOf(cipherText.charAt(i));
                char replaceVal=ALPHABET.charAt(charposition);
                plainText+=replaceVal;
            }
            else
            {
                plainText+=' ';
            }
        }
        return plainText;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter text  for encryption and decryption:");
        String Message=new String();
        Message=sc.nextLine();
        System.out.println("Encrypted Message:"+Encrypt(Message));
        System.out.println("Decrypted Message:"+Decrypt(Encrypt(Message)));
        sc.close();
    }
}
