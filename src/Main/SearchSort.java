/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.*;

/**
 *
 * @author shz
 */
public class SearchSort {

    public static void main(String[] args) {
        boolean valid = false;
        Scanner input = new Scanner(System.in);
        int amount = 0;
        while (!valid) {
            try {
                System.out.print("Enter the amount of integers in array: ");
                amount = input.nextInt();
                valid = true;
            } catch (InputMismatchException ex) {
                System.out.println("Please Enter an integer!");
                //Clear pipe or buffer
                input.nextLine();
            }
        }
        int[] nums = new int[amount];
        Random rand = new Random();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = rand.nextInt(100);
        }
        System.out.println(Arrays.toString(nums));
        selectionSort(nums);
        System.out.println(Arrays.toString(nums));
        System.out.print("Enter an integer to look for: ");
        int target = input.nextInt();
        //create Stopwatch object
        Stopwatch sw = new Stopwatch();
        linearSearch(nums, target);
        sw.stop();
        //calculates the elapsed time
        long linearTime = sw.getElapsedTime();
        sw.start();
        int index = binarySearch(nums , target);
        sw.stop();
        long binaryTime = sw.getElapsedTime();
        //Display where target value location
        if (index < 0)
            System.out.println(target + " is not in the list.");
        else
            System.out.println(target + " is at index " + index);
        System.out.println("Linear: " + linearTime + "ms");
        System.out.println("Binary: " + binaryTime + "ms");
    }

    /**
     * Use binary search to find the key in the list
     */
    public static int binarySearch(int[] list, int key) {
        int low = 0;
        int high = list.length - 1;
        while (high >= low) {
            int mid = (low + high) / 2;
            if (key < list[mid]) {
                high = mid - 1;
            } else if (key == list[mid]) {
                return mid;
            } else {
                low = mid + 1;
            }
        }
        return - low - 1;
    }
    
    /**
     * Linear search of integer array
     * @param list  int array to be searched through
     * @param key   the target integer
     * @return      index of first target integer
     */
    public static int linearSearch(int[] list, int key) {
        for (int i = 0; i < list.length; i++) {
            if (list[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static void selectionSort(int[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            int currentMin = list[i];
            int currentMinIndex = i;

            for (int j = i + 1; j < list.length; j++) {
                if (list[j] < currentMin) {
                    currentMin = list[j];
                    currentMinIndex = j;
                }
            }
//            int temp = list[i];
//            list[i] = list[currentMinIndex];
//            list[currentMinIndex] = temp;
            if (currentMinIndex != i) {
                list[currentMinIndex] = list[i];
                list[i] = currentMin;
            }
        }
    }
}
