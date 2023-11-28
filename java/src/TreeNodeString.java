public class TreeNodeString {

    protected String data;
    protected TreeNodeString right;
    protected TreeNodeString left;

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

    public void inorder(){
        if (left != null){
            left.inorder();
        }
        System.out.println(data);
        if (right != null){
            right.inorder();
        }
    }
    /*public void recursiveInsert(TreeNodeInt node){
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
    }*/
    public void recursiveInsert(TreeNodeString node){
        //int k = Character.compare(node.getData().charAt(0), data.charAt(0));
        int compare = node.getData().compareToIgnoreCase(data);
        /*if(compare == 0){
            for(int i = 0; compare == 0; i++){
                compare = Character.compare(node.getData().charAt(i), data.charAt(i));
            }
        }*/
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
    public TreeNodeString recursiveMinSearch(){
        if (left == null){
            return this;
        }
        return left.recursiveMinSearch();
    }

    public TreeNodeString recursiveMaxSearch(){
        if (right == null){
            return this;
        }
        return right.recursiveMaxSearch();
    }

    public void setData(String data) {
        this.data = data;
    }
}