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
public class Human{
        public  String firstName = "";
        public  String lastName = "";
        
    public void setHuman(String n,String m){
        this.firstName = n;
        this.lastName = m;
    }
}
class tester {
    public static void main(String[] args){
        Human hito = new Human(); 
        hito.setHuman("高橋","周平");
        System.out.println(hito.firstName + " " + hito.lastName);
        Human hito2 = new Human(); 
        System.out.println(hito2.firstName + " " + hito2.lastName);
    }    
}

////Humanクラスの宣言
//class Human {
//    //フィールド宣言
//    public String name = "";
//    public int age = 0;
//    //メソッド宣言
//    public void setHuman(String n, int a){
//        //引数をフィールドへ設定
//        this.name = n;
//        this.age = a;
//        //結果を出力
//        System.out.println(n + a);
//    }   
//}
////
//public class tester {
//    public static void main(String[] args){
//        //Humanクラスのインスタンス生成
//        Human hito = new Human();
//        //人インスタンスのageフィールドへ年齢設定
//        hito.age = 40;
//        //人インスタンスのsetHumanメソッドを利用
//        hito.setHuman("添田亮司",34);
//    }
//}

