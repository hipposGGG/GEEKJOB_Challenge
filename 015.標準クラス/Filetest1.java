/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
/**
 *
 * @author USER
 */
public class Filetest1 {
    public static void main(String[] args) throws IOException{
        File fp = new File("test.txt");
        
        FileWriter fw = new FileWriter(fp);
        fw.write("私の名前は高橋周平です");
        fw.close();
    }
    
}
