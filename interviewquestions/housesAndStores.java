// google
// given houses and stores array: find the closest street for a given house for each house
// you can also use imports, for example:
// import java.util.*;
import java.util.*;
// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int[] solution(int[] stores, int[] houses) {
        // write your code in Java SE 8
        Arrays.sort(stores);

        int min = stores[0];
        int max = stores[stores.length-1];

        Set<Integer> set = new HashSet<>();
        int[] results = new int[houses.length];
        int resultCounter = 0;

        for (Integer store: stores) {
            set.add(store);
        }
        for (Integer house: houses)  {
            if (set.contains(house)) {
                results[resultCounter++] = house;
                continue;
            }

            if (house < min) {
                results[resultCounter++] = min;
                continue;
            }

            if (house > max) {
                results[resultCounter++] = max;
                continue;
            }

            int lowerBound = storeNumber(house-1, set, min, max, house);
            int upperBound = storeNumber(house+1, set, min, max, house);

            if (Math.abs(lowerBound - house) > Math.abs(upperBound - house)) {
                results[resultCounter++] = upperBound;
            } else {
                results[resultCounter++] = lowerBound;
            }
        }

        return results;

    }
    public int storeNumber(int searchValue, Set<Integer> set,int min, int max, int house) {
        // check min and max
        if (searchValue == min) {
            return searchValue;
        }

        if (searchValue == max) {
            return searchValue;
        }

        if (set.contains(searchValue)) {
            return searchValue;
        }

        if (searchValue < house) {
            return storeNumber(searchValue-1, set, min, max, house);
        } else {
            return storeNumber(searchValue+1, set, min, max, house);
        }

    }
}
