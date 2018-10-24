package cc189.ch8;

import java.util.Stack;

/**
 * Created by xu_xt on 10/18/18.
 */
public class HanoiTowerGame {
    private Tower[] tower;
    private int numOfDisks;
    public HanoiTowerGame(int n) {
        this.numOfDisks  = n;
        tower = new Tower[3];
        for (int i = n; i > 0; i--) {
            tower[0].add(i);
        }
    }
    public void play() {
        tower[0].move(numOfDisks, tower[2], tower[1]);
    }

    public class Tower {
        private Stack<Integer> disks;
        private int numOfDisks = 0;
        public Tower(int n) {
            disks = new Stack<>();
        }
        public void add(int i) {
            if (!disks.isEmpty() && disks.peek() <= i) {
                System.out.println("Error placing disk " + i);
            } else {
                disks.push(i);
            }
        }
        public void moveTo(Tower t) {
            t.disks.add(disks.pop());
        }

        public void move(int n, Tower destination, Tower buffer) {
            if (n > 0) {
                move(n - 1, buffer, destination);
                moveTo(destination);
                buffer.move(n - 1, destination, this);
            }
        }
    }
}
