package structures;

import java.util.Iterator;

public class LinkedBinarySearchTree<T extends Comparable<? super T>> implements BinarySearchTree<T> {

	private BinaryTreeNode<T> root;
	private int count;

	public LinkedBinarySearchTree(BinaryTreeNode<T> root) {
		this.root = root;
	}

	public LinkedBinarySearchTree() {
		// TODO Auto-generated constructor stub
		root = null;
	}
	/**
	 * Adds the specified object to the binary search tree in the appropriate
	 * position according to its key value. Note that equal elements are added to
	 * the right.
	 *
	 * @param element the element to be added to the binary search tree
	 */
	@Override
	public BinarySearchTree<T> add(T toAdd) {
		if(toAdd == null) {
			throw new NullPointerException("Thing being added cannot be null");
		}
		BinaryTreeNodeImplementation<T> nodeToAdd = new BinaryTreeNodeImplementation<T>(null, toAdd, null);
		if(this.isEmpty()) {
			root = nodeToAdd;
		}
		else {
			if(toAdd.compareTo(root.getData()) < 0) {
				if(!root.hasLeftChild()) {
					root.setLeftChild(nodeToAdd);
				}
				else {
					addElement(toAdd, root.getLeftChild());
				}
			}
			else {
				if(!root.hasRightChild()) {
					root.setRightChild(nodeToAdd);
				}
				else {
					addElement(toAdd, root.getRightChild());
				}
			}
		}
		count++;
		return this;
}
	private void addElement(T toAdd, BinaryTreeNode<T> node){
			BinaryTreeNodeImplementation<T> nodeToAdd = new BinaryTreeNodeImplementation<T>(null, toAdd, null);
			if(node.getData().compareTo(toAdd) < 0) {
				if(!node.hasLeftChild()){
					node.setLeftChild(nodeToAdd);
				}
				else {
					addElement(toAdd, node.getLeftChild());
				}
			}
			else {
				if(!node.hasRightChild()) {
					node.setRightChild(nodeToAdd);
				}
				else {
					addElement(toAdd,node.getRightChild());
				}
			}
		}

	@Override
	public boolean contains(T toFind) {
		// TODO Auto-generated method stub
		if(toFind == null || root == null) {
			throw new NullPointerException("Thing to find cannot be null");
		}
		return contains(toFind,root);
	}
	public boolean contains(T toFind, BinaryTreeNode<T> cur) {
		// TODO Auto-generated method stub
		if(cur == null) {
			return false;
		}
	    else if(toFind.equals(cur.getData())) {
			return true;
		}
		else if(toFind.compareTo(cur.getData()) < 0 && cur.hasLeftChild()) {
			return contains(toFind, cur.getLeftChild());
		}
		else if(toFind.compareTo(cur.getData()) > 0 && cur.hasRightChild()) {
			return contains(toFind, cur.getRightChild());
		}
		else {
			return false;
		}
	}

	/*@Override
	public boolean remove(T toRemove) {
		{
			T result = null;
			if (!isEmpty()) {
				if (toRemove.equals(root.getData())) {
					result = root.getData();
					root = replacement(root);
					count--;
				} else {
					BinaryTreeNode<T> current, parent = root;
					boolean found = false;
					if (((Comparable) targetElement).compareTo(root.element) < 0)
						current = root.left;
					else
						current = root.right;
					while (current != null && !found) {
						if (targetElement.equals(current.element)) {
							found = true;
							count--;
							result = current.element;
							if (current == parent.left) {
								parent.left = replacement(current);
							} else {
								parent.right = replacement(current);
							}
						} else {
							parent = current;
							if (((Comparable) targetElement).compareTo(current.element) < 0)
								current = current.left;
							else
								current = current.right;
						}
					} // end while
					if (!found)
						throw new ElementNotFoundException("binary search tree");
				}
			} // end outer if
			return result;
		
	}*/

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return count;
	}

	@Override
	public boolean isEmpty() {
		return root == null;
	}

	@Override
	public T getMinimum() {
		// TODO Auto-generated method stub
		if(root == null) {
			throw new IllegalStateException("Binary tree must exist");
		}
		return getMinimum(root);
	}

	public T getMinimum(BinaryTreeNode<T> curNode) {
		// TODO Auto-generated method stub
		if (curNode.hasLeftChild()) {
			return getMinimum(curNode.getLeftChild());
		}
		return curNode.getData();
	}

	@Override
	public T getMaximum() {
		// TODO Auto-generated method stub
		if(root == null) {
			throw new IllegalStateException("Binary tree must exist");
		}
		return getMaximum(root);
	}

	public T getMaximum(BinaryTreeNode<T> curNode) {
		if (curNode.hasRightChild()) {
			return getMaximum(curNode.getRightChild());
		}
		return curNode.getData();
	}

	@Override
	public BinaryTreeNode<T> toBinaryTreeNode() {
		// TODO Auto-generated method stub
		if(root == null) {
			throw new IllegalStateException("Root cannot be null");
		}
		return root;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new InOrderIteratorRecursive<T>(root);
	}

	@Override
	public boolean remove(T toRemove) {
		// TODO Auto-generated method stub
		if(this.contains(toRemove)) {
			return remove(toRemove,root);
		}
		else {
			return false;
		}
	}
	private boolean remove(T toRemove, BinaryTreeNode<T> cur) {
		if(toRemove.equals(cur.getData())) {
			if(cur.hasRightChild()) {
				cur = cur.getRightChild();
			}
			else if(cur.hasLeftChild()) {
				cur = cur.getLeftChild();
			}
			else {
				cur = null;
			}
		}
		else {
			if(toRemove.compareTo(cur.getData()) < 0) {
				remove(toRemove, cur.getLeftChild());
			}
			else if(toRemove.compareTo(cur.getData()) < 0) {
				remove(toRemove, cur.getRightChild());
				}
			}
		count--;
		return true;
		}
	}

