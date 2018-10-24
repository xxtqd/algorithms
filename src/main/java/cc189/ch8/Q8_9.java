package cc189.ch8;

import java.util.*;

/**
 * Created by xu_xt on 10/19/18.
 */
public class Q8_9 {
    public Set<String> validParens(int n) {
        if (n == 0) {
            Set<String> set = new HashSet<>();
            set.add("");
            return  set;
        }
        Set<String> set = validParens(n - 1);
        Set<String> result = new HashSet<>();
        for (String s : set) {
            result.add("(" + s + ")");
            result.add("()" + s);
            result.add(s + "()");
        }
        return result;
    }

    public List<String> validParensImproved(int n) {
        List<String> result = new ArrayList<>();
        buildParens(result, n, n, new StringBuilder());
        return result;
    }

    private void buildParens(List<String> result, int leftRemained, int rightRemained, StringBuilder sb) {
        if (leftRemained == 0 && rightRemained == 0) {
            result.add(sb.toString());
            return;
        }
        // as long as we have not used up all left parentheses we can always add a left parentheses
        if(leftRemained > 0) {
            sb.append("(");
            buildParens(result, leftRemained - 1, rightRemained, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        // as long as there are more left parentheses than right we can add a right (less left remained)
        if (leftRemained < rightRemained) {
            sb.append(")");
            buildParens(result, leftRemained, rightRemained - 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        Q8_9 q = new Q8_9();
        Set<String> set = q.validParens(3);
        List<String> list = q.validParensImproved(3);
        for (String s : set) {
            System.out.print(s + ", ");
        }
        System.out.println();
        for (String s : list) {
            System.out.print(s + ", ");
        }
    }
}
