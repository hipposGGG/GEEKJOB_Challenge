/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.FileWriter;
import java.io.BufferedWriter;
/**
 *
 * @author USER
 */
public class Filetest3 {
    public static void main(String[] args) throws IOException{
        //ファイルのインスタンス
        File fp = new File ("test.txt");
        FileWriter fw = new FileWriter(fp);
        BufferedWriter bw = new BufferedWriter(fw);
        
        //期日のインスタンス
        Date d = new Date(); 
        SimpleDateFormat sdf =
            new SimpleDateFormat("yyyy/MM/dd HH:mm");
        
        fw.write("文字列最後尾の削除処理\n");
        
        System.out.println("");
        fw.write("削除処理前はこちらになります\n");
        bw.newLine();
        String name = "たかはししゅうへい３";
        
        System.out.println(name);
        fw.write(name + "\n");   //名前の記入
        fw.write(sdf.format(d) + " 開始\n");  //処理開始時刻
        fw.close();
        
        
        
        System.out.println("");
        
        
        
        FileWriter fw2 = new FileWriter(fp,true);
        fw2.write("削除処理を完了しました\n");
        System.out.println(name.substring(0, name.length()-1));
        fw2.write(name.substring(0, name.length()-1)+ "\n");
        fw2.write(sdf.format(d) + " 終了\n");
        fw2.close();
        

    }
}
