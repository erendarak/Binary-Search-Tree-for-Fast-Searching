public class TreeNodeInt {
    final static int LEFT = 0;
    final static int RIGHT = 1;
    int data;
    protected TreeNodeInt right;
    protected TreeNodeInt left;

    /**
     * Contructor for our id BST
     * @param data
     */
    public TreeNodeInt(int data) {
        this.data = data;
        right = null;
        left = null;
    }

    /**
     * This method prints all nodes in increasing order.
     */
    public void inorder(){
        if (left != null){
            left.inorder();
        }
        System.out.println(data);
        if (right != null){
            right.inorder();
        }
    }

    /**
     * This method recursively finds minimum value in BST.
     * @return min node
     */
    public TreeNodeInt recursiveMinSearch(){
        if (left == null){
            return this;
        }
        return left.recursiveMinSearch();
    }

    /**
     * This method recursively finds maximum value in BST.
     * @return max node
     */
    public TreeNodeInt recursiveMaxSearch(){
        if (right == null){
            return this;
        }
        return right.recursiveMaxSearch();
    }

    /**
     * This is a recursive insertion function. It adds all new nodes to root accordingly.
     * @param node
     */
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

    //These all are getters and setters for treenodeInt attributes.
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
}