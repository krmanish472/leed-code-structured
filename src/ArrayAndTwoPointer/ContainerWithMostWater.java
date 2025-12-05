package ArrayAndTwoPointer;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(arr));
    }

    public static int maxArea(int[] height) {
        int maxArea = 0;

        int leftPtr = 0;
        int rightPtr = height.length - 1;

        while (leftPtr < rightPtr) {
            int w = rightPtr - leftPtr;
            int h = Math.min(height[leftPtr], height[rightPtr]);

            int currArea = w * h;
            maxArea = Math.max(maxArea, currArea);

            if (height[leftPtr] <= height[rightPtr]) {
                leftPtr++; // check if next left has more height
            } else {
                rightPtr--; // check if next right has more height
            }
        }

        return maxArea;
    }
}
