package tree;

import util.Pair;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class RightView {

	public static void main(String[] args) {
		TreeNode tree = new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3, null, new TreeNode(4)
		));
		System.out.println(new RightView().rightSideView(tree));
	}

	public List<Integer> rightSideView(TreeNode root) {
		return levelOrderTraversal(root);

	}

	public List<Integer> levelOrderTraversal(TreeNode root) {
		List<Integer> ans = new ArrayList<>();
		Deque<Pair<TreeNode, Integer>> queue = new LinkedList<>();
		queue.add(Pair.of(root, 0));
		ans.add(root.val);
		int currentLevel = 0;
		while (!queue.isEmpty()) {
			TreeNode temp = queue.peek().getLeft();
			int level = queue.peek().getRight();
			queue.poll();
			if (currentLevel < level) {
				ans.add(temp.val);
				currentLevel = level;
			}

			if (temp.right != null)
				queue.offer(Pair.of(temp.right, level + 1));
			if (temp.left != null)
				queue.offer(Pair.of(temp.left, level + 1));
		}
		return ans;
	}
}
