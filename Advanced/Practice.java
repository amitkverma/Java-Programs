import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;

public class Practice
{
	public static StringBuilder output=new StringBuilder();

	public static void main(String[] args) throws Exception 
	{
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			String str=reader.readLine();
			while(str!=null)
			{
				removeComments(str,reader);
				str=reader.readLine();
			}
			System.out.println(output);
	}
	public static void removeComments(String input,BufferedReader reader) throws Exception
	{
		StringBuilder builder=new StringBuilder(input);
		char slash='/';
		char star='*';
		int i=builder.indexOf("/");
		int length=builder.length();
		if(i!=-1&&i<length-1)
		{
			if(builder.charAt(i+1)==slash)
			{
				output.append(builder.delete(i,length)+"\n");
				return;
			}
			else if(builder.charAt(i+1)==star)
			{
				String nextLine=readNextLine(reader);

				while(nextLine.lastIndexOf("/")==-1&&nextLine.lastIndexOf("*")==-1&&(nextLine.lastIndexOf("/")-nextLine.lastIndexOf("*"))!=1)
				{
					nextLine=readNextLine(reader);
					if(nextLine!=null)
					{
						builder.append(nextLine);
					}		
					else
					{
					 	break;
					}
				}
				return;
			}			
		}
		output.append(builder.toString()+"\n");
	}
	public static String readNextLine(BufferedReader reader) throws Exception
	{
		return reader.readLine();		
	}
}