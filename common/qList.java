package common;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class qList {
    public static void getQList(String key){
        try {
            BufferedReader r;
            switch(key){
                case "math":
                    r = new BufferedReader( new FileReader("C:\\Users\\RISHIsquad\\Desktop\\DSA23\\common\\math.txt"));
                    break;
                case "hash":
                    r = new BufferedReader( new FileReader("C:\\Users\\RISHIsquad\\Desktop\\DSA23\\common\\hash.txt"));
                    break;
                case "convert":
                    r = new BufferedReader( new FileReader("C:\\Users\\RISHIsquad\\Desktop\\DSA23\\common\\convert.txt"));
                    break;
                case "trie":
                    r = new BufferedReader( new FileReader("C:\\Users\\RISHIsquad\\Desktop\\DSA23\\common\\trie.txt"));
                    break;
                case "twopointer":
                    r = new BufferedReader( new FileReader("C:\\Users\\RISHIsquad\\Desktop\\DSA23\\common\\twopointer.txt"));
                    break;
                case "string":
                    r = new BufferedReader( new FileReader("C:\\Users\\RISHIsquad\\Desktop\\DSA23\\common\\string.txt"));
                    break;
                case "binarysearch":
                    r = new BufferedReader( new FileReader("C:\\Users\\RISHIsquad\\Desktop\\DSA23\\common\\binarysearch.txt"));
                    break;
                default:
                    r = new BufferedReader( new FileReader( "./math.txt" ));
            }
            String line = null;
            while ((line = r.readLine()) != null) {
                System.out.println("\t"+line);
            }
            r.close();
        } catch (FileNotFoundException e) {
            e.getStackTrace();} 
            catch (IOException e) {
                e.getStackTrace();}
    }
}