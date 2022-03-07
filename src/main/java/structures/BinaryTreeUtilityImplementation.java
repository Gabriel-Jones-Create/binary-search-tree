package structures;

import java.util.Iterator;

public class BinaryTreeUtilityImplementation implements BinaryTreeUtility {

	@Override
	public <T> Iterator<T> getPreOrderIterator(BinaryTreeNode<T> root) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> Iterator<T> getInOrderIterator(BinaryTreeNode<T> root) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> Iterator<T> getPostOrderIterator(BinaryTreeNode<T> root) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> int getDepth(BinaryTreeNode<T> root) {
		if(!root.hasLeftChild() && !root.hasRightChild()) {
			return 0;
		}
		else if(root.hasLeftChild() && !root.hasRightChild()) {
			return 1 + getDepth(root.getLeftChild());
		}
		else if(!root.hasLeftChild() && root.hasRightChild()) {
			return 1 + getDepth(root.getRightChild());
		}
		return 1 + Math.max(getDepth(root.getLeftChild()), getDepth(root.getRightChild()));
	}

	@Override
	public <T> boolean isBalanced(BinaryTreeNode<T> root, int tolerance) {
		if(!root.hasLeftChild() && !root.hasRightChild()) {
			return true;
		}
	    else if(root.hasLeftChild() && root.hasRightChild() && getDepth(root.getLeftChild()) - getDepth(root.getRightChild()) <= tolerance){
			return (isBalanced(root.getLeftChild(), tolerance) && isBalanced(root.getRightChild() ,tolerance));
			
		}
		else if(!root.hasLeftChild() && root.hasRightChild() && getDepth(root) <= tolerance){
			return isBalanced(root.getRightChild() ,tolerance);
			
		}
		else if(root.hasLeftChild() && !root.hasRightChild() && getDepth(root) <= tolerance){
			return isBalanced(root.getLeftChild(), tolerance);
			
		}
		return false;
	}

	@Override
	public <T extends Comparable<? super T>> boolean isBST(BinaryTreeNode<T> root) {
		// TODO Auto-generated method stub
		return false;
	}

}
