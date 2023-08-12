/*
 * Incomplete Experiment 1 
 *
 * CSI2510 Algorithmes et Structures de Donnees
 * www.uottawa.ca
 *
 * Robert Laganiere, 2022
 *
*/ 
//Name: Jason Lam
//Student ID: 300237438
import java.util.List;
import java.util.ArrayList;

import java.io.*;  
import java.util.Scanner;  

public class Exp1 {
  
  // reads a csv file of 3D points (rethrow exceptions!)
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
  
  public static void main(String[] args) throws Exception {  
  
    // not reading args[0]
	double eps= Double.parseDouble("0.05");
  
    // reads the csv file
    List<Point3D> points= Exp1.read("Point_Cloud_1.csv");
	
	Point3D query= new Point3D(Double.parseDouble("14.15982089"),
								Double.parseDouble("4.680702457"),
								Double.parseDouble("-0.133791584"));
	
	// creates the NearestNeighbor instance
	NearestNeighbors nn= new NearestNeighbors(points);
	List<Point3D> neighbors= nn.rangeQuery(eps,query);
	
	System.out.println("number of neighbors= "+neighbors.size());
	for (int i = 0; i < neighbors.size(); i++) {
		System.out.println(neighbors.get(i));
	}
	
  }   
}
