import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {
    public static  ArrayList<String> read(){
        ArrayList <String> words = new ArrayList<String>();
         try {
            File myFile = new File("WordsToLearn.txt") ;
            Scanner myReader = new Scanner(myFile) ;
            while(myReader.hasNextLine()){
                String data = myReader.nextLine();
                
                words.add(data) ;
            }
            myReader.close();
        } catch (Exception e) {
            e.printStackTrace();
            
        }
        return words ;
    }

   
    
}
