package unit2.example2_1;

import edu.princeton.cs.algs4.StdRandom;
import unit2.SortTemplate;

public class Insertion implements SortTemplate {
    public static void main(String[] args) {
//        Integer[] a = {45, 13, 22, 84, 32, 67, 55, 1, 99};
        Insertion debug = new Insertion();
        Comparable[] a = debug.createIntArray(20, 1000);
        Comparable[] b = debug.createDoubleArray(20, 1.0, 100.0);
//        debug.sort(a);
//        debug.sort(b);
        debug.sortWithGuard(b);
    }

    @Override
    public void sort(Comparable[] a) {
        int n = a.length;
        int i, j;
        Comparable temp;
        for (i = 0; i < n - 1; i++) {
            temp = a[i + 1];
            for (j = i; j >= 0 && less(temp, a[j]); j--) {
                a[j + 1] = a[j];
            }
            a[j + 1] = temp;
        }
        show(a);
        draw(a);
    }

    public void sortWithGuard(Comparable[] a) {
        int n = a.length;
        Comparable[] b = new Comparable[n + 1];
        for (int l = 1; l < b.length; l++) {
            b[l] = a[l - 1];
        }
        n = b.length;
        int i, j;
        for (i = 2; i < n; i++) {
            b[0] = b[i];
            for (j = i - 1; less(b[0], b[j]); j--) {
                b[j + 1] = b[j];
            }
            b[j + 1] = b[0];
        }
        show(b);
    }
}
