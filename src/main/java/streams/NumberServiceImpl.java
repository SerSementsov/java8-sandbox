package streams;

import java.util.List;
import java.util.stream.Collectors;

public class NumberServiceImpl implements NumberService {

    @Override
    public List<Integer> findPositives(List<Integer> integers) {
        return integers
                .stream()
                .filter(x -> x > 0)
                .collect(Collectors.toList());
    }

    @Override
    public Integer findMax(List<Integer> integers) {
        return integers
                .stream()
                .mapToInt(Integer::intValue)
                .max().orElseThrow(() -> new RuntimeException("Couldn't find max value in list = " + integers));
    }

    @Override
    public Integer findMin(List<Integer> integers) {
        return integers
                .stream()
                .mapToInt(Integer::intValue)
                .min().orElseThrow(() -> new RuntimeException("Couldn't find min value in list = " + integers));
    }

    @Override
    public Integer findSum(List<Integer> integers) {
        return integers
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    @Override
    public Double findAvg(List<Integer> integers) {
        return integers
                .stream()
                .mapToInt(Integer::intValue)
                .average().orElseThrow(() -> new RuntimeException("Couldn't calculate avg value in list = " + integers));
    }
}
