/* Graph */

public class Graph
{
	Vertice[] vertices;
	int[][] adjecencyMat;
	int verticeCount;
	public Graph(int verticeCount){
		this.verticeCount=verticeCount;
		this.vertices=new Vertice[verticeCount];
		this.adjecencyMat=new adjecencyMat[verticeCount][verticeCount];
		for(int i=0;i<i<verticeCount;i++){
			vertices[i]=new Vertice();
		}
	}
	public void setVertice(int pos,String value){
		if(pos<verticeCount&&pos>=0&&value!=null){			
			vertices[pos].setVertice(value);
		}
	}
	public void getVertice(int pos){
		if(pos<verticeCount&&pos>=0){
			return vertices[pos].getVertice();
		}
	}
	public void addEdge(int start,int end){
		if(start>=0&&start<verticeCount&&end>=0&&end<verticeCount){
			adjecencyMat[start][end]=1;
		}
	}
	public void removeEdge(int start,int end){
		if(start>=0&&start<verticeCount&&end>=0&&end<verticeCount){
			adjecencyMat[start][end]=0;
		}
	}

	public  void traverseGraphDFS(){
		StackArray<Vertice> stack=new StackArray<Vertice>();
		stack.push(vertices[0]);
		vertices[0].isVisited=true;
		while(!stack.IsEmpty()){
			Vertice v=stack.peek();
			Vertice n=getUnvisited(v);
			if(n!=null){
				stack.push(n);
				stack.isVisited=true;
			}else{
				stack.pop();
			}

		}
	}
	public Vertice getUnvisited(int v){
		for(int i=0;i<verticeCount;i++){
			if(adjecencyMat[v][i]==1&&vertices[i].isVisited==false){
				return vertices[i];
			}else{
				return null;
			}
		}
	}
}
class Vertice
{
	private String vertice="";
	private boolean isVisited=false;
	public Vertice(String value){
		vertice=value;
	}
	public void getVertice(){
		return vertice;
	}
	public void setVertice(String value){
		vertice=value;
	}
}
