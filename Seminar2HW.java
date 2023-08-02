import java.util.Scanner;

public class Seminar2HW {

    // Реализуйте метод, который запрашивает у пользователя ввод дробного числа
    // (типа float), и возвращает введенное значение.
    // Ввод текста вместо числа не должно приводить к падению приложения, вместо
    // этого,
    // необходимо повторно запросить у пользователя ввод данных.
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        request(scanner);
        scanner.close();
    }

    public static void request(Scanner sc) {

        System.out.println("Введите дробное число)");
        String res = sc.nextLine();
        try {
            Float num = Float.parseFloat(res);
            if (num != num.intValue())
            System.out.println("Ваше число" + Float.parseFloat(res));
            else {
                System.out.println("Нето)");
                request(sc);
            }
        } catch (NumberFormatException e) {
            System.out.println("Нето)");
            request(sc);
        }
    }
}
