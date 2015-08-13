/* 
************************************************************************
*  DLA.java    Diffusion-limited aggregation simulation (fractals)     *
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

public class DLA      

{
  public static void main(String[] argv) throws IOException, FileNotFoundException
{
	//
	//Initialize file to write data to:
	//
	PrintWriter q = new PrintWriter(
			 new FileOutputStream("DLA.DAT"),true);

	//
	//Initialize 48 bit pseudo-random number generator:
	//
	Random randnum = new Random(); //system clock is seed

	//
	// To write to file:
	//			q.println("Text to write");
	//
	//To access next random double:
	//			randnum.nextDouble()


	//
	//variable declarations
	//
	int max=40000;
	int size=401;
	double PI = Math.PI;
	int mem_old[] = new int[2];
	mem_old[0]=0;
	mem_old[1]=0;
	
	double angle=0.0, rad=180.0;
	int i=0, j=0, x=0, y=0, dist=0, dir=0, step=0, trav=0, hit=0;
	int grid[][] = new int[size][size]; 

	for(i=0;i<size;i++)	//clear grid array
		{
		for(j=0;j<size;j++) grid[i][j]=0;
		}

	grid[200][200]=1;	//one particle in center
	
	for(i=0;i<max;i++) 	//choose starting point
		{
		hit=0;
		angle=(2.0*PI*randnum.nextDouble()); //random angle
		x=(200+(int)(rad*Math.cos(angle)));  //coordinates
		y=(200+(int)(rad*Math.sin(angle)));
		
		dist=gauss_ran(mem_old);   //random number gaussian dist.
		if(dist<0) step=-1; //move forwards or backwards
		else step=1;

		trav=0;
		while((hit==0)&&(x<399)&&(x>1)&&(y<399)&&(y>1)&&
			(trav<Math.abs(dist)))
			{
			if((grid[x+1][y]+grid[x-1][y]+grid[x][y+1]+
				grid[x][y-1])>=1)
				{
				hit=1;        //one neighbor occupied
				grid[x][y]=1; //particle sticks, walk over
				}
			
			//move horizontally
			else if(randnum.nextDouble()<0.5) x+=step; 
			
			//move vertically
			else y+=step;
			
			trav++;
			}
		}

	//print resulting grid
	for(i=0;i<size;i++)
	for(j=0;j<size;j++)
	if(grid[i][j]==1) q.println(i+" , "+j);

	System.out.println(" ");
	System.out.println("DLA Program Complete.");
	System.out.println("Data stored in DLA.DAT");
	System.out.println(" ");

}
//------------------------methods-----------------------------------------
//gauss_ran(mem_old) generates random numbers with gaussian distribution
// using the Box-Mueller method

public static int gauss_ran(int mem_old[])
	{
	Random randnum = new Random(); //System clock is seed

	double fac=0.0, rr=0.0, r1=0.0, r2=0.0;


	if(mem_old[1]==0)	//no random number left from the 
		{		//previous function call
		do
			{
			//choose random point in unit circle
			r1=2.0*randnum.nextDouble()-1.0;
			r2=2.0*randnum.nextDouble()-1.0;
			rr=r1*r1+r2*r2;
			}
		while((rr>=1)||(rr==0));
		
		fac=Math.sqrt(-2.0*Math.log(rr)/rr);
		mem_old[0]=(int)(5000.0*r1*fac); //save for next call
		mem_old[1]=1;         		  //set flag

		return((int)(5000.0*r2*fac));
		}
	
	else				 //return second number
		{			 // from last call

		mem_old[1]=0;			 //unset flag
		return mem_old[0];		 //return number from last call
		}
	
	}




}   // End of file