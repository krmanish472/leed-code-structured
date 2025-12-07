package Stack;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {
    public static void main(String[] args) {
        int[] asteroids1 = {5,10,-5};
        int[] asteroids2 = {8, -8};
        int[] asteroids3 = {10, 2,-5};
        int[] asteroids4 = {3,5,-6,2,-1,4};

        int[] res1 = asteroidCollision(asteroids1);
        int[] res2 = asteroidCollision(asteroids2);
        int[] res3 = asteroidCollision(asteroids3);
        int[] res4 = asteroidCollision(asteroids4);

        System.out.println(Arrays.toString(res1));
        System.out.println(Arrays.toString(res2));
        System.out.println(Arrays.toString(res3));
        System.out.println(Arrays.toString(res4));
    }
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int currAsteroid : asteroids) {
            while (!stack.isEmpty() && currAsteroid < 0 && stack.peek() > 0) {
                if (Math.abs(currAsteroid) > stack.peek()) {
                    stack.pop();
                } else if (Math.abs(currAsteroid) < stack.peek()) {
                    currAsteroid = 0;
                    break;
                } else {
                    currAsteroid = 0; // make zero so that the -ve doesnot go in stack
                    stack.pop();
                    break;
                }
            }
            if (currAsteroid != 0) {
                stack.push(currAsteroid);
            }
        }

        int[] remaining = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            remaining[i] = stack.pop();
        }
        return remaining;
    }
}