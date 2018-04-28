//Your name
//Your UIN
//CSCE 420
//Due: May 1, 2018
//hw4pr1.java

//1. (10 points) Write a program named hw4pr1.cpp, etc., to print the truth table
//for the FuzzyImplies function corresponding to FuzzyAnd(X,Y) = min(X,Y), for
//X and Y equal to 0, 0.25, .5, .75, and 1.  Hint: There are 25 lines in this
//truth table.

import java.lang.Math.*;

class hw4pr1{

	public static void main(String[] args){
		
		double[] x = {0, 0.25, 0.5, 0.75, 1};
		double[] y = {0, 0.25, 0.5, 0.75, 1};
		
		myFuzzyImplies(x,y);
	}
	
	//caluculates fuzzy implication with fuzzy not and min(x,y)
	public static void myFuzzyImplies(double[] x, double[] y){
		double out[][] = new double[x.length][y.length];
		
		//for every x value
		for(int i = 0; i < x.length; i++){
			//for every y value
			for(int j = 0; j < y.length; j++){
				
				//output = NOT(a AND NOT(b)) which is equivalent to a => b
				out[i][j] = myFuzzyNot( (myFuzzyMin(x[i], myFuzzyNot(y[j])) ) );
			}
		}
		//prints output
		printArr(x, y, out);
	}
	
	//calculates min of x and y; equivalent to FuzzyAnd(x,y)
	private static double myFuzzyMin(double x, double y){
		double out = -1;
			
		out = Math.min(x,y);
		
		return out;
	}
	
	//negation in fuzzy logic
	private static double myFuzzyNot(double x){
		double out = -1;
			
		out = 1 - x;

		return out;
	}
	
	//prints matrix
	private static void printArr(double[] x, double[] y, double[][] out){
		
		//prints out pretty heading
		System.out.println("\n  ~~~ Fuzzy Implies Truth Table ~~~ \n");
		System.out.println("\t  X  |   Y  | OUTPUT");
		
		//for every combination of X and Y, print out the implication value
		for(int i = 0; i < out.length; i++){
			for(int j = 0; j < out[0].length; j++){
				System.out.println("\t---------------------");
				System.out.printf("\t%.2f | ", x[i]);
				System.out.printf("%.2f | ", y[j]);
				System.out.printf("%.4f", out[i][j]);
				System.out.println("");
			}
		}
		System.out.println("");
	}
	
}

