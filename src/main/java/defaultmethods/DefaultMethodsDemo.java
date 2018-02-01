package defaultmethods;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class DefaultMethodsDemo {
    public static void main(String[] args) {
        System.out.println(new Person("Rick", 42).debug());
        System.out.println(new SuperPerson("John", 33, "invisible").debug());
    }
}


class Person implements Debuggable {

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private String name;
    private int age;
}

class SuperPerson extends Person {

    private String superpower;

    public SuperPerson(String name, int age, String superpower) {
        super(name, age);
        this.superpower = superpower;
    }
}

interface Debuggable {
    default String debug() {
        StringBuilder sb = new StringBuilder(this.getClass().getSimpleName()).append("[ ");

        List<Field> fields = new ArrayList<>();
        getAllFields(fields, this.getClass());

        fields.forEach(field -> {
            field.setAccessible(true);
            try {
                sb.append(field.getName())
                        .append(" = ")
                        .append(field.get(this))
                        .append("; ");
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        });

        sb.append("]");
        return sb.toString();
    }

    default void getAllFields(List<Field> allFields, Class<?> clazz) {
        allFields.addAll(asList(clazz.getDeclaredFields()));

        if (clazz.getSuperclass() != null) {
            getAllFields(allFields, clazz.getSuperclass());
        }
    }

}
