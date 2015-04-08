/* Delete N nodes after M nodes of a linked list 
 * Input: M = 2, N = 2 ,Linked List: 1->2->3->4->5->6->7->8
 * Output: Linked List: 1->2->5->6
 */

public class DeleteNodes
{
	public static void main(String[] args)
	{
		LinkList list=new LinkList();
		list.addElement(new ListNode(10));
		list.addElement(new ListNode(9));
		list.addElement(new ListNode(8));
		list.addElement(new ListNode(7));
		list.addElement(new ListNode(6));
		list.addElement(new ListNode(5));
		list.addElement(new ListNode(4));
		list.addElement(new ListNode(3));
		list.addElement(new ListNode(2));
		list.addElement(new ListNode(1));
		list.transverseList();
		DeleteNodes.DeleteNElementsAfterM(1,1,list);
		list.transverseList();
		
	}
	public static void DeleteNElementsAfterM(int M,int N,LinkList list)
	{
		System.out.println("Deleting "+N+" elements after every "+N+" elements..");
		ListNode previousNode=list.getHeadNode();
		ListNode currentNode=list.getHeadNode().getNextNode();
		while(currentNode!=null)
		{
			int i=0;
			while(i<M-1)
			{
				previousNode=previousNode.getNextNode();
				currentNode=previousNode.getNextNode();
				i++;
			}
			int j=0;
			while(j<N)
			{
				previousNode.setNextNode(currentNode.getNextNode());
				currentNode.setNextNode(null);
				currentNode=previousNode.getNextNode();
				j++;
			}
			if(currentNode==null)
			{
				break;
			}
			previousNode=previousNode.getNextNode();
			currentNode=previousNode.getNextNode();
		}
	}
}
class LinkList
{
	private ListNode head;
	public ListNode getHeadNode()
	{
		return head;
	}
	public void setHeadNode(ListNode head)
	{
		this.head=head;
	}
	public LinkList()
	{
		head=null;
	}
	public void addElement(ListNode node)
	{
		if(head==null)
		{
			System.out.println("Creating Link List..");
			System.out.println("Adding Element: "+node.getData()+" on List..");
			head=node;
			node.setNextNode(null);
			return;
		}
		System.out.println("Adding Element: "+node.getData()+" on List..");
		node.setNextNode(head);
		head=node;
	}
	public void transverseList()
	{
		ListNode currentNode=head;
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
	private ListNode node;
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
		return node;
	}
	public void setNextNode(ListNode node)
	{
		this.node=node;
	}
}