package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class FruitsIntoBasket {

    public static void main(String[] args) {
        int[] fruits = {1, 2, 1, 1, 3, 4, 2, 2, 2, 2, 4};

        int maxFruitCount = totalFruit(fruits);
        System.out.println(maxFruitCount);
    }

    public static int totalFruit(int[] fruits) {
        Map<Integer, Integer> basket = new HashMap<>();

        int maxFruit = 0;

        int leftPtr = 0;
        for (int rightPtr = 0; rightPtr < fruits.length; rightPtr++) {
            basket.put(fruits[rightPtr], basket.getOrDefault(fruits[rightPtr], 0) + 1);

            // if basket has more than 2 fruits type, start removing fruits one-by-one, until...
            while (basket.size() > 2) {
                int fruitCount = basket.get(fruits[leftPtr]);
                // ... fruit count is 1 => then remove it
                if (fruitCount == 1) {
                    basket.remove(fruits[leftPtr]);
                } else {
                    basket.put(fruits[leftPtr], fruitCount - 1);
                }
                leftPtr++;
            }

            maxFruit = Math.max(maxFruit, rightPtr - leftPtr + 1);
        }

        return maxFruit;
    }
}

