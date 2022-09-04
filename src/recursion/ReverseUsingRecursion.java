package recursion;

public class ReverseUsingRecursion {
    public static void main(String[] args) {
        int[] a = {12, 3, 4, 5, 3};
        int[] rev = new int[a.length];
        reverse(0, a, rev);

    }

    static void reverse(int i, int[] a, int[] rev) {
        if (i == a.length)
            return;
        rev[rev.length - 1 - i] = a[i];
        reverse(i + 1, a, rev);
    }
}
