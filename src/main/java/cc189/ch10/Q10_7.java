package cc189.ch10;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by xu_xt on 10/24/18.
 */
public class Q10_7 {
    // There are 2^31 distinct non-negative integers which is about 2 billions. So 4 billions of integers contains duplicate
    // 1G of memory is 2^10 * 2^10 * 2^10 * 8 bits which is about 8 billions of bits
    // We could use bit set to store if a number shows up and return the number that has bit as 0
    public int missingInt(String file) throws FileNotFoundException {
        long size = Integer.MAX_VALUE + 1;
        int[] bits = new int[(int)(size/32)];
        Scanner scanner = new Scanner(new FileReader(file));
        while(scanner.hasNextInt()) {
            int num = scanner.nextInt();
            bits[num / 32] |= 1 << num % 32;
        }
        // find bit with 0
        for (int i = 0; i < bits.length; i++) {
            for (int j = 0; j < 32; j++) {
                boolean isEmpty = (bits[i] & 1 << j) == 0;
                if (isEmpty) {
                    return i * 32 + j;
                }
            }
        }
        return -1;
    }
    // follow up 1 billion non-negative integer with 10 M memory
    // break numbers into chunks with same size of range, count the numbers show up in each range (one integer for each range)
    // 10M = 10 * 2^10 * 2^10 bytes ~ 2^21 integers
    // number of distinct integers / range size <= 2^21 -> range size >= 2^10 and memory limit is 2^26 bits so range size <= 2^26
    public int findMissingNumberFollowUp(String fileName) throws FileNotFoundException {
        int rangeSize = 1<< 20;
        int arraySize = (int) (((long)Integer.MAX_VALUE + 1) / rangeSize);
        int[] counters = new int[arraySize];
        // read in file and count numbers group by range
        Scanner in = new Scanner(new FileReader(fileName));
        while (in.hasNextInt()) {
            int num = in.nextInt();
            counters[num / rangeSize]++;
        }
        in.close();
        // find the range that has less count than then range count
        int index = -1;
        for (int i = 0; i < arraySize; i++) {
            if (counters[i] < rangeSize) {
                index = i;
            }
        }
        if (index == - 1) {
            return -1;
        }
        // find out the miss number
        int startOfRange = rangeSize * index;
        return findMissingNumber(fileName, startOfRange, rangeSize);
    }
    private int findMissingNumber(String fileName, int startOfRange, int rangeSize) throws FileNotFoundException {
        int[] bits = new int[rangeSize / 32];
        Scanner in = new Scanner(new FileReader(fileName));
        while (in.hasNextInt()) {
            int num = in.nextInt();
            int diff = num - startOfRange;
            if (diff >= 0 && diff < rangeSize) {
                bits[diff / 32] |= 1 << diff % 32;
            }
        }
        in.close();
        for (int i = 0; i < bits.length; i++) {
            // not all zeros
            if (bits[i] != ~0) {
                for (int j = 0; j < 32; j++) {
                    if ((bits[i] & 1 << j) == 0) {
                        return startOfRange + 32 * i + j;
                    }
                }
            }
        }
        return -1;
    }

}
