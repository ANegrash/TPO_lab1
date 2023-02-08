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
        addUtil(head,null,value);
    }
    void addUtil(TreeNode t, TreeNode parent, int value) {

        if (head == null) {
            head = new TreeNode(value, parent);
        }
        else {
            if(t.data > value) {
                if(t.left == null) {
                    t.left = new TreeNode(value, t);
                    return;
                }
                addUtil(t.left,t,value);
            }
            else {
                if(t.right == null) {
                    t.right = new TreeNode(value, t);
                    return;
                }
                addUtil(t.right,t,value);
            }
        }
    }


    public void inorder() {
        System.out.print("inorder: ");
        inorderUtil(head, 0);
    }
    void inorderUtil(TreeNode t, int i) {
        i++;
        if(t == null)
            return;
        inorderUtil(t.left, i);
        System.out.print(" "+t.data);
        inorderUtil(t.right, i);
        if(i == 1)
            System.out.println();
    }

    public void preorder() {
        System.out.print("preorder: ");
        preorderUtil(head, 0);
    }
    void preorderUtil(TreeNode t, int i) {
        i++;
        if(t == null)
            return;
        System.out.print(" "+t.data);
        preorderUtil(t.left, i);
        preorderUtil(t.right, i);
        if(i == 1)
            System.out.println();
    }
    public void postorder() {
        System.out.print("postorder: ");
        postorderUtil(head, 0);
    }
    void postorderUtil(TreeNode t, int i) {
        i++;
        if(t == null)
            return;
        postorderUtil(t.left, i);
        postorderUtil(t.right, i);
        System.out.print(" "+t.data);
        if(i == 1)
            System.out.println();
    }
    int maxHeight(TreeNode t) {
        if(t == null)
            return 0;
        else {
            int lHeight = maxHeight(t.left);
            int rHeight = maxHeight(t.right);
            if(lHeight > rHeight)
                return lHeight+1;
            else
                return rHeight+1;
        }
    }
    public void levelOrder() {
        System.out.print("levelOrder: ");
        int height = maxHeight(head);
        for(int i = 1; i<=height; i++) levelorderUtil(head, i); System.out.println(); } void levelorderUtil(TreeNode t, int lvl) { if(lvl == 1) System.out.print(t.data+" "); else { levelorderUtil(t.left, lvl-1); levelorderUtil(t.right, lvl-1); } } public void print() { printUtil(head, 0, 0); } void printUtil(TreeNode t, int c, int lvl) {//left -> -1 right -> 1
        int shift = 20;
        if(t == null) {
            return;
        }
        for(int i = 0; i<c+shift; i++) { System.out.print(" "); } System.out.println(t.data); lvl += 2; printUtil(t.left, c-10+(lvl), lvl); printUtil(t.right, c+10-(lvl), lvl); } public void delete(int value) { if(findNode(head, value)) { System.out.println("deleted node "+value); } else { System.out.println("node "+value+" not found! "); } } boolean findNode(TreeNode t, int value) { while(t != null) { if(t.data > value) {
        t = t.left;
    }
    else if(t.data < value){
        t = t.right;
    }
    else {
        //delete
        deleteUtil(t,t.parent,value);
        return true;
    }

    }
        return false;
    }
    void deleteUtil(TreeNode t,TreeNode p, int value) {
        //2 child
        if(t.left != null && t.right != null) {
            t.data = findMax(t.left);
            deleteUtil(t.left, t, t.data);
        }
        //no child
        else if(t.left == null && t.right == null) {
            if(p.left.data == t.data) {
                p.left = null;
            }
            else {
                p.right = null;
            }
        }
        //1 child
        else {
            TreeNode temp = t.left == null ? t.right : t.left;
            if(p.left.data == t.data) {
                p.left = temp;
            }
            else {
                p.right = temp;
            }
        }
    }
    int findMax(TreeNode t) {
        if(t.right != null) {
            t = t.right;
        }
        return t.data;
    }

}

