//Rachel Malonson 50% Jalon Brown 50%

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BSTree<T extends java.lang.Comparable<? super T>> {

	private BSTNode<T> root;

	public BSTree() {
		root = null;
	}

	public void delete(T value) {
		BSTNode<T> currentNode = root;
		BSTNode<T> parentNode = root;
		if (find(value)) {
			// must find the value we want to delete
			while (currentNode != null) {
				// current node is the one being deleted
				if (currentNode.getValue().compareTo(value) == 0) {
					// found the value
					// case 1: no children
					if (currentNode.getLeft() == null
							&& currentNode.getRight() == null) {
						// if there are no children and this is root - must
						// replace root with null
						if (currentNode.equals(root)) {
							root = null;
						}
						if (currentNode.getValue().compareTo(parentNode.getValue()) > 0) {
							parentNode.setRight(null);
						} else {
							parentNode.setLeft(null);
						}
						currentNode = null;
						
					}
					// case 2: 1 child
					else if (currentNode.getLeft() == null) {
						if(currentNode.getValue().equals(root.getValue())){
							root = root.getRight();
						}
						//if this is the first instance it is wrong 
						else if (currentNode.getValue().compareTo(parentNode.getValue()) > 0) {
							parentNode.setRight(currentNode.getRight());
						} else {
							parentNode.setLeft(currentNode.getRight());
						}
						currentNode = null;
					} else if (currentNode.getRight() == null) {
						if(currentNode.getValue().equals(root.getValue())){
							root = root.getLeft();
						}
						else if (currentNode.getValue().compareTo(parentNode.getValue()) > 0) {
							parentNode.setRight(currentNode.getLeft());
						} else {
							parentNode.setLeft(currentNode.getLeft());
						}
						currentNode = null;
					}
					// case 3: 2 children
					else {
						BSTNode<T> nodeToDelete = parentNode;
						parentNode = currentNode;
						currentNode = currentNode.getLeft();
						int count = 0;
						while (currentNode.getRight() != null) {
							nodeToDelete = currentNode;
							count++;
							currentNode = currentNode.getRight();
						}
						
						// got the highest value stored in current node
						// make its parent point to node to deletes left node
						T act = currentNode.getValue();
						// this means that the left node is being used
						if (count == 0) {
							parentNode.setLeft(currentNode.getLeft());
						} else {
							nodeToDelete.setRight(currentNode.getLeft());
						}
						// set value of node being deleted to this value
						parentNode.setValue(act);
					}
				} else if (currentNode.getValue().compareTo(value) > 0) {
					parentNode = currentNode;
					currentNode = currentNode.getLeft();
				} else {
					parentNode = currentNode;
					currentNode = currentNode.getRight();
				}
				
			}
		}

	}

	public boolean find(T value) {
		BSTNode<T> currentNode = root;
		while (currentNode != null) {
			if (currentNode.getValue().compareTo(value) == 0) {
				return true;
			} else if (currentNode.getValue().compareTo(value) > 0) {
				currentNode = currentNode.getLeft();
			} else {
				currentNode = currentNode.getRight();
			}
		}
		return false;
	}

	public boolean isEmpty() {
		return root == null;
	}

	@SuppressWarnings("unchecked")
	public boolean equals(java.lang.Object o) {
		if (o instanceof BSTree) {
			BSTree<T> tree = (BSTree<T>) o;

			Iterator<T> itr = this.iterator();
			Iterator<T> other = tree.iterator();
			if (itr.hasNext() && other.hasNext()) {
				while (itr.hasNext() && other.hasNext()) {
					if (!itr.next().equals(other.next())) {
						return false;
					}
				}
			} 
			else if (itr.hasNext() || other.hasNext()) {
				return false;
			}
		}
		else
		{
			return false;
		}
		return true;
}
	

	public void insert(T value) {
		BSTNode<T> node = new BSTNode<T>(value, null, null);
		BSTNode<T> currentNode = root;
		BSTNode<T> parentNode = root;
		if (root == null) {
			root = node;
		} else if (find(value)) {
			throw new IllegalArgumentException();
		} else {
			while (currentNode != null) {
				parentNode = currentNode;
				if (currentNode.getValue().compareTo(value) > 0) {
					currentNode = currentNode.getLeft();
				} else {
					currentNode = currentNode.getRight();
				}
			}

			if (parentNode.getValue().compareTo(value) > 0) {
				parentNode.setLeft(node);
			} else {
				parentNode.setRight(node);
			}
		}
	}

	private abstract class AbstractOrder {
		private ArrayList<T> list = new ArrayList<T>();

		public final Iterator<T> iterator() {
			gatherNodes(list, root);
			return list.iterator();
		}

		protected abstract void gatherNodes(List<T> list, BSTNode<T> node);
	}

	private class preOrder extends AbstractOrder {
		protected void gatherNodes(List<T> list, BSTNode<T> node) {
			if (node != null) {
				list.add(node.getValue());
				gatherNodes(list, node.getLeft());
				gatherNodes(list, node.getRight());
			}
		}
	}

	private class inOrder extends AbstractOrder {
		protected void gatherNodes(List<T> list, BSTNode<T> node) {
			if (node != null) {
				gatherNodes(list, node.getLeft());
				list.add(node.getValue());
				gatherNodes(list, node.getRight());
			}
		}
	}

	private class postOrder extends AbstractOrder {
		protected void gatherNodes(List<T> list, BSTNode<T> node) {
			if (node != null) {
				gatherNodes(list, node.getLeft());
				gatherNodes(list, node.getRight());
				list.add(node.getValue());
			}
		}
	}

	private class LevelOrder extends AbstractOrder {

		@Override
		protected void gatherNodes(List<T> list, BSTNode<T> root) {
			Queue<BSTNode<T>> queue = new LinkedList<BSTNode<T>>();
			queue.offer(root);
			while (!queue.isEmpty()) {
				BSTNode<T> node = queue.remove();
				list.add(node.getValue());
				if (node.getLeft() != null) {
					queue.offer(node.getLeft());
				}
				if (node.getRight() != null) {
					queue.offer(node.getRight());
				}
			}

		}

	}

	public java.util.Iterator<T> iterator() {
		return new inOrder().iterator();
	}

	public java.util.Iterator<T> iteratorInorder() {
		return new inOrder().iterator();
	}

	public java.util.Iterator<T> iteratorPreorder() {
		return new preOrder().iterator();
	}

	public java.util.Iterator<T> iteratorPostorder() {
		return new postOrder().iterator();
	}

	public java.util.Iterator<T> iteratorLevelorder() {
		return new LevelOrder().iterator();
	}
	
	
}
