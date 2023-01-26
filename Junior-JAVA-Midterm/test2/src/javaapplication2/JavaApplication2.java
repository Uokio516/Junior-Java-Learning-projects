/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

/**
 *
 * @author user
 */
import java.util.Scanner;
public class JavaApplication2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        float sum1,sum2;
        int i;
        Scanner scanner = new Scanner(System.in);
        i=scanner.nextInt();
        if ((int)i<=120)
        {
            //夏月
            sum1=i*2.1f;
            //非夏月
            sum2=i*2.1f;
            System.out.println("夏月的費用為："+sum1);
            System.out.println("非夏月的費用為："+sum2);
        }else if(i>=121 && i<=330){
            //夏月
            sum1=(i-120)*3.02f+120*2.1f;
            //非夏月
            sum2=(i-120)*2.68f+120*2.1f;
            System.out.println("夏月的費用為："+sum1);
            System.out.println("非夏月的費用為："+sum2);
        }else if(i>=331 && i<=500){
            //夏月
            sum1=(i-330)*4.39f+210*3.02f+120*2.1f;
            //非夏月
            sum2=(i-330)*3.61f+210*2.68f+120*2.1f;
            System.out.println("夏月的費用為："+sum1);
            System.out.println("非夏月的費用為："+sum2);
        }else if(i>=501 && i<=700){
            //夏月
            sum1=(i-500)*4.97f+170*4.39f+210*3.02f+120*2.1f;
            //非夏月
            sum2=(i-500)*4.01f+170*3.61f+210*2.68f+120*2.1f;
            System.out.println("夏月的費用為："+sum1);
            System.out.println("非夏月的費用為："+sum2);
        }else if(i>=701){
            //夏月
            sum1=(i-700)*5.63f+200*4.97f+170*4.39f+210*3.02f+120*2.1f;
            //非夏月
            sum2=(i-700)*4.50f+200*4.01f+170*3.61f+210*2.68f+120*2.1f;
            System.out.println("夏月的費用為："+sum1);
            System.out.println("非夏月的費用為："+sum2);
        }else {
            System.out.println("請輸入正確數值!!!");
        }
    }
    
}
