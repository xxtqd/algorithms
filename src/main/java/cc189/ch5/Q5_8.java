package cc189.ch5;

import java.util.StringJoiner;

// based on the width calculate how many byte needed to reach row y
// on row y calculate how many bytes needed to reach x1 and x2
// flip bits between x1 and x2 to 1
public class Q5_8 {
    public void drawLine(byte[] screen, int width, int x1, int x2, int y) {
        if (screen == null || width == 0) {
            return;
        }
        int height = screen.length * 8 / width;
        if (y < 0 || y >= height) {
            return;
        }
        if (x1 < 0 || x1 >= width || x2 < 0 || x2 >= width) {
            return;
        }
        // swap if x1 > x2
        if (x1 > x2) {
            int temp = x1;
            x1 = x2;
            x2 = temp;
        }
        int start = (width * y + x1) / 8;
        int bitsOfTrailingOnes = 8 - x1 % 8;
        byte mask1 = (byte)((1 << bitsOfTrailingOnes) - 1);
        int end = (width * y + x2) / 8;
        int bitsOfLeadingOnes = x2 % 8 + 1; //fixme: x2 should be included
        byte mask2 = (byte) (0xFF << 8 - bitsOfLeadingOnes);
        screen[start] = mask1;
        int index = start + 1;
        while (index <= end) {
            screen[index++] = (byte)(1 << 8) - 1;
        }
        screen[end] = (byte)(screen[end] & mask2);
    }

    public static int computeByteNum(int width, int x, int y) {
        return (width * y + x) / 8;
    }

    public static void drawLineSolution(byte[] screen, int width, int x1, int x2, int y) {
        int start_offset = x1 % 8;
        int first_full_byte = x1 / 8;
        if (start_offset != 0) {
            first_full_byte++;
        }

        int end_offset = x2 % 8;
        int last_full_byte = x2 / 8;
        if (end_offset != 7) {
            last_full_byte--;
        }

        // Set full bytes
        for (int b = first_full_byte; b <= last_full_byte; b++) {
            screen[(width / 8) * y + b] = (byte) 0xFF;
        }

        byte start_mask = (byte) (0xFF >> start_offset);
        byte end_mask = (byte) ~(0xFF >> (end_offset + 1));

        // Set start and end of line
        if ((x1 / 8) == (x2 / 8)) { // If x1 and x2 are in the same byte
            byte mask = (byte) (start_mask & end_mask);
            screen[(width / 8) * y + (x1 / 8)] |= mask;
        } else {
            if (start_offset != 0) {
                int byte_number = (width / 8) * y + first_full_byte - 1;
                screen[byte_number] |= start_mask;
            }
            if (end_offset != 7) {
                int byte_number = (width / 8) * y + last_full_byte + 1;
                screen[byte_number] |= end_mask;
            }
        }
    }

    public static void printByte(byte b) {
        for (int i = 7; i >= 0; i--) {
            char c = ((b >> i) & 1) == 1 ? '1' : '_';
            System.out.print(c);
        }
    }

    public static void printScreen(byte[] screen, int width) {
        int height = screen.length * 8 / width;
        for (int r = 0; r < height; r++) {
            for (int c = 0; c < width; c+=8) {
                byte b = screen[computeByteNum(width, c, r)];
                printByte(b);
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        Q5_8 q = new Q5_8();
        int width = 8 * 5;
        int height = 3;
        for (int r = 0; r < height; r++) {
            for (int c1 = 0; c1 < width; c1++) {
                for (int c2 = c1; c2 < width; c2++) {
                    byte[] screen = new byte[width * height / 8];

                    System.out.println("row: " + r + ": " + c1 + " -> " + c2);
                    q.drawLine(screen, width, c1, c2, r);
                    printScreen(screen, width);
                    System.out.println();
                    screen = new byte[width * height / 8];

                    System.out.println("row: " + r + ": " + c1 + " -> " + c2);
                    q.drawLineSolution(screen, width, c1, c2, r);
                    printScreen(screen, width);
                    System.out.println("\n\n");
                }
            }
        }

    }
}