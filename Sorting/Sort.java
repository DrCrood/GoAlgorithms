package Sorting;

import java.util.Arrays;

public class Sort {

    public static void main(String[] args) {
        int[] A = new int[]{1, 10, 2, 7, 3, 8, 9, 99, 100, 4, 5, 6, 11, 12};
        Heapsort.Sort(A);

        String[] sarr = Arrays.stream(A).mapToObj(String::valueOf).toArray(String[]::new);
        String result = String.join(" ", sarr);
        System.out.println(result);
    }
}