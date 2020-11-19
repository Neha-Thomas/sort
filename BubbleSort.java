/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch13_sortingchallenge;

import java.util.stream.IntStream;

/**
 *
 * @author thoma
 */
public class BubbleSort {
     
    void bubbleSort(int[] arr) {
        int n = arr.length;
        IntStream.range(0, n - 1)
          .flatMap(i -> IntStream.range(1, n - i))
          .forEach(j -> {
              if (arr[j - 1] > arr[j]) {
                  int temp = arr[j];
                  arr[j] = arr[j - 1];
                  arr[j - 1] = temp;
              }
          });
    }

    void optimizedBubbleSort(int [] arr) {
        int i = 0, n = arr.length;

        boolean swapNeeded = true;
        while (i < n - 1 && swapNeeded) {
            swapNeeded = false;
            for (int j = 1; j < n - i; j++) {
                if (arr[j - 1] > arr[j]) {

                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                    swapNeeded = true;
                }
            }
            if (!swapNeeded)
                break;
            i++;
        }
    }
}
