package cc189.ch10;

/**
 * Created by xu_xt on 10/24/18.
 */
// todo: revisit
// find the pivot point and search for the number O(logN) time where N is the length of the array
public class Q10_3 {
    public int searchRotatedArray(int[] a, int target) {
        if (a == null || a.length == 0) {
            return -1;
        }
        int l = 0, r = a.length - 1, pivot = -1;
        if (a[l] < a[r]) {
            pivot = 0;
        } else {
            pivot = findPivot(a, l, r);
        }
        if ( target < a[r]) {
            return binarySearch(a, pivot, r, target);
        } else if (target > a[r]) {
            return binarySearch(a, l, pivot - 1, target);
        } else {
            return r;
        }
    }
    private int findPivot(int[] a, int start, int end) {
        int l = start, r = end;
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (a[mid] > a[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        if (a[l] < a[r]) {
            return l;
        }
        return r;
    }
    private int binarySearch(int[] a, int start, int end, int target) {
        if (start > end) {
            return -1;
        }
        int l = start, r = end;
        while (l + 1 < end) {
            int mid = l + (r - l) / 2;
            if (target < a[mid]) {
                r = mid - 1;
            } else if (target > a[mid]) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        if (a[l] == target) {
            return l;
        }
        if (a[r] == target) {
            return r;
        }
        return -1;
    }

    //
    public int searchRotatedArrayOptimal(int[] a, int target) {
        if (a == null || a.length == 0) {
            return -1;
        }
        int l = 0, r = a.length - 1;
        return search(a, l, r, target);
    }
    private int search(int[] a, int start, int end, int target) {
        if (start > end) {
            return -1;
        }
        int l = start, r = end;
        int mid = l + (r - l) / 2;
        if (target == a[mid]) {
            return mid;
        }
        if (a[l] < a[mid]) { // increasing interval
            if (target < a[mid] && target >= a[l]) {
                return search(a, l,mid - 1, target);
            } else {
                return search(a, mid + 1, r, target);
            }
        } else if (a[l] > a[mid]){
            if (target > a[mid] && target < a[l]) {
                return search(a, mid + 1, r, target);
            } else {
                return search(a, l,mid - 1, target);
            }
        } else { // left half or right half are of the same value
            if (a[mid] != a[r]) { // left half are of same value, search on right
                return search(a, mid + 1, r, target);
            } else {
                int result = search(a, l, mid - 1, target);
                if (result != -1) {
                    return search(a, mid + 1, r,target);
                } else {
                    return result;
                }
            }
        }
    }
}

