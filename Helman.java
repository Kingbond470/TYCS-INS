// Diffie Helman Key Exchange algorithm 
import java.util.*;
class Helman {
    public static void main(String args[])
    {
        int n,g,x,y,A,B,k1,k2;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter 1st prime no: "); 	//taking two prime number as input on which sender and reciever are agree
        n=sc.nextInt();
        for(int i=2;i<n;i++)
        {
            if(n%2==0)
            {
                System.out.println("Enter prime no for n: ");
                n=sc.nextInt();
            }
        }
        System.out.println("Enter 2nd prime no: ");
        g=sc.nextInt();
        for(int i=2;i<g;i++) 		// choosing another large random number and calculating the a=g^x
        {
            if(g%2==0)
            {
                System.out.println("Enter prime no for g: ");
                g=sc.nextInt();
            }
            
        }
        System.out.println("Enter no for x: ");
        x=sc.nextInt();
        A=(int)(Math.pow(g,x)%n);
        System.out.println("Enter no for y: ");
        y=sc.nextInt();
        B=(int)(Math.pow(g,y)%n);
        k1=(int)(Math.pow(B,x)%n);
        k2=(int)(Math.pow(A,y)%n);
        System.out.println("k1: "+k1+" k2: "+k2);

    }
    
}