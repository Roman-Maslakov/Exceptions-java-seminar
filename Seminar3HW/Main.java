package Seminar3HW;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Введите данные человека для создания карточки\n" +
                "Фамилия, имя, отчество, дата рождения, номер телефона и пол через пробел\n" +
                "дата рождения в формате dd.mm.yyyy, пол одной буквой (f, m)\n" +
                "Для выхода зажмите Ctrl + C");
        Scanner sc = new Scanner(System.in, "Cp866");
        while (sc.hasNextLine()) {
                ContactCard cc = new ContactCard();
                String data = sc.nextLine();
                cc.createCard(data);
        }
        sc.close();
    }
}