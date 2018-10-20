package unit2.example2_3;

import unit2.SortTemplate;


public class Quick implements SortTemplate {
    public static void main(String[] args) {
        Quick debug = new Quick();
        Comparable[] a = debug.createDoubleArray(20, 1.0, 100.0);

    }

    @Override
    public void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private void sort(Comparable[] a, int low, int high) {
        if (high <= low) {
            return;
        }
        int mid = partition(a, low, high);
        sort(a, low, mid - 1);
        sort(a, mid + 1, high);
    }

    private int partition(Comparable[] a, int low, int high) {
        Comparable temp;
        int i = low;
        int j = high;
        return 0;
    }

}
