package structures;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class InOrderIteratorRecursive<T> implements Iterator<T> {
	private Queue <BinaryTreeNode<T>> queue;
	public InOrderIteratorRecursive(BinaryTreeNode<T> root) {
		queue = new LinkedList<BinaryTreeNode<T>>();
		addNext(root);
	}
	private void addNext(BinaryTreeNode<T> node) {
		// visit node
		if(node == null) {
			return;
		}
		// visit node
		if(!node.hasLeftChild() && !node.hasRightChild()) {
			queue.add(node);
			}
		else if(node.hasLeftChild() && node.hasRightChild()) {
			addNext(node.getLeftChild());
			queue.add(node);
			addNext(node.getRightChild());
		}
		else if(node.hasLeftChild()) {
			addNext(node.getLeftChild());
			queue.add(node);
		}
		else if(node.hasRightChild()) {
			queue.add(node);
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
