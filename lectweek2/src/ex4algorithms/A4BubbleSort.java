package ex4algorithms;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/*
 *  Bubble sort. Simple to understand but inefficient sorting algorithm
 */
public class A4BubbleSort {

    public static void main(String[] args) {
        new A4BubbleSort().program();
    }

    void program() {
        int[] arr = {3, 4, 7, 6, 8, 1, 2, 9, 4, 6, 2};

        out.print("Array is");
        out.println(Arrays.toString(arr));

        bubbleSort(arr);

        out.print("Sorted array is");
        out.println(Arrays.toString(arr));
    }

    // ----------- Methods ---------------------------

    // Bubble sort (original changed)
    void bubbleSort(int[] arr) {
        // Loops are executed no matter what
        for (int i = 0; i < arr.length - 1; i++) {          // The repeat loop
            for (int j = 0; j < arr.length - 1 - i; j++) {  // The swap loop
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];     // Swap values
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

}
