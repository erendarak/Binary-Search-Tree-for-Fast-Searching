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
}