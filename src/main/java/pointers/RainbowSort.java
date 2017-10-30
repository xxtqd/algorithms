package pointers;

/**
 * Created by xxu on 10/20/2017.
 */
public class RainbowSort {
    /*
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        if (colors == null || colors.length <= 1){
            return;
        }
        rainbowSort(colors, 0, colors.length - 1, 1, k);
    }

    private void rainbowSort(int[] colors, int start, int end, int colorFrom, int colorTo){
        if (start >= end){
            return;
        }
        if (colorFrom >= colorTo){
            return;
        }
        int colorMid = (colorFrom + colorTo) / 2;
        int left = start, right = end;
        while (left <= right){
            // include the colorMid in the first half
            while (left <= right && colors[left] <= colorMid){
                left++;
            }
            while (left <= right && colors[right] > colorMid){
                right--;
            }
            if (left <= right) {
                int temp = colors[left];
                colors[left] = colors[right];
                colors[right] = temp;
                left++;
                right--;
            }
        }
        rainbowSort(colors, start, right, colorFrom, colorMid);
        rainbowSort(colors, left, end, colorMid + 1, colorTo);
    }
    public static void main (String[] args){
        RainbowSort rainbowSort = new RainbowSort();
        int[] colors = new int[]{2,1,1,2,2};
        rainbowSort.rainbowSort(colors, 0, 4, 1, 2);
        for (int i = 0; i < colors.length; i++){
            System.out.println(colors[i]);
        }
    }
}
