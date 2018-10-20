package unit2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.awt.*;
import java.text.DecimalFormat;

public interface SortTemplate {
    void sort(Comparable[] a);

    default boolean less(Comparable v , Comparable w) {
        return v.compareTo(w) < 0;
    }

    default void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    default void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.printf("%.2f ", a[i]);
        }
        System.out.println();
    }

    default boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

    default Comparable[] createIntArray(int maxSize, int area) {
        Comparable[] a = new Comparable[maxSize];
        for (int i = 0; i < a.length; i++) {
            a[i] = StdRandom.uniform(area);
        }
        return a;
    }

    default Comparable[] createDoubleArray(int maxSize, double low, double high) {
        Comparable[] a = new Comparable[maxSize];
        for (int i = 0; i < a.length; i++) {
            a[i] = StdRandom.uniform(low, high);
        }
        return a;
    }


    default void draw(Comparable[] a) {
        double x, y, rw, rh;
        int n = a.length;
        Comparable max = a[0];
        for (int i = 1; i < n; i++) {
            if (max.compareTo(a[i]) < 0) {
                max = a[i];
            }
        }
        StdDraw.setXscale(-1.0 / n, 1);
        if (a[0] instanceof Integer) {
            StdDraw.setYscale(0, (int) max);
        } else if (a[0] instanceof Double) {
            StdDraw.setYscale(0, (double) max);
        }
        StdDraw.setPenColor(StdDraw.BLACK);
        for (int i = 0; i < a.length; i++) {
            if (a[0] instanceof Integer) {
                y = (int) a[i] / 2.0;
                rh = (int) a[i] / 2.0;
            } else if (a[0] instanceof Double) {
                y = (double) a[i] / 2.0;
                rh = (double) a[i] / 2.0;
            } else {
                y = 0.0;
                rh = 0.0;
            }
            x = 1.0 * i / n;
            rw = 0.5 / n;
            StdDraw.filledRectangle(x, y, rw, rh);
        }
    }

    default void drawWithColor(Comparable[] a, Color color, int start, int end) {
        double x, y, rw, rh;
        int n = a.length;
        Comparable max = a[0];
        for (int i = 1; i < n; i++) {
            if (less(max, a[i])) {
                max = a[i];
            }
        }
        StdDraw.setXscale(-1.0 / n, 1);
        StdDraw.setYscale(0, (double) max);
        StdDraw.setPenColor(color);
        for (int i = start; i < end + 1; i++) {
            y = (double) a[i] / 2.0;
            rh = (double) a[i] / 2.0;
            x = 1.0 * i / n;
            rw = 0.5 / n;
            StdDraw.filledRectangle(x, y, rw, rh);
        }
    }
}
