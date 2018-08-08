package alibaba;

import java.net.Socket;
import java.rmi.server.SocketSecurityException;
import java.util.Stack;

public class TreeSearch {

	public static void main(String[] args) {
       search(new TreeNode(new TreeNode(new TreeNode(4), new TreeNode(5), 2), new TreeNode(new TreeNode(6), new TreeNode(7), 3), 1));
	}

	public static void search(TreeNode root) {
		if (root == null) {
			System.out.println("error input");
			return;
		}
		Stack<TreeNode> s = new Stack<>();
		s.push(root);
		while (!s.empty()) {
			root = s.pop();
			if (root.flag) {
				System.out.println(root.val);
			} else {
				root.flag = true;
				if (root.right != null)
					s.push(root.right);
				if (root.left != null)
					s.push(root.left);
				s.push(root);
			}
		}
	}

	static class TreeNode {
		public TreeNode(TreeNode left, TreeNode right, int val) {
			super();
			this.left = left;
			this.right = right;
			this.val = val;
		}

		public TreeNode left;
		public TreeNode right;
		public int val;
		public boolean flag;

		public TreeNode(int val) {
			this.val = val;
		}
	}

}
