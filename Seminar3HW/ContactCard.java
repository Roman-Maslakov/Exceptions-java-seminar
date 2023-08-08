package Seminar3HW;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ContactCard {

    String lastName;
    String firstName;
    String surname;
    String birthday;
    long phone;
    Character sex;

    public void createCard(String data) {

        parseData(data);
        checkData();
        try {
            writeCard(this.lastName, data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void parseData(String dataString) {

        String[] data = dataString.split(" ");
        if (data.length < 6)
            throw new LackOfDataInputException();
        else if (data.length > 6)
            throw new OverDataInputException();

        for (String s : data) {
            try {
                this.phone = Long.parseLong(s);
                continue;
            } catch (NumberFormatException e) {

            }
            if (s.length() == 1) {
                this.sex = s.charAt(0);
                continue;
            }
            if (s.split("\\.").length == 3) {
                this.birthday = s;
                continue;
            }
            if (s.replace(".", "") == s && s.length() != 1 && this.lastName == null) {
                this.lastName = s;
                continue;
            }
            if (s.replace(".", "") == s && s.length() != 1 && this.firstName == null) {
                this.firstName = s;
                continue;
            }
            if (s.replace(".", "") == s && s.length() != 1 && this.surname == null) {
                this.surname = s;
                continue;
            }
        }
    }

    private void checkData() { // номерами у людей тем более имена бывают разные, проверяем день рождения и пол

        if (this.birthday == null) throw new IncorrectBirthdayInput();
        String[] test = this.birthday.split("\\.");
        try {
            if (Integer.parseInt(test[0]) > 31 || Integer.parseInt(test[0]) < 1) throw new IncorrectBirthdayInput();
            if (Integer.parseInt(test[1]) > 12 || Integer.parseInt(test[1]) < 1) throw new IncorrectBirthdayInput();
            if (Integer.parseInt(test[2]) > 2023 || Integer.parseInt(test[2]) < 1900) throw new IncorrectBirthdayInput();
        } catch (NumberFormatException e) {
            throw new IncorrectBirthdayInput();
        }

        if (this.sex == null || (!this.sex.equals('m') && !this.sex.equals('f'))) throw new IncorrectSexInput();

        for (int i = 0; i < this.lastName.length(); i++) {
            if (isDigit(this.lastName.charAt(i))) throw new IncorrectNameInput();
        }

        for (int i = 0; i < this.firstName.length(); i++) {
            if (isDigit(this.firstName.charAt(i))) throw new IncorrectNameInput();
        }

        for (int i = 0; i < this.surname.length(); i++) {
            if (isDigit(this.surname.charAt(i))) throw new IncorrectNameInput();
        }
    }

    private void writeCard(String name, String dataString) throws IOException{

        String PATH = "src\\main\\java\\Seminar3HW\\" + name + ".txt";
        File file = new File(PATH);
        if (file.createNewFile()) {
            try (FileWriter fr = new FileWriter(file)) {
                fr.write(dataString);
            } catch (Exception e) {
                e.printStackTrace();
            } 
        } else {
            try (FileWriter fr = new FileWriter(file, true)) {
                fr.write("\n" + dataString);
            } catch (Exception e) {
                e.printStackTrace();
            } 
        }
    }

    public boolean isDigit(char ch) {

        try {
            Integer.parseInt(Character.toString(ch));
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
