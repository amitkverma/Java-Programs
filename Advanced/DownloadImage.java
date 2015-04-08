import java.io.*;
import java.util.*;
import java.net.*;
import java.util.regex.*;
import javax.imageio.*;
import java.awt.image.BufferedImage;


public class DownloadImage
{
    public static void main(String[] args) throws Exception{
    //  Console console=System.console();
    /*  if(console==null){
          System.out.println("Unable to reach console");
          return;
      } */
      String input="http://www.santabanta.com/wallpapers/shruti-haasan/"; //console.readLine();
      getHTML(input);
    }
    public static void getHTML(String Url){
      try{
        String local=Url;
        URL obj=new URL(local);
        URLConnection con=(URLConnection) obj.openConnection();
        BufferedReader reader=new BufferedReader(new InputStreamReader(con.getInputStream()));
        BufferedWriter writer=new BufferedWriter(new FileWriter("downloadLog.txt"));
        StringBuilder inputHTML=new StringBuilder();
		String temp=reader.readLine();
        while(temp!=null){
            writer.write(temp);
            inputHTML.append(temp);
            temp=reader.readLine();
        }
    //    System.out.println("input: "+inputHTML.toString());		
        writer.close();
        reader.close();
        getImagesUrl(inputHTML,Url);
      }catch(Exception ex){
        ex.printStackTrace();
      }
    }
    public static void getImagesUrl(StringBuilder inputHTML,String Url) throws Exception{
        final String REGEX="<img(\\s*)\\w+=(\"|').*?(\"|')(\\s*)/>";
        final String REGEX1="src=\".*?\"";
        String fileName=createFileName(Url);
        Pattern pat=Pattern.compile(REGEX);
        Matcher mat=pat.matcher(inputHTML);
        BufferedWriter writer=new BufferedWriter(new FileWriter("log.txt"));
        int i=0;
        createDir(fileName);
        while(mat.find()){
          Pattern pat1=Pattern.compile(REGEX1);
          Matcher mat1=pat1.matcher(mat.group());
          while(mat1.find()){
              String imageURL=mat1.group().replaceAll("src=\"","").replaceAll("\"","");
              final String REGEX2="http://.*?((\\.jpg)|(\\.png))"; //Validating  URL
              Pattern pat2=Pattern.compile(REGEX2);
              Matcher mat2=pat2.matcher(imageURL);
              if(mat2.find()){
                  System.out.println("Working on image"+i+" .....");
                  System.out.println(mat2.group());
                  // getImageFile(mat2.group(),fileName);
                   //to be removed used as utillity and comment out above
                  if(mat2.group().contains("http://media.santabanta.com/medium1")){
                      getImageFile(santaBantaScraper(mat2.group()),fileName);
                  }else{
                    getImageFile(mat2.group(),fileName);
                  }

                  i++;  
              }
          }
        }
        writer.close();
    }
    public static void getImageFile(String Url,String fileName){
        try{
            String local=Url;
            URL obj=new URL(local);
            InputStream in=new BufferedInputStream(obj.openStream());
            OutputStream out;
            if(local.matches("\\.png")){
                out=new BufferedOutputStream(new FileOutputStream(fileName+"/"+createUniqueFileName()+".png"));              
            }else{
                out=new BufferedOutputStream(new FileOutputStream(fileName+"/"+createUniqueFileName()+".jpg"));
            }
            int i=in.read();
            while(i!=-1){
              out.write(i);
              i=in.read();
            } 
            in.close();
            out.close();            
          }catch(Exception ex){
            ex.printStackTrace();
          }
    }
    //Utilies
    public static String createUniqueFileName(){
      String id=UUID.randomUUID().toString().replaceAll("-","");
      return id;
    }
    public static String createFileName(String Url) throws Exception{
        URL url=new URL(Url);
        return url.getHost();
    }
    public static boolean createDir(String name){
      File file=new File(name);
      boolean exists=true;
      try{
        if (!file.exists()) {
          file.mkdir();
        }
      }
      catch(Exception ex){
          exists=false;
          ex.printStackTrace();
        }
      
      return exists;
    }
    //tools
    public static String santaBantaScraper(String url){
        String temp=url.replaceAll("http://media.santabanta.com/medium1","http://media1.santabanta.com/full5");
        return temp;
    }
}
