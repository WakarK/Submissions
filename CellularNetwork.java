import java.io.*;
import java.util.*;

public class CellularNetwork
{
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int m=in.nextInt();
		int cities[]=new int[n];
		int towers[]=new int[m];
		for (int i=0;i<n;i++)
		{
			cities[i]=in.nextInt();
		}
		for(int i=0;i<m;i++)
		{
			towers[i]=in.nextInt();
		}
		int j=0,min=0,dist=Integer.MAX_VALUE;boolean b=true;
		for(int i =0;i<n;i++){
			b = false;
			dist = Integer.MAX_VALUE;
			while(j<m && Math.abs(cities[i]-towers[j])<=dist){
				dist = Math.abs(cities[i]-towers[j]);
				j++;
				b = true;
			}
			j--;
			if(b && dist>min) min = dist;
		}
		System.out.println(min);
	}
}