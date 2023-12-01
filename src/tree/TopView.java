package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TopView {

	public static void main(String[] args) {
		TreeNode tree = new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3, null, new TreeNode(4)
		));
		System.out.println(topview(tree));
	}

	public static List<Integer> topview(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		Map<Integer, List<TreeNode>> verticalLevelMap = new TreeMap<>();

		dfs(root, 0, verticalLevelMap);

		for (Map.Entry<Integer, List<TreeNode>> entry : verticalLevelMap.entrySet()) {
			res.add(entry.getValue().get(0).val);
		}

		return res;

	}

	private static void dfs(TreeNode root, int level, Map<Integer, List<TreeNode>> map) {

		if (root == null)
			return;

		map.put(level, map.getOrDefault(level, new ArrayList<>()));
		List<TreeNode> levelList = map.getOrDefault(level, new ArrayList<>());
		levelList.add(root);

		dfs(root.left, level - 1, map);
		dfs(root.right, level + 1, map);
	}
}
