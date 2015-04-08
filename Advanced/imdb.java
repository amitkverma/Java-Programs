import java.util.*;
import java.io.*;
import java.net.*;
import java.util.regex.*;

public class imdb
{
	public static void main(String[] args)
	{
		try{
			URL url=new URL("http://www.imdb.com/chart/top");			
			URLConnection con=(URLConnection) url.openConnection();
			BufferedReader reader=new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuilder builder=new StringBuilder(reader.readLine());
			while((inputLine=reader.readLine())!=null){
				builder.append(inputLine);
			}
			String regex="<a(\\s+)href=\"/title/\\w+/\\?ref_=chttp_tt_[0-9]\"[\\s+\\n+]*title=\".*?\"[\\s+\\n+]*>[\\w+\\s+]+</a>";
			Pattern pat=Pattern.compile(regex);
			Matcher mat=pat.matcher(builder.toString().replaceAll("\\n\\r|\\r|\\n",""));
			while(mat.find()){
				System.out.println(mat.group()+"\n");
			}


		}catch(Exception ex){
				ex.printStackTrace();
		}

	}
}