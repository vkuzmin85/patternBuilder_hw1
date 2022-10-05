import java.util.OptionalInt;

public class PersonBuilder {
    private String name;
    private String surname;
    private OptionalInt age = OptionalInt.empty();
    private String currentCity;

    public PersonBuilder setName(String name) throws IllegalArgumentException {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("No name");
        } else {
            this.name = name;
        }
        return this;
    }

    public PersonBuilder setSurname(String surname) throws IllegalArgumentException {
        if (surname == null || surname.isEmpty()) {
            throw new IllegalArgumentException("No surname");
        } else {
            this.surname = surname;
        }
        return this;
    }

    public PersonBuilder setAge(int age) throws IllegalArgumentException {
        if (age >= 0) {
            this.age = OptionalInt.of(age);
        } else {
            throw new IllegalArgumentException("Incorrect age");
        }
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.currentCity = address;
        return this;
    }

    public Person build() throws IllegalStateException {
        Person person;
        if (name == null || name.isEmpty() || surname == null || surname.isEmpty()) {
            throw new IllegalStateException("No name or surname");
        } else if (age.isPresent()) {
            person = new Person(name, surname, age.getAsInt());
        } else {
            person = new Person(name, surname);
        }
        person.setAddress(currentCity);
        return person;
    }
}