package unit2.example2_1;

import edu.princeton.cs.algs4.StdDraw;
import unit2.SortTemplate;

import java.util.Scanner;


public class Selection implements SortTemplate {
    public static void main(String[] args) {
        Integer[] a = {45, 13, 22, 84, 32, 67, 55, 1, 99};
        Selection debug = new Selection();
        Comparable[] b = debug.createDoubleArray(20, 1.0, 100.0);
//        debug.sort(a);
        debug.sort(b);
    }

    @Override
    public void sort(Comparable[] a) {
        int n = a.length;
        int min;
        Scanner sc = new Scanner(System.in);
        Comparable max = a[0];
        for (int i = 1; i < n; i++) {
            if (max.compareTo(a[i]) < 0) {
                max = a[i];
            }
        }
        StdDraw.setYscale(0, (double) max);
        for (int i = 0; i < n; i++) {
            min = i;
            drawWithColor(a, StdDraw.GRAY, 0, i - 1);
            for (int j = i + 1; j < n; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            drawWithColor(a, StdDraw.BLACK, i, n - 1);
            drawWithColor(a, StdDraw.RED, min, min);
            exch(a, i, min);
            sc.nextLine();
            StdDraw.clear();
        }
        show(a);
        draw(a);
    }

    public void sortWithGuard(Comparable[] a) {

    }
}
