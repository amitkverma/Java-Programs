
public class TestGraph
{
	public static void main(String[] args){
		Graph graph=new Graph(4);
		graph.setVertice(0,"A");
		graph.setVertice(1,"B");
		graph.setVertice(2,"C");
		graph.setVertice(3,"D");
		graph.addEdge(0,1);
		graph.addEdge(1,2);
		graph.addEdge(2,3);
		graph.addEdge(3,0);
		graph.addEdge(0,2);
		graph.traverseGraphDFS();
	}
}