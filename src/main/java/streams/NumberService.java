package streams;

import java.util.List;

public interface NumberService {

    List<Integer> findPositives(List<Integer> integers);

    Integer findMax(List<Integer> integers);

    Integer findMin(List<Integer> integers);

    Integer findSum(List<Integer> integers);

    Double findAvg(List<Integer> integers);
}
