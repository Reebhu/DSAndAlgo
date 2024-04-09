package tree;

import java.util.Stack;

public class TreeTraversals {

	public static void main(String[] args) {
		TreeNode root = TreeUtils.createTree();
		//inorderTraversal(root);
		postOrderTraversal(root);
		preeOrderTraversal(root);
	}

	private static void preeOrderTraversal(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();

		TreeNode curr = root;
		stack.push(curr);
		while (!stack.isEmpty()) {
			System.out.println(stack.peek().val);

			while (curr != null) {
				stack.push(curr);
				curr = curr.left;

			}

			curr = stack.pop();
			curr = curr.right;
		}

	}

	private static void postOrderTraversal(TreeNode root) {
	}

	private static void inorderTraversal(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		TreeNode curr = root;
		while (curr != null || !stack.isEmpty()) {

			while (curr != null) {
				stack.push(curr);
				curr = curr.left;

			}

			curr = stack.pop();
			System.out.println(curr.val);

			curr = curr.right;
		}
	}
}
