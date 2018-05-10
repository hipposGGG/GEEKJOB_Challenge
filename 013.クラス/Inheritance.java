/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omg.java.shuzer;

/**
 *
 * @author USER
 */



public class Inheritance extends Human{
    public void Clear(){
//        Human.setHuman(" "," ");
        
        this.firstName = null;
        this.lastName = null;
//        System.out.println(Human.firstName + " " + Human.lastName);
//        String a = "講師の" + this.lastName + "です。講義を始めます";
//        System.out.print(a);

    }
}
class tester1 {
    public static void main(String[] args){
        Inheritance hito = new Inheritance(); 
        hito.setHuman("田中","太郎");
        System.out.println(hito.firstName + " " + hito.lastName);
        hito.Clear();
        System.out.println(hito.firstName + " " + hito.lastName);
//        Human hito2 = new Human(); 
//        System.out.println(hito2.firstName + " " + hito2.lastName);
    }    
}
