/*  Median of two sorted arrays */

class Median
{
	public static void main(String[] args){
		int[] ar1 = {1, 12, 15, 26, 38};
    	int[] ar2 = {2, 13, 17, 30, 45};
    	System.out.println(getMedian(ar1,ar2,0,ar1.length-1,0,ar2.length-1));
	}
	public static int getMedian(int[] a1,int[] a2,int i1,int j1,int i2,int j2){
		if(j1-i1<0&&j2-i2<0){
			return 0;
		}
		if(i1==j1&&i2==j2){
			return (a1[i1]+a2[i2])/2;			
		}
		if(j1-i1==1&&j2-i2==1){
			return (max(a1[i1],a2[i2])+min(a1[j1],a2[j2]))/2;
		}
		int mid1=i1+(j1-i1)/2;
		int mid2=i2+(j2-i2)/2;
		if(a1[mid1]>a2[mid2]){
			return getMedian(a1,a2,i1,mid1,mid2,j2);
		}else{
			return getMedian(a1,a2,mid1,j1,i2,mid2);
		}
	}
	public static int min(int a,int b){
		if(a>b){
			return b;
		}
		return a;
	}
	public static int max(int a,int b){
		if(a>b){
			return a;
		}
		return b;
	}
}