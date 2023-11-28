import java.util.Objects;

public class TreeString {

    protected TreeNodeString root;

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

    protected TreeNodeString getParent(TreeNodeString node) {
        TreeNodeString x = root, parent = null;

        while (x != null && !x.equals(node)) {
            int compare = node.getData().compareTo(x.getData());

            if (compare < 0) {
                parent = x;
                x = x.left;
            } else if (compare > 0) {
                parent = x;
                x = x.right;
            } else {
                for (int i = 1; compare == 0 && i < node.getData().length() && i < x.getData().length(); i++) {
                    compare = Character.compare(node.getData().charAt(i), x.getData().charAt(i));
                }

                if (compare < 0) {
                    x = x.left;
                } else if (compare > 0) {
                    x = x.right;
                }
            }
        }
        return parent;
    }

    public void delete(String value) {
        TreeNodeString x = root;
        TreeNodeString parent = null;

        while (x != null && !value.equals(x.getData())) {
            int compare = value.compareTo(x.getData());

            if (compare < 0) {
                parent = x;
                x = x.left;
            } else if (compare > 0) {
                parent = x;
                x = x.right;
            }
        }

        if (x == null) {
            return;
        }
        TreeNodeString y;
        while (true) {
            if (x.left != null) {
                y = x.left.recursiveMaxSearch();
                parent = getParent(y);
            } else {
                if (x.right != null) {
                    y = x.right.recursiveMinSearch();
                    parent = getParent(y);
                } else {
                    if (parent == null) {
                        root = null;
                    } else {
                        if (parent.left == x) {
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

    public TreeNodeString exactSearch(String value){
        TreeNodeString tmp = root;
        while (tmp != null){
            int compare = value.compareToIgnoreCase(tmp.getData());
            if(compare == 0){
                return tmp;
            }
            if (compare < 0){
                tmp = tmp.getLeft();
            }else{
                if (compare > 0){
                    tmp = tmp.getRight();
                }else{
                    return tmp;
                }
            }
        }
        return null;
    }

    public void intervalSearch(String value, char operator) {
        intervalSearchHelper(root, operator, value);
    }

    private void intervalSearchHelper(TreeNodeString node, char operator, String value) {
        if (node == null) {
            return;
        }
        int compare = value.compareToIgnoreCase(node.getData());
        if (operator == '<') {
            intervalSearchHelper(node.left, operator, value);
            if (compare > 0) {
                System.out.println(node.getData());
            }
            intervalSearchHelper(node.right, operator, value);
        } else if (operator == '>') {
            intervalSearchHelper(node.left, operator, value);
            if (compare < 0) {
                System.out.println(node.getData());
            }
            intervalSearchHelper(node.right, operator, value);
        }
    }

}