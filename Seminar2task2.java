import java.util.Scanner;

public class Seminar2task2 {
    
    //Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку. 
    //Пользователю должно показаться сообщение, что пустые строки вводить нельзя.

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите что-нибудь");
        String res = sc.nextLine();
        sc.close();
        if (res.equals("")) throw new RuntimeException("Пустые строки вводить неЛьЗя!");
        System.out.println("ok");
    }
}
