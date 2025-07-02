
import java.util.*;

public class Complexity {

    // Bubble Sort - O(n^2)
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for(int i=0; i<n-1; i++) {
            for(int j=0; j<n-i-1; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    // Merge Sort - O(n log n)
    public static void mergeSort(int[] arr, int l, int r) {
        if(l < r) {
            int m = (l + r)/2;
            mergeSort(arr, l, m);
            mergeSort(arr, m+1, r);
            merge(arr, l, m, r);
        }
    }

    public static void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for(int i = 0; i < n1; i++)
            L[i] = arr[l + i];
        for(int j = 0; j < n2; j++)
            R[j] = arr[m + 1 + j];

        int i=0, j=0, k=l;
        while(i < n1 && j < n2) {
            if(L[i] <= R[j])
                arr[k++] = L[i++];
            else
                arr[k++] = R[j++];
        }

        while(i < n1) arr[k++] = L[i++];
        while(j < n2) arr[k++] = R[j++];
    }

    public static void main(String[] args) {
        System.out.println("🔍 Java Complexity Analyzer");
        System.out.printf("%-10s %-20s %-20s\n", "N", "BubbleSort (ms)", "MergeSort (ms)");

        for(int n = 1000; n <= 10000; n += 1000) {
            int[] arr1 = new Random().ints(n, 1, 10000).toArray();
            int[] arr2 = Arrays.copyOf(arr1, arr1.length);

            long start1 = System.currentTimeMillis();
            bubbleSort(arr1);
            long end1 = System.currentTimeMillis();

            long start2 = System.currentTimeMillis();
            mergeSort(arr2, 0, arr2.length - 1);
            long end2 = System.currentTimeMillis();

            System.out.printf("%-10d %-20d %-20d\n", n, (end1 - start1), (end2 - start2));
        }
    }
}


