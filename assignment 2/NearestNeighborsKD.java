//Name: Jason Lam
//Student ID: 300237438
import java.util.*;
public class NearestNeighborsKD {
    //instance variable
    KDTree KDTree;
    //constructor
    public NearestNeighborsKD(List<Point3D> points){
        this.KDTree=new KDTree();
        ArrayList<Point3D> neighbors;
        for (Point3D point:points) {
            this.KDTree.add(point);
        }
    }
    //first rangeQuery method
    public List<Point3D> rangeQuery(double eps,Point3D point){
        List<Point3D> neighbors = new ArrayList<Point3D>();
        rangeQuery(point,eps,neighbors,KDTree.getRoot());
        return neighbors;
    }
    //second rangeQuery method
    public void rangeQuery(Point3D point, double eps, List<Point3D> neighbors, KDTree.KDnode node){
        if (node == null)
            return;
    
        if (node.point.distance(point)<eps)
            neighbors.add(node.point);
    
        if ((point.get(node.axis)-eps)<=node.value)
            rangeQuery(point,eps,neighbors,node.left);
    
        if ((point.get(node.axis)+eps)>node.value)
            rangeQuery(point,eps,neighbors,node.right);
    
        return;
       }
}