public class TreeNodeString {

    public String data;
    public TreeNodeString right;
    public TreeNodeString left;

    /**
     * Constructor for our namesurname BST.
     * @param data
     */
    public TreeNodeString(String data) {
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
     * This is a recursive insertion function. It adds all new nodes to root accordingly.
     * @param node
     */
    public void recursiveInsert(TreeNodeString node){
        int compare = node.getData().compareToIgnoreCase(data);
        if (compare < 0){
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

    /**
     * This method recursively finds minimum value in BST.
     * @return min node
     */
    public TreeNodeString recursiveMinSearch(){
        if (left == null){
            return this;
        }
        return left.recursiveMinSearch();
    }

    /**
     * This method recursively finds maximum value in BST.
     * @return max node
     */
    public TreeNodeString recursiveMaxSearch(){
        if (right == null){
            return this;
        }
        return right.recursiveMaxSearch();
    }

    //These all are getters and setters for treenodeInt attributes.
    public TreeNodeString getLeft(){
        return left;
    }

    public TreeNodeString getRight(){
        return right;
    }

    public String getData(){
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setLeft(TreeNodeString left){
        this.left = left;
    }

    public void setRight(TreeNodeString right){
        this.right = right;
    }

}