import java.util.*;
public class vernam1{
	public static void main(String ar[ ]){ 		// array is defined
		char[ ] arr={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','y','z'};
		String plainText, key, encryptionText="" , decryptionText="";
		int [ ] arr1=null;		//to store the result other array is defined
		int pidx=0;
		int kidx=0;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the plain text and key : ");		// taking the user input
		plainText=sc.nextLine();				//from each new char line
		key=sc.nextLine();
		if(plainText.length()!=key.length()) 		//checking whether the length of text and key is equal or not
		{
			System.out.println("plain text and key must be of same length");
		}
		else
		{
			arr1=new int[plainText.length()];
		}
		for (int i=0;i<plainText.length();i++)
		{ 
			for (int j=0; j<arr.length;j++)
			{
				if(plainText.charAt(i)==arr[j])			//finding the character position from key and storing its position in pidx variable
					pidx=j;
			}
				arr1[i]=pidx;
		}
		for(int i=0;i<key.length();i++)
		{							//similarily finding the key character position and storing it in other array
			for (int j=0;j<arr.length;j++)
			{
				if(key.charAt(i)==arr[j])
					kidx=j;
			}
			arr1[i]=(arr1[i]+kidx)%52;
		}
		int I=0;
		for(int i=0;i<arr1.length;i++){
			if(I!=arr.length){
				encryptionText=encryptionText+arr[arr1[I++]];
				}
			}
		System.out.println("Encypted text is : "+encryptionText);

		for(int i=0;i<encryptionText.length();i++)		
		{
			for (int j=0;j<arr.length;j++)
			{
				if(encryptionText.charAt(i)==arr[j])
					pidx=j;
			}
			arr1[i]=pidx;
		}
		for(int i=0;i<key.length();i++)
		{
			for(int j=0;j<arr.length;j++)
			{		
				if(key.charAt(i)==arr[j])
					kidx=j;
			}
			arr1[i]=((arr1[i]-kidx)+52)%52;
				}
		int k=0;
		for (int i=0;i<arr.length;i++)
		{
			if(k!=arr1.length)
				decryptionText=decryptionText+arr[arr1[k++]];
		}
		System.out.println("Decryption text is : "+decryptionText);
	}
}
					