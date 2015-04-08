public class Test
{
	public int Amit(char a,int b)
	{
		return 0;
	}
	public char Amit(int a,char b)
	{
		return 'a';
	}
	public static void main(String[] args)
	{
		Complex c1 = new Complex(10, 15);
        Complex c2 = new Complex(10, 15);
        if (c1==c2) {
            System.out.println("Equal ");
        } else {
            System.out.println("Not Equal ");
        }
	/*	int[] data1={2,5,7,9,10};
		i nt[] data2={2,4,6,8,10,1,3,5,7,9};
		Merge(data2,0,4,10);
		for(int i=0;i<data2.length;i++)
		{
			System.out.print(" "+data2[i]);			
		} */
	//	int v=5;
	//	System.out.println(v);
	}
	public static int value()
	{
		return 10;
	}
	public static void InsersionSort(int[] arr)
	{
		for(int i=1;i<arr.length;i++)
		{
			int temp=arr[i];
			int index=-1;
			for(int j=i-1;j>=0;j--)
			{
				if(arr[j]>=temp)
				{
					arr[j+1]=arr[j];
				}
				if(arr[j]<temp)
				{
					index=j;
					break;
				}
			}
			arr[index+1]=temp;
		}
	}
	public static void BubleSort(int[] a)
	{
		for(int i=a.length-1;i>=0;i--)
		{
			for(int j=0;j<i;j++)
			{
				if(a[j]>a[j+1])
				{
					int temp=a[j+1];
					a[j+1]=a[j];
					a[j]=temp;
				}
			}
		}
	}
	public static void SelectionSort(int[] a)
	{
		for(int i=0;i<a.length;i++)
		{
			int max=getMaxIndex(a,i,a.length);
			int temp=a[i];
			a[i]=a[max];
			a[max]=temp;
		}
	}
	public static int getMaxIndex(int[] a,int start,int end)
	{
		int max=start;
		for(int i=start;i<end;i++)
		{
			if(a[i]<a[max])
			{
				max=i;
			}
		}
		return max;
	}
	public static void MergeSort(int[] a,int start,int end)
	{
		
	}
	public static void Merge(int[] a,int star,int mid,int end)
	{
		int start=0;
		int a_start=star;
		int a_len=mid+1;
		int b_start=mid+1;
		int b_len=end;
		System.out.println("a_s: "+a_start+" a_len "+a_len+" b_st "+b_start+"b_len "+b_len);
		while(a_start<a_len&&b_start<b_len)
		{
			System.out.println("a: "+a[a_start]+"b: "+a[b_start]);
			if(a[a_start]<a[b_start])
			{
				a[start]=a[a_start];
				a_start++;
			}
			else
			{
				a[start]=a[b_start];
				b_start++;
			}
			start++;
		}
		while(a_start<a_len)
		{
			a[start]=a[a_start];
			a_start++;
			start++;
		}
		while(b_start<b_len)
		{
			a[start]=a[b_start];
			b_start++;
			start++;
		}
	}
}
