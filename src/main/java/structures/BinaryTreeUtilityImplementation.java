package structures;

import java.util.Iterator;

import org.apache.commons.math3.util.Incrementor.MaxCountExceededCallback;

public class BinaryTreeUtilityImplementation implements BinaryTreeUtility {

	@Override
	public <T> Iterator<T> getPreOrderIterator(BinaryTreeNode<T> root) {
		if (root == null) {
			throw new NullPointerException("Root cannot be null");
		}
		return new PreOrderIteratorRecursive<T>(root);
	}

	@Override
	public <T> Iterator<T> getInOrderIterator(BinaryTreeNode<T> root) {
		if (root == null) {
			throw new NullPointerException("Root cannot be null");
		}
		return new InOrderIteratorRecursive<T>(root);
	}

	@Override
	public <T> Iterator<T> getPostOrderIterator(BinaryTreeNode<T> root) {
		if (root == null) {
			throw new NullPointerException("Root cannot be null");
		}
		return new PostOrderRecursive<T>(root);
	}

	@Override
	public <T> int getDepth(BinaryTreeNode<T> root) {
		if (!root.hasLeftChild() && !root.hasRightChild()) {
			return 0;
		} else if (root.hasLeftChild() && !root.hasRightChild()) {
			return 1 + getDepth(root.getLeftChild());
		} else if (!root.hasLeftChild() && root.hasRightChild()) {
			return 1 + getDepth(root.getRightChild());
		}
		return 1 + Math.max(getDepth(root.getLeftChild()), getDepth(root.getRightChild()));
	}

	@Override
	public <T> boolean isBalanced(BinaryTreeNode<T> root, int tolerance) {
		if (tolerance < 0) {
			throw new IllegalArgumentException("Tolerance cannot be less than 0");
		} else if (!root.hasLeftChild() && !root.hasRightChild()) {
			return true;
		} else if (root.hasLeftChild() && root.hasRightChild()
				&& getDepth(root.getLeftChild()) - getDepth(root.getRightChild()) <= tolerance) {
			return (isBalanced(root.getLeftChild(), tolerance) && isBalanced(root.getRightChild(), tolerance));

		} else if (!root.hasLeftChild() && root.hasRightChild() && getDepth(root) <= tolerance) {
			return isBalanced(root.getRightChild(), tolerance);

		} else if (root.hasLeftChild() && !root.hasRightChild() && getDepth(root) <= tolerance) {
			return isBalanced(root.getLeftChild(), tolerance);

		}
		return false;
	}

	/*
	 * public <T extends Comparable<? super T>> boolean isBST(BinaryTreeNode<T>
	 * root, T max, T min) { /* if (max != null || root.getData().compareTo(max) >=
	 * 0 || (min != null && root.getData().compareTo(min) < 0)) { return false; }
	 * else if() { isLeftBST = isBST(root.getLeftChild(), root.getData(), min); }
	 *
	 * if(root == null) { return false; } else if (max == null && min == null) { if
	 * (root.hasLeftChild() && root.hasRightChild()) { return
	 * isBST(root.getLeftChild(), root.getData(), min) &&
	 * isBST(root.getRightChild(), max, root.getData()); } else if
	 * (root.hasLeftChild() && !root.hasRightChild()) { return
	 * isBST(root.getLeftChild(), root.getData(), min); } else if
	 * (!root.hasLeftChild() && root.hasRightChild()) { return
	 * isBST(root.getRightChild(), max, root.getData()); } else { return true; } }
	 * else if (max == null) { if (root.getData().compareTo(min) < 0) { return
	 * false; } else if (root.hasLeftChild() && root.hasRightChild()) { return
	 * isBST(root.getLeftChild(), root.getData(), min) &&
	 * isBST(root.getRightChild(), max, root.getData()); } else if
	 * (root.hasLeftChild() && !root.hasRightChild()) { return
	 * isBST(root.getLeftChild(), root.getData(), min); } else if
	 * (!root.hasLeftChild() && root.hasRightChild()) { return
	 * isBST(root.getRightChild(), max, root.getData()); } else { return true; } }
	 * else if (min == null) { if (root.getData().compareTo(max) >= 0) { return
	 * false; } else if (root.hasLeftChild() && root.hasRightChild()) { return
	 * isBST(root.getLeftChild(), root.getData(), min) &&
	 * isBST(root.getRightChild(), max, root.getData()); } else if
	 * (root.hasLeftChild() && !root.hasRightChild()) { return
	 * isBST(root.getLeftChild(), root.getData(), min); } else if
	 * (!root.hasLeftChild() && root.hasRightChild()) { return
	 * isBST(root.getRightChild(), max, root.getData()); } else { return true; } }
	 * else { if (root.getData().compareTo(max) >= 0 ||
	 * root.getData().compareTo(min) < 0) { return false; } else if
	 * (root.hasLeftChild() && root.hasRightChild()) { return
	 * isBST(root.getLeftChild(), root.getData(), min) &&
	 * isBST(root.getRightChild(), max, root.getData()); } else if
	 * (root.hasLeftChild() && !root.hasRightChild()) { return
	 * isBST(root.getLeftChild(), root.getData(), min); } else if
	 * (!root.hasLeftChild() && root.hasRightChild()) { return
	 * isBST(root.getRightChild(), max, root.getData()); } else { return true; }
	 * 
	 * } }
	 */
	@Override
	public <T extends Comparable<? super T>> boolean isBST(BinaryTreeNode<T> root) {

		if (root == null) {

			throw new NullPointerException();

		}

		return isBST(root, null, null);

	}

	private <T extends Comparable<? super T>> boolean isBST(BinaryTreeNode<T> current, T max, T min) {

		// check if there is a root

		if (current == null) {

			throw new NullPointerException("Trying to find if a null BinaryTree is a BinaryTree");

		}

		boolean isLeftBST = true;

		boolean isRightBST = true;

		// make sure current is valid (if it's not valid, return false)

		if ((max != null && current.getData().compareTo(max) >= 0)

				|| (min != null && current.getData().compareTo(min) < 0)) {

			return false;

		}

		// if its a single BTN

		if (!current.hasLeftChild() && !current.hasRightChild()) {

			return true;

		}

		// go left

		if (current.hasLeftChild()) {

			isLeftBST = isBST(current.getLeftChild(), current.getData(), min);

		}

		// go right

		if (current.hasRightChild()) {

			isRightBST = isBST(current.getRightChild(), max, current.getData());
		}

		return isLeftBST && isRightBST;

	}
}
