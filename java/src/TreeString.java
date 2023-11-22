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
}