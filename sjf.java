import java.util.*;
class sjf
{
	public static void main(String...args)
	{
		Scanner s1=new Scanner(System.in);
		int n,i,k,k3;
		String k1;
		System.out.println("Enter number of processors");
		n=s1.nextInt();
		int at[]=new int[n];
		int bt[]=new int[n];
		int bt1[]=new int[n];
		String p[]=new String[n];
		for(i=0;i<n;i++)
		{
			System.out.println("enter processor,Arrival time and burst time and burst time<10");
			p[i]=s1.next();
			at[i]=s1.nextInt();
			bt[i]=s1.nextInt();
		}
		for(i=0;i<n;i++)
		{
			for(int j=2;j<n;j++)
			{
				k=at[j];
				at[j]=at[j-1];
				at[j-1]=k;
				k=bt[j];
				bt[j]=bt[j-1];
				bt[j-1]=k;
				k1=p[j];
				p[j]=p[j-1];
				p[j-1]=p[j];
				
			}
				
		}
		int c[]=new int[n];
		boolean check=true;
		for(i=0;i<n;i++)
		{
			bt1[i]=bt[i];
		}
		while(check)
		{
			for(i=0;i<n;i++)
			{
				if(i==0)
				{
					if(bt1[i]>10)
					{
						c[i]=at[i]+10;
						bt1[i]=bt1[i]-10;
					}
					else 
					{
						c[i]=bt1[i]+at[i];
						bt1[i]=0;
					}
				}
				else 
				{
					if(at[i]<=c[i-1])
					{
						if(bt1[i]>10)
						{
							c[i]=c[i-1]+10;
							bt1[i]=bt1[i]-10;
						}
						else 
						{
							c[i]=c[i-1]+bt1[i];
							bt1[i]=0;
						}
						
					}
				}
			}
			k3=0;
			for(i=0;i<n;i++)
			{
				k3=k3+bt1[i];
			}
			if(k3==0)
			{
				check=false;
			}
			
		}
		int tat[]=new int[n];
		int wt[]=new int[n];
		double s11=0,s12=0;
		double avgtat,avgwt;
		for(i=0;i<n;i++)
		{
			tat[i]=c[i]-at[i];
			wt[i]=tat[i]-bt[i];
		}
		for(i=0;i<n;i++)
		{
			s11=s11+tat[i];
			s12=s12+wt[i];
		}
		avgtat=s11/n;
		avgwt=s12/n;
		System.out.println("Processor Arrival time Burst time completion time waiting time turn around time");
		for(i=0;i<n;i++)
		{
			System.out.println(p[i]+"             "+at[i]+"              "+bt[i]+"            "+c[i]+"            "+wt[i]+"              "+tat[i]);
		}
		System.out.println("average turn around time is equal to "+avgtat);
		System.out.println("average waiting time is equal to "+avgwt);
		System.out.print("order of execution is ");
		for(String l:p)
		{
			System.out.print(l+" ");
		}
		
		
	}
}
		