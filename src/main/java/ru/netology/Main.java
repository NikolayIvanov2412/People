package ru.netology;

public class Main {
    public static void main(String[] args) {
        // Создаем взрослого человека
        Person mom = new PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .setAge(31)
                .setAddress("Москва")
                .build();

        // Получаем полу-заполненного билдера для ребенка и создаем ребенка
        Person child = mom.newChildBuilder()
                .setName("Антон")
                .build();

        // Показываем созданный объект мамы и ребенка
        System.out.println(mom.toString());
        System.out.println(child.toString());

        // Проверка исключений при попытке построить неполноценного объекта
        try {
            new PersonBuilder().build(); // Не указано обязательных данных
        } catch (IllegalStateException e) {
            System.err.println(e.getMessage()); // Ожидаемое исключение
        }

        try {
            new PersonBuilder().setAge(-100).build(); // Некорректное значение возраста
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage()); // Ожидаемое исключение
        }
    }
}