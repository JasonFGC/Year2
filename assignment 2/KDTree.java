//Name: Jason Lam
//Student ID: 300237438
public class KDTree {
    
    // Inner class for KDnodes
    public class KDnode {
        //instance variables
        public Point3D point;
        public int axis;
        public double value;
        public KDnode left;
        public KDnode right;
        

        public KDnode(Point3D point, int axis) {
            this.point = point;
            this.axis = axis;
            this.value = point.get(axis);
            left = null;
            right = null;
        }
    }
    private KDnode root;
    

    // Gets the root of a KDnode.
    public KDnode getRoot() {
        return root;
    }

    // Creates the empty tree
    public KDTree() {
        root = null;
    }

    // Inserts a node into the tree
    public KDnode insert(Point3D point, KDnode node, int axis) {

        if (node==null){
            node = new KDnode(point, axis);
        }
         else if (point.get(axis) <= node.value) {
            node.left = insert(point, node.left, (axis + 1) % 3);
        } 
        else {
            node.right = insert(point, node.right, (axis + 1) % 3);
        }
        return node;
    }
//Add class that calls the insert method
    public void add(Point3D point) {
        if (root==null){
            root = new KDnode(point, 0);
        }
        else{
        insert(point, root, 0);
        }
    }
    



}
