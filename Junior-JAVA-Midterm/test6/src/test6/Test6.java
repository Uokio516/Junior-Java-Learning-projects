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
import java.util.stream.Collectors;
import java.util.Collections;

public class Test6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int Ans;
        Scanner sc=new Scanner(System.in);
        System.out.print("input:");
        String data = sc.next();
        String[] split = data.split(",");
        Arrays.sort(split);
        String min = Arrays.stream(split).collect(Collectors.joining());
        Arrays.sort(split, Collections.reverseOrder());
        String max = Arrays.stream(split).collect(Collectors.joining());
        System.out.println("max:"+max);
        System.out.println("min:"+min);
        System.out.print("Ans:");
        System.out.println(Integer.parseInt(max)-Integer.parseInt(min));
    }
    
}