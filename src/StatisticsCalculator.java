import java.util.List;

public class StatisticsCalculator {

    private List<Integer> numbers;

    public StatisticsCalculator(List<Integer> numbers) {
        if(numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("The list of numbers cannot be null or empty");
        }
        this.numbers = numbers;
    }

    public int getMin() {
        return numbers.stream().min(Integer::compareTo).orElseThrow();
    }

    public int getMax() {
        return numbers.stream().max(Integer::compareTo).orElseThrow();
    }

    public int getCount() {
        return numbers.size();
    }

    public double getAverage() {
        return numbers.stream().mapToInt(Integer::intValue).average().orElseThrow();
    }
}
