import java.io.*;
public class Game
{		
	public static void main(String[] args)
	{
		int m=0;
		int n=0;
		try
		{
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));	
			System.out.print("How many Kids: ");
			m=Integer.parseInt(br.readLine());
			System.out.print("Random Number: ");
			n=Integer.parseInt(br.readLine());
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		if(m>n)
		{
			boolean test[]=new boolean[m];
			int index=0;			
			for(int i=0;i<m;i++)
				test[i]=true;
			int old_m=m;
			while(m>1)
			{
				for(int i=0;i<n;)
				{
					if(test[index]==true)
					{						
						index++;	
						i++;						
					}
					else
					{						
						while(!test[index])
						{							
							index++;
							if(index==old_m)					
								index=0;					
						}						
					}						
					if(index==old_m)
						index=0;
				}
				if(index==0)				
					test[old_m-1]=false;			
				else
					test[index-1]=false;
				m--;
			}
			for(int i=0;i<old_m;i++)
			{
				if(test[i])
					System.out.println("Winner Position is: "+(i+1));
			}
		}
		else
			System.out.println("Invalid Input ");			
		
	}	
}