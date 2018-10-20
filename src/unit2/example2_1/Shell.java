package unit2.example2_1;

import unit2.SortTemplate;

public class Shell implements SortTemplate {
    public static void main(String[] args) {
        Shell debug = new Shell();
        int n = 200;
        Comparable[] a = debug.createDoubleArray(n, 1.0, 1000.0);
        debug.sort(a);


    }


    @Override
    public void sort(Comparable[] a) {
        int n = a.length;
        int N = (n - 1) / 3;
        int[] h = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            h[i] = 3 * i + 1;
        }
        int index;
        for (int i = N; i >= 0; i--) {
            index = h[i];
            for (int j = index; j < n; j++) {
                for (int k = j; k >= index; k -= index) {
                    if (less(a[k], a[k - index])) {
                        exch(a, k, k - index);
                    }
                }
            }
        }
        show(a);
        draw(a);
    }
}
