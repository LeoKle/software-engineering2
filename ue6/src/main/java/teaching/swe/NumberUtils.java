package teaching.swe;

import java.util.List;

public class NumberUtils {
    public int sumPositive(List<Integer> numbers) {
        if (numbers == null) {
            return 0;
        }

        int sum = 0;
        for (Integer n : numbers) {
            if (n != null && n > 0) {
                sum += n;
            }
        }
        return sum;
    }
}
