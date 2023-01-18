public class PersonBuilder {
    private String name;
    private String surname;
    private int age;
    private String address;
    private boolean isName;
    private boolean isSurname;
    private boolean isAge;
    private boolean isAddress;

    protected Person build() {
        if (!isName || !isSurname) {
            throw new IllegalArgumentException("Не хватает обязательных полей");
        }

        if (!isAge && !isAddress) {
            return new Person(name, surname);
        } else if (!isAddress) {
            return new Person(name, surname, age);
        } else if (!isAge) {
            return new Person(name, surname, address);
        } else {
            return new Person(name, surname, age, address);
        }
    }

    protected PersonBuilder setName(String name) {
        this.name = name;
        isName = true;
        return this;
    }

    protected PersonBuilder setSurname(String surname) {
        this.surname = surname;
        isSurname = true;
        return this;
    }

    protected PersonBuilder setAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException(age + " - Возраст недопустимый");
        } else {
            this.age = age;
            isAge = true;
            return this;
        }
    }

    protected PersonBuilder setAddress(String address) {
        this.address = address;
        isAddress = true;
        return this;
    }
}