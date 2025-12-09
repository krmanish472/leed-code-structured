package LeetCode.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class FruitsIntoBasket {

    public static void main(String[] args) {
        int[] fruits = {1, 2, 1, 1, 3, 4, 2, 2, 2, 2, 4};

        int maxFruitCount = totalFruit(fruits);
        System.out.println(maxFruitCount); // => 6
    }

    public static int totalFruit(int[] fruits) {
        Map<Integer, Integer> basket = new HashMap<>();

        int maxFruit = 0;

        int startPtr = 0;
        for (int endPtr = 0; endPtr < fruits.length; endPtr++) {
            basket.put(fruits[endPtr], basket.getOrDefault(fruits[endPtr], 0) + 1);

            // if basket has more than 2 fruits type, start removing fruits
            while (basket.size() > 2) {
                int fruitCount = basket.get(fruits[startPtr]);
                if (fruitCount == 1) {
                    basket.remove(fruits[startPtr]);
                } else {
                    basket.put(fruits[startPtr], fruitCount - 1);
                }
                startPtr++;
            }

            maxFruit = Math.max(maxFruit, endPtr - startPtr + 1);
        }

        return maxFruit;
    }
}

