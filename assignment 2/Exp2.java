//Name: Jason Lam
//Student ID: 300237438
import java.util.*;
import java.io.*;  
public class Exp2 {
    //read class taken from exp 1 to read the file
    public static List<Point3D> read(String filename) throws Exception {
	  
        List<Point3D> points= new ArrayList<Point3D>(); 
        double x,y,z;
        
        Scanner sc = new Scanner(new File(filename));  
        // sets the delimiter pattern to be , or \n \r
        sc.useDelimiter(",|\n|\r");  
    
        // skipping the first line x y z
        sc.next(); sc.next(); sc.next();
        
        // read points
        while (sc.hasNext())  
        {  
            x= Double.parseDouble(sc.next());
            y= Double.parseDouble(sc.next());
            z= Double.parseDouble(sc.next());
            points.add(new Point3D(x,y,z));  
        }   
        
        sc.close();  //closes the scanner  
        
        return points;
      }
    public static long KDTime(List<Point3D> points,double eps){
        long averageTime=0;
        int counter=0;
        for (int i = 0; i<points.size(); i+=10) {
            counter++;
            Point3D query = points.get(i);
            NearestNeighborsKD nn= new NearestNeighborsKD(points);
            long startTime = System.nanoTime();
	        List<Point3D> neighbors= nn.rangeQuery(eps,query);
            long endTime = System.nanoTime();
            averageTime+= (endTime - startTime);
        }
        averageTime = averageTime/counter;
        return averageTime;
       
    }
    public static long LinTime(List<Point3D> points,double eps){
        long averageTime=0;
        int counter=0;
        for (int i = 0; i<points.size(); i+=10) {
            counter++;
            Point3D query = points.get(i);
            NearestNeighbors nn= new NearestNeighbors(points);
            long startTime = System.nanoTime();
	        List<Point3D> neighbors= nn.rangeQuery(eps,query);
            long endTime = System.nanoTime();
            averageTime+= (endTime - startTime);
        }
        averageTime = averageTime/counter;
        return averageTime;
    }

    //main to run the tests
    public static void main(String[] args) throws Exception {  
    double eps = 0.5;
    long kdtime1 = 0;
    long kdtime2 = 0;
    long kdtime3 = 0;
    long lintime1 = 0;
    long lintime2 = 0;
    long lintime3 = 0;
    List<Point3D> points= Exp1.read("Point_Cloud_1.csv");
    List<Point3D> points2= Exp1.read("Point_Cloud_2.csv");
    List<Point3D> points3= Exp1.read("Point_Cloud_3.csv");
    kdtime1 = KDTime(points,eps);
    kdtime2 = KDTime(points2,eps);
    kdtime3 = KDTime(points3,eps);
    lintime1 = LinTime(points, eps);
    lintime2 = LinTime(points2, eps);
    lintime3=LinTime(points3, eps);
    System.out.println("Average time for rangequery with KD tree point cloud 1 = "+kdtime1+"ns");
    System.out.println("Average time for rangequery with KD tree point cloud 2 = "+kdtime2+"ns");
    System.out.println("Average time for rangequery with KD tree point cloud 3 = "+kdtime3+"ns");
    System.out.println("Average time for rangequery with linear point cloud 1 = "+lintime1+"ns");
    System.out.println("Average time for rangequery with linear point cloud 2 = "+lintime2+"ns");
    System.out.println("Average time for rangequery with linear point cloud 3 = "+lintime3+"ns");
    }
}
