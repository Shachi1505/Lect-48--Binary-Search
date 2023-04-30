import java.util.*;
import java.util.Scanner;

public class Main {
    public static boolean Search(int st, int end, int n){
        if(st>end)
    return false;
    int mid = st + (end-st/2);
    if(mid*mid == n)
    return true;
    if(mid*mid > n) {
       return Search(st, mid-1, n);
    } else{
        return Search(mid+1, end, n);
    }
}
    public static boolean Sum(int c){
        for(int a =0; a*a <= c; a++){
            int  b = c - (int)(a*a);
            if  (Search(0,b,b))
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        System.out.print((Sum(c) ? "yes\n" : "no\n"));
}
}
