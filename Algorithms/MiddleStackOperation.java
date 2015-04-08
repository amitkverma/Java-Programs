/* Design a stack with operations on middle element
 * push() which adds an element to the top of stack.
 * pop() which removes an element from top of stack.
 * findMiddle() which will return middle element of the stack.
 * deleteMiddle() which will delete the middle element.
 */

public class MiddleStackOperation
{
	public static void main(String[] args)
	{
		Stack stack=new Stack();
		stack.push(new ListNode(10));
		stack.push(new ListNode(9));
		stack.push(new ListNode(8));
		stack.push(new ListNode(7));
		stack.push(new ListNode(6));
		stack.push(new ListNode(5));
		stack.push(new ListNode(4));
		stack.push(new ListNode(3));
		stack.push(new ListNode(2));
		stack.push(new ListNode(1));
		stack.transverseList();
		stack.deletemiddleElement();
		stack.transverseList();
		stack.deletemiddleElement();
		stack.deletemiddleElement();
		stack.deletemiddleElement();
		stack.transverseList();
		stack.pop();
		stack.pop();
		stack.transverseList();
	}
}
class Stack
{
	private ListNode topElement;
	private ListNode middleElement;
	public Stack()
	{
		this.topElement=null;
		this.middleElement=null;
	}
	public void push(ListNode node)
	{
		if(IsEmpty())
		{
			System.out.println("Creating a stack..");
			System.out.println("Adding Element: "+node.getData()+" on List..");
			topElement=node;
			node.setNextNode(null);
			node.setPreviousNode(null);
			return;
		}
		System.out.println("Adding Element: "+node.getData()+" on List..");
		topElement.setPreviousNode(node);
		node.setPreviousNode(null);
		node.setNextNode(topElement);
		topElement=node;		
	}
	public void pop()
	{
		if(IsEmpty())
		{
			System.out.println("Stack is Empty..");
			return;
		}
		System.out.println("Removing the top element: "+topElement.getData());
		topElement=topElement.getNextNode();
		topElement.setPreviousNode(null);
	}
	public ListNode findMiddle()
	{
		if(length()%2==0)
		{
			int middle=length()/2;
			middleElement=topElement;
			for(int i=1;i<middle;i++)
			{
				middleElement=middleElement.getNextNode();
			}
			System.out.println("Your middle node is: "+middleElement.getData());
			return middleElement;
		}
		else
		{
			int middle=length()/2+1;
			middleElement=topElement;
			for(int i=1;i<middle;i++)
			{
				middleElement=middleElement.getNextNode();
			}
			System.out.println("Your middle node is: "+middleElement.getData());
			return middleElement;
		}
	}
	public void deletemiddleElement()
	{
		System.out.println("Deleting middle node..");
		middleElement=findMiddle();
		ListNode temp1=middleElement.getPreviousNode();
		temp1.setNextNode(middleElement.getNextNode());
		ListNode temp2=middleElement.getNextNode();
		temp2.setPreviousNode(temp1);
		middleElement.setNextNode(null);
		middleElement.setPreviousNode(null);
		temp1=null;
		temp2=null;
	}
	public boolean IsEmpty()
	{
		if(topElement==null)
			return true;
		return false;
	}
	public int length()
	{
		ListNode currentNode=topElement;
		int k=0;
		while(currentNode!=null)
		{
			k++;
			currentNode=currentNode.getNextNode();
		}
		return k;
	}
	public void transverseList()
	{
		ListNode currentNode=topElement;
		while(currentNode!=null)
		{
			System.out.print(currentNode.getData()+"->");
			currentNode=currentNode.getNextNode();
		}
		System.out.print("\n");
	}
}
class ListNode
{
	private int data;
	private ListNode nextNode;
	private ListNode previousNode;
	public ListNode(int data)
	{
		this.data=data;
	}
	public int getData()
	{
		return data;
	}
	public void setData(int data)
	{
		this.data=data;
	}
	public ListNode getNextNode()
	{
		return nextNode;
	}
	public void setNextNode(ListNode node)
	{
		this.nextNode=node;
	}
	public ListNode getPreviousNode()
	{
		return previousNode;
	}
	public void setPreviousNode(ListNode previousNode)
	{
		this.previousNode=previousNode;
	}
}
