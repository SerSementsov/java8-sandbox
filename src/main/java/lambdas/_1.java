package lambdas;

import java.util.function.Consumer;
import java.util.stream.Stream;

public class _1 {

    public static void main(String[] args) {
        //before Java 8:
        Stream.of("1", "2", "3").forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        // since Java 8:
        Stream.of(" ", "4", "5", "6").forEach((String s) -> System.out.println(s));
        Stream.of(" ", "4", "5", "6").forEach(s -> System.out.println(s));

        Stream.of(" ", "7", "8", "9").forEach(System.out::println);
    }
}
