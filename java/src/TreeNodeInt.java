public class TreeNodeInt {
    final static int LEFT = 0;
    final static int RIGHT = 1;
    int data;
    TreeNodeInt right;
    TreeNodeInt left;

    public TreeNodeInt(int data) {
        this.data = data;
        right = null;
        left = null;
    }

    public TreeNodeInt getLeft(){
        return left;
    }

    public TreeNodeInt getRight(){
        return right;
    }

    public int getData(){
        return data;
    }

    public void setLeft(TreeNodeInt left){
        this.left = left;
    }

    public void setRight(TreeNodeInt right){
        this.right = right;
    }

    public void recursiveInsert(TreeNodeInt node){
        if (node.getData() < data){
            if (left != null){
                left.recursiveInsert(node);
            } else {
                left = node;
            }
        } else {
            if (right != null){
                right.recursiveInsert(node);
            } else {
                right = node;
            }
        }
    }

    public void inorder(){
        if (left != null){
            left.inorder();
        }
        System.out.println(data);
        if (right != null){
            right.inorder();
        }
    }

    public TreeNodeInt recursiveMinSearch(){
        if (left == null){
            return this;
        }
        return left.recursiveMinSearch();
    }

    public TreeNodeInt recursiveMaxSearch(){
        if (right == null){
            return this;
        }
        return right.recursiveMaxSearch();
    }

}