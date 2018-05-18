import java.util.Calendar;
import java.text.ParseException;
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
public class Datetest4 {
    public static void main(String[] args) throws ParseException{
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        
        Date now1 = new Date();
        c1.set(2015,0,1,0,0,0);
        now1 = c1.getTime();
        
        Date now2 = new Date();
        c2.set(2015,11,31,23,59,59);
        now2 = c2.getTime();
        
        int hiki = (int) (now2.getTime() - now1.getTime());

        System.out.println("差は"+hiki+"秒です");


        // SimpleDateFormat作成
//        SimpleDateFormat sdf =
//            new SimpleDateFormat("yyyy年M月dd日 H時mm分ss秒");
//
//        System.out.println(sdf.format(now1));
//        System.out.println(sdf.format(now2));
    }
}
