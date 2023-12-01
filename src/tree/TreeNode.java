package tree;

public class TreeNode {
	int val;
	public TreeNode left;
	public TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer();
		sb.append("val=").append(val);
		return sb.toString();
	}
}
