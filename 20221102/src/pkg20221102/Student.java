/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg20221102;

/**
 *
 * @author user
 */
public class Student {
    String name;
    int age;
    Student(){
        
    }
    Student(String name,int age){
        this.name=name;
        this.age=age;
    }
    
    @Override
    public String toString(){
        return (this.name+String.valueOf(age));
    }
    
}
