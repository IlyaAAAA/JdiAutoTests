package utils;

import entities.Person;

public final class PersonUtils {

    public static Person getPerson() {
        return new Person(
                "Илья",
                "Сачук",
                "Владивосток",
                "https://ok.ru/profile/512582147925"
        );
    }
}
