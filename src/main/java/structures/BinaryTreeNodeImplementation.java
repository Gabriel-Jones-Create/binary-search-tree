package structures;

public class BinaryTreeNodeImplementation<T> implements BinaryTreeNode<T> {

	private BinaryTreeNode<T> left;
	private BinaryTreeNode<T> right;
	private T data;
	public BinaryTreeNodeImplementation(BinaryTreeNode<T> left, T elem, BinaryTreeNode<T> right) {
		this.left = left; // required to use this
		this.right = right;// required to use this
		this.data = elem;// not required to use this
	}

	@Override
	public T getData() {
		if(data == null) {
			throw new NullPointerException("The data is null");
		}
		return data;
	}

	@Override
	public void setData(T data) {
		if(data == null) {
			throw new NullPointerException("Can not set data to null");
		}
		this.data = data;
	}

	@Override
	public boolean hasLeftChild() {
		return (left != null);
	}

	@Override
	public boolean hasRightChild() {
		return (right != null);
	}

	@Override
	public BinaryTreeNode<T> getLeftChild() {
		if(!hasLeftChild()) {
			throw new IllegalStateException("This tree does not have a left child");
		}
		return left;
	}

	@Override
	public BinaryTreeNode<T> getRightChild() {
		if(!hasRightChild()) {
			throw new IllegalStateException("This tree does not have a right child");
		}
		return right;
	}

	@Override
	public void setLeftChild(BinaryTreeNode<T> left) {
		this.left = left;
	}

	@Override
	public void setRightChild(BinaryTreeNode<T> right) {
		this.right = right;
	}
	public int getDepth(BinaryTreeNode<T> root) {
		if(hasLeftChild() == false && hasRightChild() == false) {
			return 0;
		}
		return 1 + Math.max(getDepth(root.getLeftChild()), getDepth(root.getRightChild()));
	}

}