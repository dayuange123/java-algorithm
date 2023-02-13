package test;


import java.util.Stack;

public class EvaluateTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

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
	}

	public boolean evaluateTree(TreeNode root) {
		if (root.left == null) {
			return root.val == 1;
		}
		int val = root.val;
		boolean b = evaluateTree(root.left);
		boolean b1 = evaluateTree(root.right);
		return val == 2 ? (b || b1) : (b && b1);
	}



}
