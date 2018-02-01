package streams;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class _2 {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<Person>() {
            {
                add(new Person(42));
                add(new Person(41));
                add(new Person(40));
                add(new Person(43));
            }
        };

        Optional<Person> person = findOldest(people);
        person.ifPresent(System.out::println);
    }

    public static <T extends Comparable<T>> Optional<T> findOldest(Collection<T> values) {
        return values.stream()
                .reduce((a, b) -> a.compareTo(b) > 0 ? a : b);
    }

    public static class Person implements Comparable<Person> {
        private int age;

        public Person(int age) {
            this.age = age;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public int compareTo(Person other) {
            if (other == null) return -1;
            return this.age - other.age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "age=" + age +
                    '}';
        }
    }
}
