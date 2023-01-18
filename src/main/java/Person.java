import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.OptionalInt;

public class Person {

    private final String name;
    private final String surname;
    private OptionalInt age;
    private String address;

    protected Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.age = OptionalInt.empty();
    }

    protected Person(String name, String surname, int age) {
        this(name, surname);
        if (age <= 0) {
            throw new IllegalArgumentException(age + " - Возраст недопустимыйт");
        } else {
            this.age = OptionalInt.of(age);
        }
    }

    protected Person(String name, String surname, String address) {
        this(name, surname);
        this.address = address;
    }

    protected Person(String name, String surname, int age, String address) {
        this(name, surname, age);
        this.address = address;
    }

    protected void setAge(int age) {
        if (hasAge() == false) {
            this.age = OptionalInt.of(age);
        } else {
            System.out.println("Задать возраст нельзя, он уже известен");
        }
    }

    protected void setAddress(String address) {
        if (hasAddress() == false) {
            this.address = address;
        } else {
            System.out.println("Задать адрес нельзя, он уже известен");
        }
    }

    protected void happyBirthday() {
        if (hasAge() == true) {
            age = OptionalInt.of(age.getAsInt() + 1);
        } else {
            System.out.println("Сначала установите возраст");
        }
    }

    protected boolean hasAge() {
        if (age.isPresent() == false) {
            return false;
        } else {
            return true;
        }
    }

    protected boolean hasAddress() {
        if (address != null) {
            return true;
        }
        return false;
    }

    protected String getName() {
        return name;
    }

    protected String getSurname() {
        return surname;
    }

    protected int getAge() {
        try {
            return age.getAsInt();
        } catch (NoSuchElementException e) {
            return 0;
        }
    }

    protected String getAddress() {
        return address;
    }

    protected PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setSurname(surname)
                .setAge(1)
                .setAddress(address);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + getName() + '\'' +
                ", surname='" + getSurname() + '\'' +
                ", age=" + getAge() +
                ", address='" + getAddress() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(surname, person.surname) && Objects.equals(age, person.age) && Objects.equals(address, person.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, address);
    }
}