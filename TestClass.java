
import java.util.NoSuchElementException;

public class TestClass
{
	public static void main(String[] args)
	{
		ImmutableQueue<Integer> q1=new ImmutableQueue<Integer>();
		q1.print();		
		ImmutableQueue<Integer> q2=q1.enqueue(new Integer(1));
		q2.print();
		ImmutableQueue<Integer> q3=q2.enqueue(new Integer(2));
		q3.print();
		ImmutableQueue<Integer> q4=q3.enqueue(new Integer(3));
		q4.print();		
		ImmutableQueue<Integer> q5=q4.enqueue(new Integer(4));
		q5.print();		
		ImmutableQueue<Integer> q6=q2.enqueue(new Integer(5));
		q6.print();
		ImmutableQueue<Integer> q7=q5.enqueue(new Integer(6));
		q7.print();
		ImmutableQueue<Integer> q8=q4.enqueue(new Integer(7));
		q8.print();		
		ImmutableQueue<Integer> q9=q2.enqueue(new Integer(8));
		q9.print();
		ImmutableQueue<Integer> q10=q7.enqueue(new Integer(9));
		q10.print();
		//ImmutableQueue<Integer> q11=q1.dequeue();
		q1.print();
		//q11.print();
		ImmutableQueue<Integer> q12=q2.dequeue();
		q2.print();
		q12.print();
		ImmutableQueue<Integer> q13=q3.dequeue();
		q3.print();		
		q13.print();		
		ImmutableQueue<Integer> q14=q4.dequeue();
		q4.print();		
		q14.print();		
		ImmutableQueue<Integer> q15=q2.dequeue();
		q2.print();
		q15.print();
		ImmutableQueue<Integer> q16=q5.dequeue();
		q5.print();
		q16.print();
		ImmutableQueue<Integer> q17=q4.dequeue();
		q4.print();		
		q17.print();		
		ImmutableQueue<Integer> q18=q2.dequeue();
		q2.print();
		q18.print();
		ImmutableQueue<Integer> q19=q7.dequeue();
		q7.print();
		q19.print();

		
	}
	
}
class ImmutableQueue<E>
{
	ListNode<E> rear;
	ListNode<E> front;
	public ImmutableQueue()
	{
		rear=null;
		front=null;		
	}
	/**
	 * add a node in existing queue object 
	 */	
	private void objEnqueue(E e)
	{		
		ListNode<E> node=new ListNode<E>(e);
		node.setNextNode(null);
		if(rear!=null)
		{
			rear.setNextNode(node);
		}
		rear=node;
		if(front==null)
		{
			front=rear;
		}
	}
	/**
	 * get the element data from queue
	 */
	private E getElement(ListNode<E> e)
	{
		return e.getData();
	}
	/**
	 * checks if Queue is empty or not
	 */
	private boolean IsEmpty()
	{
		if(front==null)
		{
			return true;
		}
		return false;
	}
	/**
	* Returns the queue that adds an item into the tail of this queue without modifying this queue.
	* <pre>
	* e.g.
	* When this queue represents the queue (2, 1, 2, 2, 6) and we enqueue the value 4 into this queue,
	* this method returns a new queue (2, 1, 2, 2, 6, 4)
	* and this object still represents the queue (2, 1, 2, 2, 6) .
	* </pre>
	* If the element e is null, throws IllegalArgumentException.
	* @param e
	* @return
	* @throws IllegalArgumentException
	*/	
	public ImmutableQueue<E> enqueue(E e)
	{
		if(e==null)
		{
			throw new IllegalArgumentException("Can't add in queue becouse Argument is null");
		}
		ImmutableQueue<E> newQueue=new ImmutableQueue<E>();
		ListNode<E> temp=front;
		while(temp!=null)
		{
			newQueue.objEnqueue(temp.getData());
			temp=temp.getNextNode();
		}
		newQueue.objEnqueue(e);
		
		return newQueue;
	}
	/**
	* Returns the queue that removes the object at the head of this queue without modifying this queue.
	* <pre>
	* e.g.
	* When this queue represents the queue (7, 1, 3, 3, 5, 1) ,
	* this method returns a new queue (1, 3, 3, 5, 1)
	* and this object still represents the queue (7, 1, 3, 3, 5, 1) .
	* </pre>
	* If this queue is empty, throws java.util.NoSuchElementException.
	* @return
	* @throws java.util.NoSuchElementException
	*/
	public ImmutableQueue<E> dequeue()
	{
		if(IsEmpty())
		{
			throw new NoSuchElementException("Can't becouse queue is empty!");
		}
		ImmutableQueue<E> newQueue=new ImmutableQueue<E>();
		ListNode<E> temp=front.getNextNode();
		while(temp!=null)
		{
			newQueue.objEnqueue(temp.getData());
			temp=temp.getNextNode();
		}
		return newQueue;
	}
	/**
	* Looks at the object which is the head of this queue without removing it from the queue.
	* <pre>
	* e.g.
	* When this queue represents the queue (7, 1, 3, 3, 5, 1),
	* this method returns 7 and this object still represents the queue (7, 1, 3, 3, 5, 1)
	* </pre>
	* If the queue is empty, throws java.util.NoSuchElementException.
	* @return
	* @throws java.util.NoSuchElementException
	*/
	public E peek()
	{
		if(IsEmpty())
		{
			throw new java.util.NoSuchElementException("Can't peek the queue becouse queue is empty!");
		}		
		return front.getData();
	}
	/**
	* Returns the number of objects in this queue.
	* @return
	*/
	public int size()
	{
		ListNode<E> currentNode=front;
		int size=0;
		while(currentNode!=null)
		{
			size++;
			currentNode=currentNode.getNextNode();
		}
		return size;
	}
	// must be removed
	public void print()
	{
		if(front==null)
		{
			System.out.println("Queue is Empty!");
			return;
		}
		ListNode<E> currentNode=front;
		while(currentNode!=null)
		{
			System.out.print(currentNode.getData()+", ");
			currentNode=currentNode.getNextNode();
		}
		System.out.print("\n");
	}	
}
class ListNode<E>
{
	private E data;
	private ListNode<E> node;
	public ListNode(E data)
	{
		this.data=data;
	}
	public E getData()
	{
		return data;
	}
	public ListNode<E> getNextNode()
	{
		return node;
	}
	public void setNextNode(ListNode<E> node)
	{
		this.node=node;
	}
	public void setData(E data)
	{
		this.data=data;
	}
}

