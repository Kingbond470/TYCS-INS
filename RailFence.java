// Rail Fence cipher - it jumble the message using the algorithm
import java.util.*;
public class RailFence {
    public static void main(String args[])
    {
        String pt,et="",dt="";
        Scanner s=new Scanner(System.in);
        System.out.println("RAIL LIKE FENCE CIPHER");
        System.out.println("Enter the text/message: ");
        pt=s.nextLine();
        int r=2,c;
        int len=pt.length();
        if(len%2==0)
        {
            c=len/2;
        }
        else
        {
            c=(len/2)+1;
        }
        char[][] arr;
        int k=0;
        arr=new char[r][c];
        for(int i=0;i<c;i++)
        {
            for(int j=0;j<r;j++)
            {
                if(k!=len)
                {
                    arr[j][i]=pt.charAt(k++);
                }
                else
                {
                    arr[j][i]=' ';
                }
            }
        }
        System.out.println("Encrypted array is:");
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                System.out.println(arr[i][j]+"|");
            }
            System.out.println();
        }
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                et=et+arr[i][j];
            }
        }
        System.out.println("Encrypted Text is: "+et);
        int I=0;
        arr=new char[r][c];
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                arr[i][j]=et.charAt(I++);
            }
        }
        System.out.println("Decrypted array is: ");
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                System.out.println(arr[i][j]+"|");
            }
            System.out.println();
        }
        for(int i=0;i<c;i++)
        {
            for(int j=0;j<r;j++)
            {
                dt=dt+arr[j][i];
            }
        }
        System.out.println("Decrypted Text is: "+dt);
    }
}