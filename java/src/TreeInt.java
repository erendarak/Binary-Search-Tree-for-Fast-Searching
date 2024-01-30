public class TreeInt {

    protected TreeNodeInt root;

    public TreeInt(){
        root=null;
    }

    /**
     * This is a recursive insertion function. It adds all new nodes to root accordingly.
     * @param node
     */
    public void recursiveInsert(TreeNodeInt node){
        if (root == null){
            root = node;
        } else {
            root.recursiveInsert(node);
        }
    }

    /**
     * This method gets the parent node of the given node.
     * @param node given node
     * @return parent node
     */
    protected TreeNodeInt getParent(TreeNodeInt node){
        TreeNodeInt x = root, parent = null;
        while (x != node){
            parent = x;
            if (x.data > node.data){
                x = x.left;
            } else {
                x = x.right;
            }
        }
        return parent;
    }

    /**
     * This method deletes a given value from the BST.
     * @param value given value
     */
    public void delete(int value){
        TreeNodeInt y, x = root, parent;
        while (x.data != value){
            if (x.data > value){
                x = x.left;
            } else {
                x = x.right;
            }
        }
        parent = getParent(x);
        while (true){
            if (x.left != null){
                y = x.left.recursiveMaxSearch();
                parent = getParent(y);
            } else {
                if (x.right != null){
                    y = x.right.recursiveMinSearch();
                    parent = getParent(y);
                } else {
                    if (parent == null){
                        root = null;
                    } else {
                        if (parent.left == x){
                            parent.left = null;
                        } else {
                            parent.right = null;
                        }
                    }
                    break;
                }
            }
            x.data = y.data;
            x = y;
        }
    }

    /**
     * This method prints all nodes in increasing order.
     */
    public void inorder(){
        if (root != null){
            root.inorder();
        }
    }

    /**
     * This method finds exactly given value.
     * @param value given value
     * @return node that has given value
     */
    public TreeNodeInt exactSearch(int value){
        TreeNodeInt tmp = root;
        while (tmp != null){
            if (value < tmp.getData()){
                tmp = tmp.getLeft();
            } else {
                if (value > tmp.getData()){
                    tmp = tmp.getRight();
                } else {
                    return tmp;
                }
            }
        }
        return null;
    }

    /**
     * This is the interval search method for given number and given operator which takes all number according to the operator
     * @param value given value
     * @param operator given operator
     */
    public void intervalSearch(int value, char operator){
        realIntervalSearch(root,value,operator);
    }

    /**
     * This is the helper method for intervalSearch method. This makes all the work.
     * @param node root
     * @param value given value
     * @param operator given operator
     */
    public void realIntervalSearch(TreeNodeInt node, int value, char operator){
        if(node == null){
            return;
        }

        if(operator == '<'){
            realIntervalSearch(node.left,value,operator);
            if (node.getData() < value){
                System.out.println(node.getData());
            }
            realIntervalSearch(node.right,value,operator);
        } else if (operator == '>'){
            realIntervalSearch(node.left,value,operator);
            if (node.getData() > value){
                System.out.println(node.getData());
            }
            realIntervalSearch(node.right,value,operator);
        }
    }

}