package ru.netology;

import java.util.OptionalInt;

class Person {
    private final String name;
    private final String surname;
    private Integer age; // Используем Nullable тип для возраста
    private String address;

    // Конструктор с именем и фамилией (возраст и адрес опциональны)
    public Person(PersonBuilder builder) {
        this.name = builder.name;
        this.surname = builder.surname;
        this.age = builder.age;
        this.address = builder.address;
    }

    // Метод проверки наличия возраста
    public boolean hasAge() {
        return age != null;
    }

    // Метод проверки наличия адреса
    public boolean hasAddress() {
        return address != null && !address.isEmpty();
    }

    // Методы геттеры для имени, фамилии, возраста и адреса
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        if (age == null) return OptionalInt.empty();
        else return OptionalInt.of(age);
    }

    public String getAddress() {
        return address;
    }

    // Установка нового адреса
    public void setAddress(String address) {
        this.address = address;
    }

    // Увеличиваем возраст на один год
    public void happyBirthday() {
        if (hasAge()) {
            age++;
        }
    }

    // Создание билдера для ребенка текущего человека
    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setSurname(surname)
                .setAddress(address); // Родительские фамилия и адрес автоматически ставятся ребенку
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + (hasAge() ? age : "unknown") +
                ", address='" + (hasAddress() ? address : "no address") + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return name.hashCode() * 37 + surname.hashCode();
    }
}