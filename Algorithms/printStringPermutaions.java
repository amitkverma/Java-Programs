/* print all permutations of a given string */

class printStringPermutaions
{
	public static void main(String[] args){

		String s="AMIT Kumar";
		char[] c=s.toCharArray();
		permutate(c,0);
	}

	public static void permutate(char[] a,int i){

		if(i>=a.length-1){
			printArray(a);
			System.out.print("\n");
			return;
		}
		for(int j=i;j<a.length;j++){
			swap(a,i,j);
			permutate(a,i+1);
			swap(a,i,j);
		}
	}
	public static void swap(char[] a,int i,int j){
		char temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
	public static void printArray(char[] a){
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]);
		}
	}
} 