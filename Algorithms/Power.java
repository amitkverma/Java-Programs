/*  program to calculate pow(x,n) */

class Power
{
	public static void main(String[] args){
		System.out.println(pow(3,19));
	}
	public static long pow(long base,int power){
		if(power==0){
			return 1;			
		}
		long temp=pow(base,power/2);
		if(power%2==0){
			return temp*temp;
		}else{
			return base*temp*temp;
		}

	}
}