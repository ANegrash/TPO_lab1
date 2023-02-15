package work;

public class BTree {
    TreeNode head;

    private static class TreeNode {
        int data;
        TreeNode parent;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data, TreeNode parent) {
            this.data = data;
            this.parent = parent;
        }
    }

    public void add(int value) {
        addUtil(head, null, value);
    }

    void addUtil(TreeNode t, TreeNode parent, int value) {
        if (head == null)
            head = new TreeNode(value, parent);
        else {
            if (t.data > value) {
                if (t.left == null) {
                    t.left = new TreeNode(value, t);
                    return;
                }
                addUtil(t.left, t, value);
            } else {
                if (t.right == null) {
                    t.right = new TreeNode(value, t);
                    return;
                }
                addUtil(t.right, t, value);
            }
        }
    }

    public void print() {
        printUtil(head, 0, 0);
    }

    void printUtil(TreeNode t, int c, int lvl) {
        int shift = 20;
        if (t == null)
            return;
        for (int i = 0; i < c+shift; i++)
            System.out.print(" ");
        System.out.println(t.data);
        lvl += 2;
        printUtil(t.left, c - 10 + (lvl), lvl);
        printUtil(t.right, c + 10 - (lvl), lvl);
    }

    public void delete(int value) {
        if (delNode(head, value))
            System.out.println("Deleted node: " + value);
        else
            System.out.println("Node \"" + value + "\" not found");
    }

    public void find(int value) {
        findUtil(head, value);
    }

    void findUtil(TreeNode t, int value) {
        String path = "" + value;
        while (t != null) {
            if (t.data > value)
                t = t.left;
            else if (t.data < value)
                t = t.right;
            else
                break;
        }

        if (t == null)
            System.out.println("We can't find this element");
        else {
            while (t.parent != null) {
                path = t.parent.data + " -> " + path;
                t = t.parent;
            }
            path = "Path to element: " + path;
            System.out.println(path);
        }
    }

    boolean delNode(TreeNode t, int value) {
        while (t != null) {
            if (t.data > value)
                t = t.left;
            else if (t.data < value)
                t = t.right;
            else {
                deleteUtil(t, t.parent, value);
                return true;
            }
        }
        return false;
    }

    void deleteUtil(TreeNode t, TreeNode p, int value) {
        if (t.left != null && t.right != null) {
            t.data = findMax(t.left);
            deleteUtil(t.left, t, t.data);
        } else if (t.left == null && t.right == null) {
            if (p.left.data == t.data)
                p.left = null;
            else
                p.right = null;
        } else {
            TreeNode temp = t.left == null ? t.right : t.left;
            if (p.left.data == t.data)
                p.left = temp;
            else
                p.right = temp;
        }
    }

    int findMax(TreeNode t) {
        if (t.right != null)
            t = t.right;
        return t.data;
    }
}