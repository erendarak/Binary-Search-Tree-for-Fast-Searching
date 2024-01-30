public class TreeString {

    public TreeNodeString root;

    /**
     * This is the constructor of out TreeString.
     */
    public TreeString(){
        root=null;
    }

    /**
     * This is a recursive insertion function. It adds all new nodes to root accordingly.
     * @param node
     */
    public void recursiveInsert(TreeNodeString node){
        if (root == null){
            root = node;
        } else {
            root.recursiveInsert(node);
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
     * This method gets the parent node of the given node.
     * @param node given node
     * @return parent node
     */
    protected TreeNodeString getParent(TreeNodeString node){
        TreeNodeString x = root, parent = null;

        while (x != null && x.equals(node)){
            int compare = node.getData().compareTo(x.getData());

            if (compare < 0){
                parent = x;
                x = x.left;
            } else if (compare > 0) {
                parent = x;
                x = x.right;
            } else{
                for(int i = 1; compare == 0 && i < node.getData().length() && i < x.getData().length(); i++){
                    compare = Character.compare(node.getData().charAt(i), x.getData().charAt(i));
                }
                if(compare < 0){
                    x = x.left;
                } else if(compare > 0){
                    x = x.right;
                }
            }
        }
        return parent;
    }

    /**
     * This method deletes a given value from the BST.
     * @param value given value
     */
    public void delete(String value){
        TreeNodeString x = root;
        TreeNodeString parent = null;

        while (x != null && !value.equals(x.getData())){
            int compare = value.compareToIgnoreCase(x.getData());

            if (compare < 0){
                parent = x;
                x = x.left;
            } else if (compare > 0) {
                parent = x;
                x = x.right;
            }
        }
        if(x==null){
            return;
        }
        TreeNodeString y;
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
            x.setData(y.getData());
            x = y;
        }
    }

    /**
     * This method finds exactly given value.
     * @param value given value
     * @return node that has given value
     */
    public TreeNodeString exactSearch(String value){
        TreeNodeString tmp = root;
        while (tmp != null){
            int compare = value.compareToIgnoreCase(tmp.getData());
            if (compare < 0){
                tmp = tmp.getLeft();
            } else {
                if (compare > 0){
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
    public void intervalSearch(String value, char operator){
        realIntervalSearch(root,value,operator);
    }

    /**
     * This is the helper method for intervalSearch method. This makes all the work.
     * @param node root
     * @param value given value
     * @param operator given operator
     */
    public void realIntervalSearch(TreeNodeString node, String value, char operator){
        if(node == null){
            return;
        }
        int compare = node.getData().compareTo(value);
        if(operator == '<'){
            realIntervalSearch(node.left,value,operator);
            if (compare < 0){
                System.out.println(node.getData());
            }
            realIntervalSearch(node.right,value,operator);
        } else if (operator == '>'){
            realIntervalSearch(node.left,value,operator);
            if (compare > 0){
                System.out.println(node.getData());
            }
            realIntervalSearch(node.right,value,operator);
        }
    }
}