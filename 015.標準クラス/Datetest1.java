/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Calendar;
import java.util.Date;
/**
 *
 * @author USER
 */



public class Datetest1 {
    public static void main(String[] args){
       Calendar c = Calendar.getInstance();
       Date date = new Date();
       c.set(2016,0,1,0,0,0);
       date = c.getTime();
       System.out.println(date.getTime());
       
    }
}
