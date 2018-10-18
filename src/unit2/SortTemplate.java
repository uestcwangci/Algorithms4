package unit2;

import edu.princeton.cs.algs4.StdOut;

public interface SortTemplate {
    void sort(Comparable<Comparable>[] a);

    default boolean less(Comparable<Comparable> v , Comparable w) {
        return v.compareTo(w) < 0;
    }

    default void exch(Comparable<Comparable>[] a, int i, int j) {
        Comparable<Comparable> t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    default void show(Comparable<Comparable>[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        System.out.println();
    }

    default boolean isSorted(Comparable<Comparable>[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }
}
