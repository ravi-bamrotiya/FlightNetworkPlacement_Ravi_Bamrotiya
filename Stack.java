import java.io.*;
public class Stack
{
	int data[];	
	int top;
	int np;
	boolean achieve=true;
	String output="";
	public Stack()
	{
		data=new int[10];		
		top=-1;
		np=0;
	}	
	public void push(int a)
	{
		if(a>9)
		{
			achieve=false;
			return;
		}
		++top;
		data[top]=a;
		np=a+1;
		output+="PUSH "+a+"  ";		
	}
	public void pop()
	{
		output+="POP "+data[top]+"  ";		
		top--;
	}
	
	public void isValid(int[] d)
	{		
		int index=0;
		while(achieve && (index<10))
		{
			boolean stop=true;
			for(int i=np;i<=d[index];i++)
			{
				push(i);	
				stop=false;
			}				
			while(d[index]==data[top])
			{
				index++;
				pop();
				stop=false;
				if(top==-1)
					break;
			}
			if(stop)
				achieve=false;
		}	

		if(achieve)
			System.out.println("Valid Sequence \n"+output);
		else
			System.out.println("Invalid Sequence");
		
	}
	
	public static void main(String[] args)
	{
		try
		{
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));	
			String str=br.readLine();
			int d[]=new int[10];
			if(str.length()<=10)
			{
				for(int i=0;i<str.length();i++)
				{				
					d[i]=(int)str.charAt(i);
					d[i]-=48;				
				}
				Stack s=new Stack();
				s.isValid(d);
			}
			else
				System.out.println("Invalid Sequence");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}	
}