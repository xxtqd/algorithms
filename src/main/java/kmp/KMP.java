package kmp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by xxu on 5/9/2017.
 */
public class KMP {

    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        boolean exit = false;
        while (!exit){
            System.out.println("Enter a original string:");
            String original = keyboard.nextLine();
            System.out.println("String length: " + (original==null?0:original.length()));
            System.out.println("Enter a pattern string:");
            String pattern = keyboard.nextLine();
            int[] kmpTable = buildKMPTable(pattern);
            System.out.println("KMP table for pattern string: " + (kmpTable == null ? null : Arrays.toString(kmpTable)));
            // kmp
            int matchPos = -1;
            if(original != null && pattern != null && original.length() >= pattern.length()){
                matchPos = kmp(original, pattern);
            }
            if(matchPos > 0){
                System.out.println(String.format("Pattern string %s found at %d in original string %s", pattern, matchPos, original));
            }else {
                System.out.println(String.format("Pattern string %s is not found in original string %s", pattern, original));
            }
            System.out.println("Enter any character to continue, enter q to exit.");
            String cont = keyboard.nextLine();
            if("q".equalsIgnoreCase(cont)){
                exit = true;
            }
        }
    }

    /**
     * This method checks if a pattern string exists in a string and return the o-based position of the pattern string
     * if it does or return -1 if it doesn't
     * @param original the original string that we search on
     * @param pattern the pattern string that we search for in the original string
     * @return
     */
    private static int kmp(String original, String pattern){
        int[] table = buildKMPTable(pattern);
        if(table != null){
            int oPointer = 0;
            int pPointer = 0;
            while((original.length() - oPointer >= pattern.length() - (pPointer > 0 ? pPointer : 0))){
                if(pPointer == -1 || original.charAt(oPointer) == pattern.charAt(pPointer)){
                    if(pPointer == pattern.length()-1){
                        return oPointer-pattern.length()+1;
                    }
                    oPointer++;
                    pPointer++;
                }else {
                    pPointer = table[pPointer];
                }
            }
        }
        return -1;
    }

    /**
     * Given a string this method build an array of integer that represents the length of max prefix and proper suffix
     * if t[i] = 3 that means the 3 letters before position i matches the first 3 letters at the beginning of the string
     * @param str
     * @return
     */
    private static int[] buildKMPTable(String str){
        if(str == null){
            return null;
        }
        int[] table = new int[str.length()];
        table[0] = -1;
        table[1] = 0;
        int pos = 2;
        int cnd = 0;
        while (pos < str.length()){
            if(str.charAt(pos - 1) == str.charAt(cnd)){
                ++cnd;
                table[pos] = cnd;
                ++pos;
            }else if(cnd > 0){
                cnd = table[cnd];
            }else {
                table[pos] = 0;
                ++pos;
            }
        }
        return table;
    }
}
