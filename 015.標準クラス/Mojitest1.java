
import com.sun.xml.internal.ws.util.StringUtils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER
 */
public class Mojitest1 {
    public static void main(String[] args){
        String name = "たかはししゅうへい";
        System.out.println("私の文字数は　" 
                + name.length() + "　です");
        System.out.println("名前のバイト数は "
                + name.getBytes().length + "　です");
      
    }
}
