import java.util.ArrayList;
import java.util.List;

public class MyBST {
    private Node root;

    private class Node {
        int val;
        Node left;
        Node right;
        private int size;

        public Node(int val, int size) {
            this.val = val;
            this.size = size;
        }
    }

    public MyBST() {

    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        return x.size;
    }

    public void insert(int val) {
        root = insert(root, val);
    }

    private Node insert(Node x, int val) {
        if (x == null) return new Node(val, 1);
        if (val < x.val) x.left = insert(x.left, val);
        else if (val > x.val) x.right = insert(x.right, val);
        else x.val = val;
        x.size = 1 + size(x.left) + size(x.right);
        return x;

    }

    public double avgPathLength() {
        return avgPathLength(root);
    }

    private double avgPathLength(Node x) {
        List<Integer> list = new ArrayList<>();
        double avg = 0;
        if (x != null) searchBST(root, 1, list);
        // calculate the avg
        Integer sum = 0;
        if (!list.isEmpty()) {
            for (Integer val : list) {
                sum += val;
            }
            avg = sum.doubleValue()/list.size();
        }
        return avg;
    }

    private void searchBST (Node x, int length, List<Integer> list) {
        if (x.left == null && x.right == null) {
            list.add(length);
        }
        if (x.left != null) {
            searchBST(x.left, length + 1, list);
        }
        if (x.right != null) {
            searchBST(x.right, length + 1, list);
        }
    }

}
