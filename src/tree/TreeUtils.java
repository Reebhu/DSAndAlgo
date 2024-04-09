package tree;

public class TreeUtils {

	public static TreeNode createTree() {
		/*        10
                /     \
               12     13
                     /  \
                    14   15
                   / \   / \
                  21 22 23 24

		 */
		TreeNode tree = new TreeNode(10);
		tree.left = new TreeNode(12);
		tree.right = new TreeNode(13);

		tree.right.left = new TreeNode(14);
		tree.right.right = new TreeNode(15);

		tree.right.left.left = new TreeNode(21);
		tree.right.left.right = new TreeNode(22);
		tree.right.right.left = new TreeNode(23);
		tree.right.right.right = new TreeNode(24);
		return tree;
	}
}
