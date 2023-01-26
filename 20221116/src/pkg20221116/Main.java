/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg20221116;


/**
 *
 * @author user
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int plantNum = 5;
        hanoitower(plantNum,'A','B','C');
    }
    private static int fib1(int n) {
	int theLastTwo = 0, theLastNum = 1, temp; 
		
        if (n == 0) 
            return theLastTwo; 
        
        for (int index = 2; index <= n; index++) { 
            temp = theLastTwo + theLastNum;
            theLastTwo = theLastNum;
            theLastNum = temp;
        }
        
        System.out.println("the Last Two " + theLastTwo);
        System.out.println("the Last Number " + theLastNum);
        return theLastNum; 
	}
    public class FibonacciEx1 {
	static private int fib(int n) {
		if (n <= 1)
                    return n;
		return fib(n - 1) + fib(n - 2);
	}
	public static void main(String[] args) {
		System.out.println(fib(5));
	}
    }
    static void hanoitower(int n,char a,char b,char c){
            if(n==1){
                System.out.println("move"+n+":" +"from " + a +" to "+ c);
            }
            else{
                hanoitower(n-1,a,c,b);
                System.out.println("move"+n+":" +"from " + a +" to "+ c);
                hanoitower(n-1,b,a,c);
            }

    }
}
