package tree;

import util.Pair;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ZizZagTraversal {

	public static void main(String[] args) {
		TreeNode tree = new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3, null, new TreeNode(4)
		));
		System.out.println(zigzagLevelOrder(tree));
	}

	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		if (root == null)
			return new ArrayList<>();
		return levelOrderTraversal(root);
	}

	public static List<List<Integer>> levelOrderTraversal(TreeNode root) {
		List<List<Integer>> ans = new ArrayList<>();
		Deque<Pair<TreeNode, Integer>> queue = new LinkedList<>();
		queue.add(Pair.of(root, 0));
		int currentLevel = 0;
		List<Integer> levelList = new ArrayList<>();
		while (!queue.isEmpty()) {
			TreeNode temp;
			int level = queue.peek().getRight();

			if (level % 2 != 0) {
				temp = queue.peekLast().getLeft();
				queue.removeLast();
				if (temp.left != null)
					queue.offerLast(Pair.of(temp.left, level + 1));
				if (temp.right != null)
					queue.offerLast(Pair.of(temp.right, level + 1));
			}
			else {
				temp = queue.peekFirst().getLeft();
				queue.removeFirst();
				if (temp.left != null)
					queue.offerFirst(Pair.of(temp.left, level + 1));
				if (temp.right != null)
					queue.offerFirst(Pair.of(temp.right, level + 1));
			}
			if (currentLevel < level) {
				ans.add(new ArrayList<>(levelList));
				currentLevel = level;
				levelList.clear();
			}
			levelList.add(temp.val);
		}
		if (queue.isEmpty())
			ans.add(new ArrayList<>(levelList));
		return ans;
	}
}
