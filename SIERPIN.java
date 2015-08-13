/* 
************************************************************************
*  SIERPIN.java     Creates Sierpinsky gasket fractal                  *
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

public class SIERPIN      

{
  public static void main(String[] argv) throws IOException, FileNotFoundException
{
	//
	//Initialize file to write data to:
	//
	PrintWriter q = new PrintWriter(
			 new FileOutputStream("SIERPIN.DAT"),true);

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
	double a1=20.0, b1=20.0;         //vertex #1
	double a2=320.0, b2=20.0;        //vertex #2
	double a3=170.0, b3=280.0;       //vertex #3
	double x=180.0, y=150.0, r=0.0;
	
	for(i=1;i<=imax;i++)
		{
		r=randnum.nextDouble();
		
		if(r<=0.333333333333333)	
			{
			x=0.5*(x+a1);
			y=0.5*(y+b1);
			}

		else if(r>0.333333333333333 && r<=0.666666666666666)	
			{
			x=0.5*(x+a2);
			y=0.5*(y+b2);
			}

		else
			{
			x=0.5*(x+a3);
			y=0.5*(y+b3);
			}

		q.println(x+" , "+y);

		}



	System.out.println(" ");
	System.out.println("SIERPIN Program Complete.");
	System.out.println("Data stored in SIERPIN.DAT");
	System.out.println(" ");
	System.out.println(" ");
	System.out.println(" ");
	System.out.println(" ");
}


}   // End of file