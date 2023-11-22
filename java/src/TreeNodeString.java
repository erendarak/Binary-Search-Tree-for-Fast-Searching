public class TreeNodeString {

    String data;
    TreeNodeString right;
    TreeNodeString left;

    public TreeNodeString(String data) {
        this.data = data;
        right = null;
        left = null;
    }

    public TreeNodeString getLeft(){
        return left;
    }

    public TreeNodeString getRight(){
        return right;
    }

    public String getData(){
        return data;
    }

    public void setLeft(TreeNodeString left){
        this.left = left;
    }

    public void setRight(TreeNodeString right){
        this.right = right;
    }

    public void recursiveInsert(TreeNodeString node){
        int compare = Character.compare(node.getData().charAt(0), data.charAt(0));

        if(compare == 0){
            for(int i = 1; compare == 0; i++){
                compare = Character.compare(node.getData().charAt(i), data.charAt(i));
            }
        }
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

    public void inorder(){
        if (left != null){
            left.inorder();
        }
        System.out.println(data);
        if (right != null){
            right.inorder();
        }
    }
}