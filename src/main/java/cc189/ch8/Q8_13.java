package cc189.ch8;

import java.util.*;

/**
 * Created by xu_xt on 10/19/18.
 */
public class Q8_13 {
    private int maxHeight;
    public int getHeight(Box[] box) {
        Arrays.sort(box);
        int n = box.length;
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = box[i].h;
        }
        for (int i = n - 1; i >=0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (box[j].w < box[i].w && box[j].h < box[i].h && box[j].d < box[i].d) {
                    height[j] = Math.max(height[j], height[i] + box[j].h);
                }
            }
            maxHeight = Math.max(maxHeight, height[i]);
        }
        return maxHeight;
    }

    private class Box implements Comparable<Box>{
        int w, h, d;
        Box(int w, int h, int d) {
            this.w = w;
            this.h = h;
            this.d = d;
        }
        public int compareTo(Box b) {
            if (this.w == b.w) {
                if (this.h == b.h) {
                    return this.d - b.d;
                }
                return this.h - b.h;
            }
            return this.w - b.w;
        }

        public boolean canBeUnder(Box b) {
            if (w > b.w && h > b.h && d > b.d) {
                return true;
            }
            return false;
        }

        public boolean canBeAbove(Box b) {
            if (b == null) {
                return true;
            }
            if (w < b.w && h < b.h && d < b.d) {
                return true;
            }
            return false;
        }

        public String toString() {
            return "Box(" + w + "," + h + "," + d + ")";
        }
    }

    public class BoxComparator implements Comparator<Box> {
        @Override
        public int compare(Box x, Box y){
            return y.h - x.h;
        }
    }

    public Box createRandomBox() {
        Random r = new Random();
        return new Box(r.nextInt(100), r.nextInt(100), r.nextInt(100));
    }

    public int createStack(ArrayList<Box> boxes) {
        Collections.sort(boxes, new BoxComparator());
        int[] stackMap = new int[boxes.size()];
        return createStack(boxes, null, 0, stackMap);
    }

    public static int createStack(ArrayList<Box> boxes, Box bottom, int offset, int[] stackMap) {
        if (offset >= boxes.size()) {
            return 0;
        }

		/* height with this bottom */
        Box newBottom = boxes.get(offset);
        int heightWithBottom = 0;
        if (bottom == null || newBottom.canBeAbove(bottom)) {
            if (stackMap[offset] == 0) {
                stackMap[offset] = createStack(boxes, newBottom, offset + 1, stackMap);
                stackMap[offset] += newBottom.h;
            }
            heightWithBottom = stackMap[offset];
        }

		/* without this bottom */
        int heightWithoutBottom = createStack(boxes, bottom, offset + 1, stackMap);

        return Math.max(heightWithBottom, heightWithoutBottom);
    }

    public static void main(String[] args) {
        Q8_13 q = new Q8_13();
        Box[] boxes1 = new Box[200];
        ArrayList<Box> boxes2 = new ArrayList<Box>();
        for (int i = 0; i < 200; i++) {
            Box b = q.createRandomBox();
            boxes1[i] = b;
            boxes2.add(b);
        }

        int height1 = q.getHeight(boxes1);
        int height2 = q.createStack(boxes2);
        System.out.println(height1 + ", " + height2);
    }
}
