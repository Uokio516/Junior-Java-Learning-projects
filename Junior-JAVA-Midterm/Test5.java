/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test5;

/**
 *
 * @author user
 */
import java.util.Scanner;

public class test5 {
    
    
    public static void main(String[] args) {
        
        double n;
        int a=1,factorial=1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("請輸入階層值M：");
        n = scanner.nextInt();
        
        while(factorial<n){
            a+=1;
            factorial*=a;
        }
        System.out.println(a);
        
    }
    
}
