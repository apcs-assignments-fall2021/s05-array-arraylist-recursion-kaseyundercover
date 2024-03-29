import java.util.ArrayList;
import java.util.Arrays;

public class MyMain {
    // ********************
    // Examples From Class:
    // ********************

    // Use tail recursion to find the largest number in an array

    // Wrapper Method:
    public static int maxArray(int[] arr) {
        // Call tail recursive method, with i starting at 0
        return maxArrayTR(arr, 0, Integer.MIN_VALUE);
    }

    // Tail Recursive Method:
    public static int maxArrayTR(int[] arr, int i, int max) {
        // Base case
        if (i == arr.length) {
            return max;
        }
        // Recursive call
        else if (arr[i] > max) {
            return maxArrayTR(arr, i + 1, arr[i]);
        }
        else {
            return maxArrayTR(arr, i + 1, max);
        }
    }


    // **************************
    // In-class Practice Problems
    // **************************

    // Write a method that uses recursion to add up all the
    // values in an array

    // The tail recursive method is provided and wrapper method
    // is already set up for this problem

    // Examples:
    // sum([1, 2, 3, 4]) => 10
    // sum([4, 3, 2, 1]) => 10
    // sum([7, 3, 2, 8, 2, 3, 4]) => 29

    // Wrapper Method (Provided for you):
    public static int sum(int[] arr) {
        return sumTR(arr,0, 0);
    }

    // Tail Recursive Method:
    public static int sumTR(int[] arr, int i, int sum) {
        if (i == arr.length) {
            return sum;
        }
        else if (arr[i]<arr.length){
            return sumTR(arr, i+1, sum+arr[i]);
        }
        return sumTR(arr, i+1, sum+arr[i]);
    }




    // Write a method that uses recursion to search to see
    // if an **ArrayList** contains a given value x

    // The tail recursive method is provided and wrapper method
    // is already set up for this problem

    // Examples:
    // search([1, 2, 3, 4], 1) => true
    // search([1, 2, 3, 4], 7) => false
    // search([7, 3, 2, 8, 2, 3, 4], 3) => true

    // Wrapper Method (Provided for you):
    public static boolean search(ArrayList<Integer> list, int x) {return searchTR(list, x, 0);}

    // Tail Recursive Method:
    public static boolean searchTR(ArrayList<Integer> list, int x, int i) {
        if (i>=list.size()){
            return false;
        }
        if (list.get(i)==x){
            return true;
        }
        else if (i<list.size()){
            return searchTR(list, x,i+1);
        }

        return false;
    }


    // Write a method that uses recursion to check if every number
    // in an **array** is even
    // Examples:
    // allEven([1, 2, 3, 4]) => false
    // allEven([0, 2, 6, 4]) => true
    // allEven([7, 3, 2, 8, 2, 3, 4]) => false

    // Wrapper Method (Provided for you):
    public static boolean allEven(int[] arr) {return allEvenTR(arr, 0);}

    // Tail Recursive Method:
    public static boolean allEvenTR(int[] arr, int i) {
        if (i >= arr.length) {
            return true;
        }
        if (arr[i] % 2 == 0) {
            return allEvenTR(arr, i + 1);
        } else if (arr[i] % 2 != 0) {
            return false;
        } else {
            return true;
        }
    }


    // ********************
    // Examples From Class:
    // ********************
    public static void floodFill(char[][] mat, int row, int col) {
        // Check out of bounds, return
        if (row < 0 || col < 0 || row >= mat.length || col >= mat[0].length){
            return;
        }
        // If we're at wall, don't do anything
        else if (mat[row][col] == 'w') {
            return;
        }
        // If we've already visited there, let's return early
        else if (mat[row][col] == '*') {
            return;
        }
        else {
            // Leave "breadcrumbs"
            mat[row][col] = '*';

            // Visit our neighbors (left, up, right, down)
            floodFill(mat, row, col-1);
            floodFill(mat, row-1, col);
            floodFill(mat, row, col+1);
            floodFill(mat, row+1, col);
        }
    }



    // ********************
    // Methods for homework:
    // ********************

    // This recursive method checks if the array contains exactly
    // count copies of the integer x

    // Wrapper method
    public static boolean hasCountCopies(int[] arr, int x, int count) {return hasCountCopiesTR(arr, x, count, 0, 0);}

