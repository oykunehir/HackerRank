import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'designerPdfViewer' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY h
     *  2. STRING word
     */

    public static int designerPdfViewer(List<Integer> h, String word) {
    // Write your code here
    
    int maxLength = 0; //Holds the maximum length in "word"
    
    for(int i=0; i<word.length();i++){
        int currentChar = word.charAt(i); //Calculates the Ascii equivalent of char
        if(h.get(currentChar-97)>maxLength){
            maxLength = h.get(currentChar-97); 
            /*
            Ascii equivalent of 'a' is 97 
            If we subtract 97 from 'a' = 97 result will be 0 and this is the index of 'a' in h.
            */
        }
    }
    return (word.length()*maxLength);

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] hTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> h = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            int hItem = Integer.parseInt(hTemp[i]);
            h.add(hItem);
        }

        String word = bufferedReader.readLine();

        int result = Result.designerPdfViewer(h, word);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
