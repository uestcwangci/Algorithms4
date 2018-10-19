package unit2.example2_1;

import unit2.SortTemplate;

public class Shell implements SortTemplate {
    public static void main(String[] args) {
        Shell debug = new Shell();
        Comparable[] a = debug.createIntArray(50, 1000);
    }


    @Override
    public void sort(Comparable[] a) {

    }
}
