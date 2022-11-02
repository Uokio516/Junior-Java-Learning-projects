/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

/**
 *
 * @author user
 */
import java.util.Scanner;
public class JavaApplication4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double a,b;
        Scanner scanner = new Scanner(System.in);
        System.out.println("請輸入X軸座標：");
        a=scanner.nextInt();
        System.out.println("請輸入Y軸座標：");
        b=scanner.nextInt();
        if(a==b && a==0)
        {
            System.out.println("該點位於原點");
        }else if(a>0 && b>0)
        {
            double distance = a*a+b*b;
            System.out.println("該點位於第一象限，離原點距離為根號"+distance);
        }else if(a<0 && b>0)
        {
            double distance = a*a+b*b;
            System.out.println("該點位於第二象限，離原點距離為根號"+distance);
        }else if(a<0 && b<0)
        {
            double distance = a*a+b*b;
            System.out.println("該點位於第三象限，離原點距離為根號"+distance);
        }else if(a>0 && b<0)
        {
            double distance = a*a+b*b;
            System.out.println("該點位於第四象限，離原點距離為根號"+distance);
        }else if(a==0 && b>0)
        {
            double distance = a*a+b*b;
            System.out.println("該點位於Y軸上，離原點距離為根號"+distance);
        }else if(a!=0 && b==0)
        {
            double distance = a*a+b*b;
            System.out.println("該點位於X軸上，離原點距離為根號"+distance);
        }
    }
    
}
