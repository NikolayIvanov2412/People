package ru.netology;

class PersonBuilder {
    String name;
    String surname;
    Integer age;
    String address;

    // Заполнение обязательными данными
    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    // Возможность установки возраста
    public PersonBuilder setAge(int age) {
        if (age < 0) throw new IllegalArgumentException("Возраст не может быть отрицательным");
        this.age = age;
        return this;
    }

    // Установка адреса проживания
    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    // Построение объекта Person
    public Person build() {
        if (name == null || surname == null) {
            throw new IllegalStateException("Обязательные поля Имя и Фамилия не указаны.");
        }

        return new Person(this);
    }
}