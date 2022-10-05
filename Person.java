import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected String currentCity;
    protected OptionalInt age = OptionalInt.empty();

    public boolean hasAge() {
        return age.isPresent();
    }

    public boolean hasAddress() {
        return currentCity != null;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return age;
    }

    public String getAddress() {
        return currentCity;
    }

    public void setAddress(String address) {
        this.currentCity = address;
    }

    public void happyBirthday() {
        if (hasAge()) {
            age = OptionalInt.of(getAge().getAsInt() + 1);
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s (Age:%s Address:%s)",
                name,
                surname,
                (age.isPresent() ? age.getAsInt() : "unknown"),
                currentCity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = OptionalInt.of(age);
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder().setSurname(surname).setAddress(currentCity);
    }
}