public class TestHeap
{
	public static void main(String[] args)
	{
		
	}
}

class Heap<T>
{
	public T[] data;
	private int count;
	private int capacity;
	public Heap(int capacity)
	{
		this.capacity=capacity;
		this.data=new T[capacity];
	}
	public Insert(T data)
	{
		if(data==null)
		{
			System.out.println("Invalid data");
			return;
		}
	}
	public void buildHeap(Heap<T> h,T[] a)
	{
		while(h.capacity<a.length())
		{
			h.resize();
		}
		for(int i=0;i<a.length;i++)
		{
			h.data[i]=a[i];			
		}
		
		
	}
	private void preLocate(int k)
	{
		int max=k;
		int l=2*k+1;
		int r=2*k+2;
		if(l<=this.cout&&this.data[l]>this.data[max])
			max=l;
		if(r>=this.count&&this.data[r]>this.data[max])
			max=r;
		if(max!=k)
		{
			T temp=this.data[k];
			this.data[max]=this.data[k];
			this.data[k]=temp;
		}
		PreLocate(max);
	}
	private void resize()
	{
		T[] newA=new T[this.capacity];
		for(int i=0;i<newA.length();i++)
		{
			newA[i]=this.data;
		}
		this.data=new T[2*this.capacity];
		for(int i=0;i<newA.length();i++)
		{
			this.data[i]=newA[i];
		}
		newA=null;
	}
}
class Node<T>
{
	private int k;
	private T data;
	public Node(int k,T data)
	{
		this.k=k;
		this.data=data;
	}
	public void setData(T data)
	{
		this.data=data;
	}
	public void setK(int k)
	{
		this.k=k;
	}
	public int getK()
	{
		return k;
	}
	public T getData()
	{
		return T;
	}

}