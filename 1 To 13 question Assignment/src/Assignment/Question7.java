package Assignment;

/*
7. Create a Java program that implements a binary search algorithm. The program
should accept user input for the target value and search for it in a sorted array. The
program should return the index of the target value if found or a message if not
found.
*/

import java.util.Scanner;

public class Question7 {
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1; // Target value not found
    }

    public static void main(String[] args) {
        int[] sortedArray = {1, 4, 8, 12, 15, 18, 20, 24, 27, 30};
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the target value to search for: ");
        int target = scanner.nextInt();
        
        int index = binarySearch(sortedArray, target);
        
        if (index != -1) {
            System.out.println("Target value found at index " + index);
        } else {
            System.out.println("Target value not found in the array.");
        }
        
        scanner.close();
    }
}
