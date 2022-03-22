package structures;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class PreOrderIteratorRecursive<T> implements Iterator<T>{
	private Queue<BinaryTreeNode<T>> queue;
	public PreOrderIteratorRecursive(BinaryTreeNode<T> root) {
		queue = new LinkedList<BinaryTreeNode<T>>();
		addNext(root);
	}
	private void addNext(BinaryTreeNode<T> node) {
		if(node == null) {
			return;
		}
		// visit node
		queue.add(node);
		if(node.hasLeftChild()) {
			addNext(node.getLeftChild());
		}
		if(node.hasRightChild()) {
			addNext(node.getRightChild());
		}
		
	}
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return !queue.isEmpty();
	}

	@Override
	public T next() {
		// TODO Auto-generated method stub
		return queue.remove().getData();
	}
	
}
