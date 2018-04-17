public class FamilyTree {
	private class Node {
		String value;
		Node left, right;

		Node(String val) {
			value = val;
			left = null;
			right = null;
		}

		Node(String val, Node leftChild, Node rightChild) {
			value = val;
			left = leftChild;
			right = rightChild;
		}
	}

	private Node root = null;

	public boolean root(String x) {
		if (root == null) {
			root = new Node(x);
			return true;
		} else
			return false;
	}

	public boolean addLeft(String p, String x) {
		Node parent = locate(p);
		if (root == null) {
			return false;
		} else if (parent != null && parent.left == null) {
			parent.left = new Node(x);
			return true;
		} else
			return false;
	}

	public boolean addRight(String p, String x) {
		Node parent = locate(p);
		if (root == null) {
			return false;
		} else if (parent != null && parent.right == null) {
			// Adds node
			parent.right = new Node(x);
			return true;
		} else
			return false;
	}

	public Node locate(String p) {
		return locate(p, root);
	}

	private Node locate(String p, Node famTree) {
		Node result = null;
		if (famTree == null)
			return null;
		if (famTree.value.equals(p))
			return famTree;
		if (famTree.left != null)
			result = locate(p, famTree.left);
		if (result == null)
			result = locate(p, famTree.right);
		return result;
	}

}