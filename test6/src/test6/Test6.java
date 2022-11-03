/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test6;

/**
 *
 * @author user
 */
import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;

public class Test6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.print("輸入值為：");
        String data = sc.next();
        String[] split = data.split(",");
        for (int i=0; i<split.length; i++)
            System.out.println(split[i]);
        Arrays.sort(split);
        max = int(split);
        
        
        
        
        
        
    }
    
}
