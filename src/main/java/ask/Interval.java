package ask;

/**
 * Created by xu_xt on 3/28/19.
 */
public class Interval {
    int start, end;
    boolean val;
    Interval(int start, int end, boolean value) {
        this.start = start;
        this.end = end;
        this.val = value;
    }

    @Override
    public String toString() {
        return "Interval{" +
                "start=" + start +
                ", end=" + end +
                ", val=" + val +
                '}';
    }
}
