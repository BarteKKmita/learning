package alghoritms.maxpairwise;

import java.util.List;

public class MaxPairwiseProduct {

    public long getMaxPairwiseProduct(List<Integer> numbers) {
        if (numbers.size() < 2) {
            throw new IllegalArgumentException("Number list is too short.");
        }
        int[] maxNumbers = {numbers.get(0), numbers.get(1)};

        for(int i = 2; i < numbers.size() - 1; i++) {
            if (maxNumbers[0] < numbers.get(i)) {
                maxNumbers[0] = numbers.get(i);
            } else if (maxNumbers[1] < numbers.get(i)) {
                maxNumbers[1] = numbers.get(i);
            }
        }
        return (long) maxNumbers[0] * (long) maxNumbers[1];
    }
}
