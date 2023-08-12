/** 
 * Kyle Sprague
 * SN
 * CSI 2110
 *
 * Point3D is a simple class with the principle task of storing the
 * Information of a point in 3D euclidian space
 * I decided it would be a good idea to sort the points so I had
 * Point3D implement Comparable
 *
 * @author Kyle Sprague
 */
//Name: Jason Lam
//Student ID: 300237438
import java.lang.Math;

public class Point3D{
    private double X;
    private double Y;
    private double Z;
    public boolean stacked=false;
    // -1 will correspond too unlabelled
    public int label = -1;

    public Point3D(double x, double y, double z){
        X=x;
        Y=y;
        Z=z;
    }
    /**
     * Getters       
     */
    public double getX(){return X;}
    public double getY(){return Y;}
    public double getZ(){return Z;}
    public String toString(){return "("+X+","+Y+","+Z+")";}

    /**
	* Function to get the euclidian distance between this point and pt
    * this is implemented to get the distance as fast as possible
    * @param pt The point we want the distance to (from this point)
	* @return
	* 	3D euclidian distance
	*/
    public double distance(Point3D pt){
        return Math.sqrt(L2(pt));
    }

    /**
	* Conceptually same as distance but faster since you don't call Sqrt
    */
    public double L2(Point3D pt){
        //collect individual 1D distances
        double dx=(X-pt.X);
        double dy=(Y-pt.Y);
        double dz=(Z-pt.Z); 
        //calculate euclidian 3D distance squared
        return dx*dx+dy*dy+dz*dz;
    }
    public double get(int axis){
        if (axis==0){
            return X;
        }
        else if (axis==1){
            return Y;
        }
        else{
            return Z;
        }
    }


}
