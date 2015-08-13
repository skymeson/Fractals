/* 
************************************************************************
*  FERN.java   Creates a fractal, fern-like pattern                    *
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

public class FERN      

{
  public static void main(String[] argv) throws IOException, FileNotFoundException
{
	//
	//Initialize file to write data to:
	//
	PrintWriter q = new PrintWriter(
			 new FileOutputStream("FERN.DAT"),true);

	//
	//Initialize 48 bit pseudo-random number generator:
	//
	long seed = 899432;   //Different seeds generate different sequences
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
	int imax=29999;                     		
	int i=0;
	double x=0.5, y=0.0, r=0.0, xn=0.0, yn=0.0;
	
	for(i=1;i<=imax;i++)
		{
		r=randnum.nextDouble();

		if(r<=0.02)
			{
			xn=0.5;
			yn=0.27*y;
			}

		else if(r>0.02 && r<=0.17)
			{
			xn=-0.139*x+0.263*y+0.57;
			yn=0.246*x+0.224*y-0.036;
			}

		else if(r>0.17 && r<=0.3)
			{
			xn=0.17*x-0.215*y+0.408;
			yn=0.222*x+0.176*y+0.0893;
			}

		else 
			{
			xn=0.781*x+0.034*y+0.1075;
			yn=-0.032*x+0.739*y+0.27;
			}

		q.println(xn+" , "+yn);
		x=xn;
		y=yn;

		}



	System.out.println(" ");
	System.out.println("FERN Program Complete.");
	System.out.println("Data stored in FERN.DAT");
	System.out.println(" ");
	System.out.println(" ");
	System.out.println(" ");
	System.out.println(" ");
}


}   // End of file