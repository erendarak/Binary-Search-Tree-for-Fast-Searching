public class TreeString {

    TreeNodeString root;

    public TreeString(){
        root=null;
    }

    public void recursiveInsert(TreeNodeString node){
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

    protected TreeNodeString getParent(TreeNodeString node){
        TreeNodeString x = root, parent = null;
        while (x != node){
            parent = x;
            int compare = Character.compare(node.getData().charAt(0), x.getData().charAt(0));
            if(compare == 0){
                for(int i = 1; compare == 0; i++){
                    compare = Character.compare(node.getData().charAt(i), x.getData().charAt(i));
                }
            }
            if (compare < 0){
                x = x.left;
            } else {
                x = x.right;
            }
        }
        return parent;
    }

    public void delete(String value){
        TreeNodeString y, x = root, parent;
        int compare = Character.compare(value.charAt(0), x.getData().charAt(0));
        if(compare == 0 && !value.equals(x.getData())){
            for(int i = 0; compare == 0; i++){
                compare = Character.compare(value.charAt(i), x.getData().charAt(i));
            }
        }
        while (compare != 0){
            if (compare < 0){
                x = x.left;
                compare = Character.compare(value.charAt(0), x.getData().charAt(0));
            } else {
                x = x.right;
                compare = Character.compare(value.charAt(0), x.getData().charAt(0));
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
}