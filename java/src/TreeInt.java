public class TreeInt {

    TreeNodeInt root;

    public TreeInt(){
        root=null;
    }

    public void recursiveInsert(TreeNodeInt node){
        if (root == null){
            root = node;
        } else {
            root.recursiveInsert(node);
        }
    }

    public void inorder(){
        if (root != null){
            root.inorder();
        }
    }

    public TreeNodeInt recursiveMinSearch(){
        if (root != null){
            return root.recursiveMinSearch();
        }
        return null;
    }

    public TreeNodeInt recursiveMaxSearch(){
        if (root != null){
            return root.recursiveMaxSearch();
        }
        return null;
    }

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

    public void intervalSearch(int value, char operator) {
        intervalSearchHelper(root, operator, value);
    }

    private void intervalSearchHelper(TreeNodeInt node, char operator, int value) {
        if (node == null) {
            return;
        }

        if (operator == '<') {
            intervalSearchHelper(node.left, operator, value);
            if (node.getData() < value) {
                System.out.println(node.getData());
            }
            intervalSearchHelper(node.right, operator, value);
        } else if (operator == '>') {
            intervalSearchHelper(node.left, operator, value);
            if (node.getData() > value) {
                System.out.println(node.getData());
            }
            intervalSearchHelper(node.right, operator, value);
        }
    }




}