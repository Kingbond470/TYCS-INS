# simple columnar cipher
import java.util.*;
public class columnar
{
	String pt,et=" ",dt=" ";
	char[] [] arr;
	int [] arr1;
	int r,c;
	public columnar(int x, int y)		// constructor
	{
		r=x;
		c=y;	
		arr=new char[r][c];
	}
	public void encrypt(String pt1,int num)		// method encrypt creation
	{
	pt=pt1;
	et=" ";
	if(num>=1)			// number should be greater than 1
		{
		int k=0;
		for(int i=0;i<r;i++){
			for(int j=0;j<c;j++){
				if(k!=pt.length())
					arr[i][j]=pt.charAt(k++);
				else
					arr[i][j]=' ' ;
					}
		
				}
		System.out.println("Encrypted array: ");
		for(int i=0;i<r;i++)
			{
			for (int j=0;j<c;j++)
				{
				System.out.println(arr[i][j]+"I");
				}
			System.out.println(" ");
			}
			arr1=new int[c];
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the column number: ");
			for(int i=0;i<arr1.length;i++)
				{
				arr1[i]=sc.nextInt();
				}
			for(int j=0;j<arr1.length;j++)
				{
				for(int i=0;i<r;i++)
					{
					et=et+arr[i][arr1[j]];
					}
				}
			System.out.println("Encrypted text: "+et);
			encrypt(et,num-1);
		}	
	}
	public static void main(String args[])
	{
		String msg;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the plaintext: ");
		msg=sc.nextLine();
		int col,row;	
		System.out.println("enter the size: ");
		col=sc.nextInt();
		int rem, m;
		rem=msg.length()%col;
		m=msg.length()%col;
		if(m>0 && m<col)
			{
			rem=rem+1;
			}
		row=rem;
		columnar s1=new columnar(row,col);		// calling a constructor class
		s1.encrypt(msg,1);				// calling a method
	}
}