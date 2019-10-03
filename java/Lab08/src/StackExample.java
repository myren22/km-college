
public class StackExample {	
	public static Stack<Integer> getEvenNumbers(Stack<Integer> stack){
		Stack<Integer> flippedStack = new Stack<Integer>();
		Stack<Integer> evenStack= new Stack<Integer>();
		while(!stack.isEmpty()){
			Integer i=stack.pop();
			flippedStack.push(i);			
		}
		while(!flippedStack.isEmpty()){
			Integer g=flippedStack.pop();
			stack.push(g);
			if(g%2==0){
				evenStack.push(g);
			}
		}
		return evenStack;
		
	}
}
