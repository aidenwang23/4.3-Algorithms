import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Algorithms {
    private static File f;
    private static Scanner s;
    public static void main(String[] args) throws FileNotFoundException {
        f = new File("words.txt");
        int twoLetter = twoLetter();
        int tiedLongest = tiedLongest();
        int palindromes = palindromes();
        System.out.println("Two Letter Words: " + twoLetter);
        System.out.println("Words Tied for Longest: " + tiedLongest);
        System.out.println("Palindrome Words: " + palindromes);
        s.close();
    }

    public static int twoLetter() throws FileNotFoundException{
        s = new Scanner(f);
        int twoLetter = 0;
        while (s.hasNext()) {
            if (s.next().length() == 2)
                twoLetter++;
        }
        return twoLetter;
    }

    public static int tiedLongest() throws FileNotFoundException{
        s = new Scanner(f);
        int tiedLongest = 0;
        int length = 0;
        while (s.hasNext()) {
            String str = s.next();
            if (str.length() > length)
                length = str.length();
        }
        Scanner t = new Scanner(f);
        while(t.hasNext()){
            if(t.next().length() == length) { 
                tiedLongest++;
            }
        }
        t.close();
        return tiedLongest;
    }

    public static int palindromes() throws FileNotFoundException{
        s = new Scanner(f);
        int palindromes = 0;
        while (s.hasNext()) {
            String str = s.next();
            String front = "";
            String back = "";
            if(str.length() % 2 == 0) {
                front = str.substring(0,str.length()/2);
                for (int i = front.length(); i>0;i--) { 
                    back = back + front.substring(i-1,i);
                }
                if (str.indexOf(back) == str.length()/2) {
                    palindromes++;
                }
            }
            else {
                front = str.substring(0,(str.length()-1)/2);
                for (int i = front.length(); i>0;i--) { 
                    back = back + front.substring(i-1,i);
                }
                if (str.indexOf(back) == str.length()/2 + 1) {
                    palindromes++;
                }
            }
        }
        return palindromes;
    }
}