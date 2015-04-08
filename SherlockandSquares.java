import java.util.Scanner;
        
public class SherlockandSquares{
    
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int T=in.nextInt();
        for(int i=0;i<T;i++){
            int count=0;
            long A=in.nextLong();
            long B=in.nextLong();
            for(long j=A;j<=B;j++){
                if(IsPerfectSqaure(j)){
                  count++;  
                }
            }
           System.out.println(count);
        }
    }
    public static boolean IsPerfectSqaure(long value){
        int result=(int)Math.sqrt(value);
        if(result*result==value){
            return true;
        }
        return false;
    }
}