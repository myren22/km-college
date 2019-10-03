import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class BSTBlaaaah <T extends java.lang.Comparable<? super T>>{
	private BSTNode<T> root;
	
	public BSTree() {
		root = null;
	}
//	public static int sum(BSTree<Integer> root){
//		if(root == null){
//			return 0;
//		} else {
//			int sum = root.getValue();
//			sum += sum(root.getLeft());
//			sum += sum(root.getRight());
//			return sum;
//		}
//	}
//	
//	public static int sum(BSTree<Integer> root){
//		int range;
//		BSTNode<Integer> current = root;
//		int leftVal;
//		//leftmost
//		while(current!= null){
//			leftVal = 
//		}
//	}
	
	public static <T implements Comparable<? super T> List <T> 
	print(T level, BSTNode<T> root){
		Queue<BSTNode<T>> queue = new LinkedList<BSTNode<T>>();
		queue.offer(root);
		int currentLevel=0;
		while (!queue.isEmpty()) {
			
			BSTNode<T> node = queue.remove();
			if(currentLevel==level){
				list.add(node.getValue());
			}		
			if (node.getLeft() != null) {
				queue.offer(node.getLeft());
			}
			if (node.getRight() != null) {
				queue.offer(node.getRight());
			}
			
		}
	}
	
	public static <T> int leftChildren(BSTNode<T> root){
		int children = 0;
		Queue<BSTNode<T>> queue = new LinkedList<BSTNode<T>>();
		queue.offer(root);
		int currentLevel=0;
		while (!queue.isEmpty()) {
			
			BSTNode<T> node = queue.remove();
			if(queue.isEmpty())
			if(node.getLeft()==null && node.getRight() == null){
				children++;
			}		
			if (node.getLeft() != null) {
				queue.offer(node.getLeft());
			}
			if (node.getRight() != null) {
				queue.offer(node.getRight());
			}
			
		}
		return children;
	}
	
	public <T> void gatherNodes(List<T> list, BSTNode<T> root) {
		Queue<BSTNode<T>> queue = new LinkedList<BSTNode<T>>();
		queue.offer(root);
		int currentLevel=0;
		while (!queue.isEmpty()) {
			
			BSTNode<T> node = queue.remove();
			if(currentLevel==)
			
			list.add(node.getValue());
			if (node.getLeft() != null) {
				queue.offer(node.getLeft());
			}
			if (node.getRight() != null) {
				queue.offer(node.getRight());
			}
			currentLevel++;
		}

	}
	
	 (node, clevel, rlevel, result) {
		  if (clevel == rlevel) {
		    result.enqueue (node);
		  else {
			    if (node.left != null)
			      drill (node.left, clevel + 1, rlevel, result);
			    if (node.right != null)
			      drill (node.right, clevel + 1, rlevel, result);
			  }
		  }
	 }
		  
	
	
	
	
	
	
}
