package tree;

import util.Pair;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ZizZagTraversal {
/*
* /*              10
                /     \
               12     13
                     /  \
                    14   15
                   / \   / \
                  21 22 23 24

        Let us create Binary Tree as shown*/
public static void main(String[] args) {
	TreeNode tree = new TreeNode(10);
	tree.left = new TreeNode(12);
	tree.right = new TreeNode(13);

	tree.right.left = new TreeNode(14);
	tree.right.right = new TreeNode(15);

	tree.right.left.left = new TreeNode(21);
	tree.right.left.right = new TreeNode(22);
	tree.right.right.left = new TreeNode(23);
	tree.right.right.right = new TreeNode(24);
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
			TreeNode temp = queue.peek().getLeft();
			int level = queue.peek().getRight();
			System.out.print(queue.poll().getLeft().val + " ");

			if (level % 2 == 0) {
				if (temp.left != null) queue.offerLast(Pair.of(temp.left, level + 1));
				if (temp.right != null) queue.offerLast(Pair.of(temp.right, level + 1));
			}
			else {
				if (temp.right != null) queue.offerLast(Pair.of(temp.right, level + 1));
				if (temp.left != null) queue.offerLast(Pair.of(temp.left, level + 1));
			}

		}

//		while (!queue.isEmpty()) {
//			TreeNode temp;
//			int level = queue.peek().getRight();
//
//			if (level % 2 != 0) {
//				temp = queue.peekLast().getLeft();
//				queue.removeLast();
//				if (temp.left != null)
//					queue.offerLast(Pair.of(temp.left, level + 1));
//				if (temp.right != null)
//					queue.offerLast(Pair.of(temp.right, level + 1));
//			}
//			else {
//				temp = queue.peekFirst().getLeft();
//				queue.removeFirst();
//				if (temp.left != null)
//					queue.offerFirst(Pair.of(temp.left, level + 1));
//				if (temp.right != null)
//					queue.offerFirst(Pair.of(temp.right, level + 1));
//			}
//			if (currentLevel < level) {
//				ans.add(new ArrayList<>(levelList));
//				currentLevel = level;
//				levelList.clear();
//			}
//			levelList.add(temp.val);
//		}
//		if (queue.isEmpty())
//			ans.add(new ArrayList<>(levelList));
//		return ans;
//	}
		return null;
	}
}
