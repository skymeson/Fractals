/* 
************************************************************************
*  COLUMN.java  Correlated ballistic deposition to form fractal        *
*                                                                      *
*  taken from "Projects in Computational Physics" by Landau and Paez   *
*	       copyrighted by John Wiley and Sons, New York            *
*                                                                      *
*  written by students in PH465/565, Computational Physics,            *
*	       at Oregon State University                              *
*                                                                      *
*  converted to java by J. Scott Berry                                 *
*  code copyrighted by RH Landau                                       *
*                                                                      *
*  supported by: US National Science Foundation, Northwest Alliance    *
*                for Computational Science and Engineering (NACSE),    *
*                US Department of Energy 	                       *
*								       *
************************************************************************
*/ 

import java.io.*;       //Location of PrintWriter
import java.util.*;     //Location of Random
import java.lang.*;     //Location of Math

public class COLUMN      

{
  public static void main(String[] argv) throws IOException, FileNotFoundException
{
	//
	//Initialize file to write data to:
	//
	PrintWriter q = new PrintWriter(
			 new FileOutputStream("COLUMN.DAT"),true);

	//
	//Initialize 48 bit pseudo-random number generator:
	//
	long seed = 971761;   //Different seeds generate different sequences
	Random randnum = new Random(seed); 

	//
	// To write to file:
	//			q.println("Text to write");
	//
	//To access next random double:
	//			randnum.nextDouble()


	//
	//variable declarations
	//
	int max=100000;            //number of iterations
	int npoints=200;           //number of open spaces

	int i=0, dist=0, r=0, x=0, y=0, oldx=0, oldy=0;
	double pp=0.0, prob=0.0;

	int hit[] = new int[200];
	for(i=0;i<npoints;i++) hit[i]=0;  //clear array
	
	oldx=100;
	oldy=0;
	
	for(i=1;i<=max;i++)
		{
		r=(int)(npoints*randnum.nextDouble());
		x=r-oldx;
		y=hit[r]-oldy;
		dist=x*x+y*y;
		
		if(dist==0) prob=1.0;  //prob of sticking depends on 
				       // distance to the last particle
		
		else prob=9.0/dist;    //nu = -2.0, c = 0.9
		
		pp=randnum.nextDouble();
		
		if(pp<prob)
			{
			if(r>0 && r<(npoints-1))
				{
				if((hit[r] >= hit[r-1]) 
					&& (hit[r] >= hit[r+1]))
					hit[r]++;
				
				else if(hit[r-1] > hit[r+1])
					hit[r]=hit[r-1];
				
				else hit[r]=hit[r+1];
				
				oldx=r;
				oldy=hit[r];
				q.println(r+" , "+hit[r]);
				}
			}
		
		}
	
	
	System.out.println(" ");
	System.out.println("COLUMN Program Complete.");
	System.out.println("Data stored in COLUMN.DAT");
	System.out.println(" ");

}


}   // End of file