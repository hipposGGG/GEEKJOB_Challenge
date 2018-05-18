
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER
 */
public class Datetest3 {
    public static void main(String[] args){
       java.util.Calendar c = java.util.Calendar.getInstance();
       Date date = new Date();
       c.set(2016,10,4,10,0,0);
       date = c.getTime();
       System.out.println(date.getTime());
       
       SimpleDateFormat sdf =
            new SimpleDateFormat("yyyy-M-dd HH:mm:ss");
       System.out.println(sdf.format(date));
    }
}