    // You may want a tail recursive method
    public static boolean hasCountCopiesTR(int[] arr, int x, int count, int i, int count2) {
        if (i >= arr.length) {
            if (count2 == count) {
                return true;
            } else {
                return false;
            }
        }
        if (arr[i] == x) {
            return hasCountCopiesTR(arr, x, count, i + 1, count2 + 1);
        }
        else{
            return hasCountCopiesTR(arr, x, count, i + 1, count2);
        }

    }










    // This recursive method checks if the array is sorted in
    // non-decreasing order

    // Wrapper method
    public static boolean isSorted(ArrayList<Integer> list) {
        return isSortedTR(list, 0);
    }

    public static boolean isSortedTR(ArrayList<Integer> list, int i) {
        if (i == list.size()-1) {
            return true;
        }
        if (list.get(i) <= list.get(i + 1)) {
            return isSortedTR(list, i + 1);
        } else {
            return false;
        }
    }




    // Modify the flood fill algorithm to write an algorithm that looks for
    // the finish line in a maze
    // We’ll consider a 2D char array, where the character 'w'
    // represents a wall, the space character ' ' represents an empty hallway,
    // and the 'f' represents the finish line
    // For example:
    //                                                        row coordinates:
    //  char[][] mat = { {'w', 'w', ' ', 'w', 'w', 'w'},      // 0
    //                   {'w', ' ', ' ', 'w', 'f', 'w'},      // 1
    //                   {'w', ' ', 'w', 'w', ' ', 'w'},      // 2
    //                   {'w', ' ', ' ', ' ', ' ', 'w'},      // 3
    //                   {'w', 'w', 'w', ' ', 'w', 'w'},      // 4
    //                   {'w', ' ', ' ', ' ', 'w', ' '},      // 5
    //                   {'w', 'w', 'w', 'w', 'w', ' '} };    // 6
    // col coordinates:    0    1    2    3    4    5

    // We'll be given some starting coordinates (row, col) of where we start
    // in the maze
    // Examples:
    // escape(mat, 0, 0) => false because (0, 0) is a wall
    // escape(mat, 0, 2) => true because we should be able to make it to f at (1, 4)
    // escape(mat, 5, 1) => true because we should be able to make it to f at (1, 4)
    // escape(mat, 6, 5) => false because we get stuck

    // No tail recursion necessary!
    public static boolean escape(char[][] mat, int row, int col) {
        if (row < 0 || col < 0 || row >= mat.length || col >= mat[0].length) {
            return false;
        } else if (mat[row][row] == 'w') {
            return false;
        } else if (mat[row][row] == '*') {
            return false;
        } else if (mat[row][row] == 'f') {
            return true;
        } else {
            mat[row][col] = '*';
            boolean b1 = escape(mat, row, col - 1);
            boolean b2 = escape(mat, row - 1, col - 1);
            boolean b3 = escape(mat, row, col + 1);
            boolean b4 = escape(mat, row + 1, col + 1);

            return (b1 || b2 || b3 || b4);
        }
    }




    public static void main(String[] args) {
        // Optional: Write some code here to test your methods!
//        System.out.println(sum(new int[]{1,2,3}));
//        System.out.println(sum(new int[]{12,11,6}));
//        System.out.println(hasCountCopies(new int[]{1,2,3}, 2, 1));
        System.out.println(hasCountCopies(new int[]{1}, 1, 1));
        System.out.println(hasCountCopies(new int[]{1}, 2, 1));



        // row coordinates:
        char[][] mat = {   {'w', 'w', ' ', 'w', 'w', 'w'},      // 0
                           {'w', ' ', ' ', 'w', 'f', 'w'},      // 1
                           {'w', ' ', 'w', 'w', ' ', 'w'},      // 2
                           {'w', ' ', ' ', ' ', ' ', 'w'},      // 3
                           {'w', 'w', 'w', ' ', 'w', 'w'},      // 4
                           {'w', ' ', ' ', ' ', 'w', ' '},      // 5
                           {'w', 'w', 'w', 'w', 'w', ' '} };    // 6
        // col coordinates:  0    1    2    3    4    5
        System.out.println(escape(mat, 5, 1));
    }
}
