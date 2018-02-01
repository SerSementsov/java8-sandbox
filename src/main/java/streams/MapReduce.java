package streams;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.text.ParseException;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapReduce {

    public static void main(String[] args) throws ParseException {
        List<Account> accounts = Stream.of("George", "John", "Chris", "Steve")
                .map(n -> new Account(new Random(42).nextDouble(), n))
                .collect(Collectors.toList());

        accounts.forEach(System.out::println);


        Double sum = accounts.stream()
                .map(Account::getBalance)
                .reduce(0.0, (x, y) -> x + y);

        System.out.println(sum);
    }
}

@Data
@AllArgsConstructor
class Account {

    public Account(double balance, String customer) {
        this.number = UUID.randomUUID().toString();
        this.balance = balance;
        this.customer = customer;
    }

    private String number;
    private double balance;
    private String customer;
}