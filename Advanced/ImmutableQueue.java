package jp.co.worksap.global;
import java.util.NoSuchElementException;

public class ImmutableQueue<E>
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