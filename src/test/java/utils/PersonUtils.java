package utils;

import entities.Person;

public final class PersonUtils {

    public static Person getPerson() {
        return new Person(
                "����",
                "�����",
                "�����������",
                "https://ok.ru/profile/512582147925"
        );
    }

    public static Person getPersonForBlackList() {
        return new Person(
                "����������",
                "�������",
                "�������",
                "https://ok.ru/profile/445727934019"
        );
    }
}
