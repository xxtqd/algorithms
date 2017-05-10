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
