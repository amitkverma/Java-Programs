/* Stack */
class StackArray<E>
{
	int size;
	Object[] stack;
	int current;
	public StackArray(int size){
		this.size=size;
		this.current=size;
		stack=new Object[size];
	}
	public void push(E value){
		if(current>0){
		current--;
		stack[current]=value;
		}else{
			System.out.println("Stack is already Filled");
		}
	}
	public void pop(){
		if(current<size){
			current++;
		}else{
			System.out.println("Stack is Empty!");
		}
	}
	public E peek(){
		if(current<size){
			 return (E)stack[current];
		}
	}
	public boolean isEnpty(){
		if(current>size-1){
			return true;
		}else{
			return false;
		}
	}
}