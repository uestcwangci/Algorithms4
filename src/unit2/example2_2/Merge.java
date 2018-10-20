package unit2.example2_2;

import edu.princeton.cs.algs4.StdDraw;
import unit2.SortTemplate;

import java.util.Scanner;

public class Merge implements SortTemplate {
    private static Comparable[] aux;

    public static void main(String[] args) {
        Merge merge = new Merge();
        Comparable[] a = merge.createDoubleArray(20, 1.0, 100.0);
//        merge.sort(a);
        merge.sortB2U(a);
    }

    @Override
    public void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
        show(a);
        draw(a);
    }

    private void sort(Comparable[] a, int low, int high) {
        Scanner sc = new Scanner(System.in);
        if (high <= low) return;
//        int mid = (low + high) / 2;
        int mid = low + (high -low) / 2;
        sort(a, low, mid);
        sort(a, mid + 1, high);
        merge(a, low, mid, high);
    }

    public void sortB2U(Comparable[] a) {
        int N = a.length;
        aux = new Comparable[N];
        for (int sz = 1; sz < N; sz *= 2 ) {
            for (int low = 0; low < N - sz; low += sz * 2) {
                merge(a, low, low + sz - 1, Math.min(low + sz + sz - 1, N - 1));
            }
        }
        show(a);
        draw(a);
    }

    private void merge(Comparable[] a, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        for (int k = low; k <= high; k++) {
            aux[k] = a[k];
        }
        for (int k = low; k <= high; k++) {
            if (i > mid)                     a[k] = aux[j++];//后一个数组还有剩余
            else if (j > high)               a[k] = aux[i++];//前一个数组还有剩余
            else if (less(aux[j], aux[i]))   a[k] = aux[j++];//把小的赋值到临时数组里
            else                             a[k] = aux[i++];
        }
    }






}
