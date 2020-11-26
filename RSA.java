// RSA algorithm ,it uses the two different key which is public and private key as name suggest public key can be accesed by anyone but private ...No


import java.io.*;
import java.math.*;
import java.io.BufferedReader.*;
class RSA
	{
	public static void main(String args[])throws IOException{
		RSA obj=new RSA();
		obj.accept();
		}
	public void accept() throws IOException{
		InputStreamReader r=new InputStreamReader(System.in);		// taking input as inputstreamreader which takes input and read as stream of characters
		BufferedReader br=new BufferedReader(r);
		System.out.println("Enter the prime no p: ");
		int a=Integer.parseInt(br.readLine());	//readLine read the next the next line and returns it in string format
		System.out.println("Enter the prime no q: ");
		int b=Integer.parseInt(br.readLine());
		boolean f1=checkprime(a);		// to check whether the input number is prime number or not........
		boolean f2=checkprime(b);
		if(f1&&f2)
		{
		op(a,b);
		}
		else
		{
		System.out.println("Error: Enter only the prime no: ");		// if input number is not prime number than enter the number again and it should be prime
		accept();
		}
	}
	public void op(int a, int  b) throws IOException
	{
	InputStreamReader r1=new InputStreamReader(System.in);
	BufferedReader br=new BufferedReader(r1);		// taking multiple input as requirements
	BigInteger p=BigInteger.valueOf(a);
	BigInteger q=BigInteger.valueOf(b);
	BigInteger one=new BigInteger("1");
	BigInteger n=p.multiply(q);
	BigInteger temp1=p.subtract(one);
	BigInteger temp2=q.subtract(one);
	BigInteger mul=temp1.multiply(temp2);
	System.out.println("enter the no for division: ");
	 int c =Integer.parseInt(br.readLine());
	BigInteger d=BigInteger.valueOf(c);
	
	while(true)
	{
		BigInteger r=mul.gcd(d);
		if(r.toString().equals("1"))
		{
			break;
		}
		d=d.add(one);
	}
	BigInteger n1=new BigInteger("0");
	BigInteger zero=new BigInteger("0");
	BigInteger de;
	while(true){									// for decryption 
		if((one.add(n1.multiply(mul))).remainder(d).toString().equals(zero.toString())){
			de=n1.multiply(mul).add(one).divide(d);
			break;
			}
		n1=n1.add(one);
		}
	System.out.println("Enter the number for encryption: ");		//	finally printing the multiple statements
	int o=Integer.parseInt(br.readLine());
	BigInteger p1=BigInteger.valueOf(o);	
	System.out.println("value of (p1*q)is: "+n);
	System.out.println("");
	System.out.println("value fo (p1-1)(Q-1)is : "+mul);
	System.out.println("");
	System.out.println("value of D is: "+d);	
	System.out.println("");
	System.out.println("value of NI is: "+n1);
	System.out.println("");
	System.out.println("value of DE is: "+"(c1+(n1*mul))/d) is: "+de);
	System.out.println("");
	System.out.println("public key is : "+n+" " +de);
	System.out.println("");
	System.out.println("private key is : "+n+" "+d);
	System.out.println("");
	BigInteger p2=new BigInteger("10");
	BigInteger en=p1.modPow(d,n);			// using the math function and finding the power	
	System.out.println("decrypted no is: "+en);
	p1=en.modPow(de,n);
	System.out.println("decrypted no is : "+p1);
	System.out.println("");
	}
	public boolean checkprime(int no){			// to check the prime number
		for(int i=2;i<no;i++)
			if(no%i==0)
				return false;
		return true;
	}
}