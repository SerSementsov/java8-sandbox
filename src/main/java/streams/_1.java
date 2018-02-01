package streams;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

@Data
@AllArgsConstructor
class User {
    private long id;
    private String name;
}


public class _1 {

    private static AtomicLong atomicLong = new AtomicLong();

    public static void main(String[] args) {

        List<User> users = Stream.of("Mike", "John", "Kevin", "George", "Chris")
                .map(n -> new User(atomicLong.getAndIncrement(), n))
                .peek(System.out::println)
                .collect(toList());

        System.out.println("");


        Map<Long, String> idAndNameMap = users.stream()
                .collect(toMap(User::getId, User::getName));

        System.out.println(idAndNameMap);
    }
}
