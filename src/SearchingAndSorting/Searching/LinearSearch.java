package SearchingAndSorting.Searching;

/*
 * O(n)
 * */
public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 4, 5, 7, 9, 11};
        int target = 9;

        if (linearSearch(arr, target) == -1) {
            System.out.println("Element not present");
        } else {
            System.out.println("Element present at " + linearSearch(arr, target) + " index");
        }
    }

    private static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (target == arr[i]) {
                return i;
            }
        }
        return -1;
    }
}
