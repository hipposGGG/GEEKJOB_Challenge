/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER
 */
public class Mojitest3 {
    public static void main(String[] args){
        String word = "きょUはぴIえIちぴIのくみこみかんすUのがくしゅUをしてIます";
        
        String word2 = word.replace("I", "い");
        System.out.println(word2.replace("U", "う"));
    }
}
