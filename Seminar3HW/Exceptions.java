package Seminar3HW;


class OverDataInputException extends RuntimeException {

    OverDataInputException() {

        super("Некорректный ввод данных! Вы ввели больше данных чем требуется");
    }
}


class LackOfDataInputException extends RuntimeException {

    LackOfDataInputException() {

        super("Некорректный ввод данных! Вы ввели меньше данных чем требуется");
    }
}


class IncorrectSexInput extends RuntimeException {

    IncorrectSexInput() {

        super("Вы некорректно ввели пол человека");
    }
}


class IncorrectBirthdayInput extends RuntimeException {

    IncorrectBirthdayInput() {

        super("Вы некорректно ввели дату рождениия человека");
    }
}


class IncorrectNameInput extends RuntimeException {

    IncorrectNameInput() {

        super("Некорректный ввод имени");
    }
}