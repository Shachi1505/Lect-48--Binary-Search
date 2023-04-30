import java.util.*;

public class Prob2 {
    
    public static int LBound(int[] a, int target) {
        int low = 0, high = a.length - 1, ans = high;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] >= target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
    
    public static ArrayList<Integer> closest(int[] a, int k, int x) {
        int r = LBound(a, x);
        int l = r - 1;
        ArrayList<Integer> ans = new ArrayList<>();
        while (ans.size() != k) {
            if (r == a.length || (l >= 0 && Math.abs(a[l] - x) <= Math.abs(a[r] - x))) {
                ans.add(a[l--]);
            } else {
                ans.add(a[r++]);
            }
        }
        Collections.sort(ans);
        return ans;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter length of array");
        int n = sc.nextInt();
        int[] a = new int[n];
        System.out.println("Enter the elements of array");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println("Enter the number of elements");
        int k = sc.nextInt();
        System.out.println("Enter the value of target element");
        int x = sc.nextInt();
        ArrayList<Integer> ans = closest(a, k, x);
        for (int i = 0; i < k; i++) {
            System.out.print(ans.get(i) + " ");
        }
    }
}
