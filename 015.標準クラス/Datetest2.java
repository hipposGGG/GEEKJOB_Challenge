
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Calendar;
/**
 *
 * @author USER
 */
public class Datetest2 {
    public static void main(String[] args) throws ParseException{
        Calendar c = Calendar.getInstance();
        Date now = new Date();
        c.set(1988,4,21,1,23,45);
        now = c.getTime();
        //System.out.println(c.getTime());//setされた日付

        // SimpleDateFormat作成
        SimpleDateFormat sdf =
            new SimpleDateFormat("yyyy年M月dd日 H時mm分ss秒");

        System.out.println(sdf.format(now));
    }
}
