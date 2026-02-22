import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        System.out.println("Привет! Ты готов начать играть в игру? (Напиши: ДА или НЕТ)");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        System.out.println("Ваш ответ:\t" + answer);
        if (answer.equals("ДА")) {
            System.out.println("Начинаем играть");
        } else if (answer.equals("НЕТ")) {
            System.out.println("Почему не хочешь :(" + "\nЗаходи ещё");
        }

        switch (answer) {
            case "ДА" -> {
                System.out.println("Выбери сложность от 1 до 5");
                int difficultGame = scanner.nextInt();
                System.out.println("Выбранная сложность: " + difficultGame);

                String castle = "З";
                String person = "Г";
                String monster = "Мм";
                int step = 0;
                int personX;
                int personY;
                int personLive = 3;
                int sizeboard = 5;
                personX = 1 + sizeboard / 2;
                personY = 1 + sizeboard / 2;
                int castleY = 1;
                Random random = new Random();
                int castleX = 1 + random.nextInt();
                String a = "[abc]";
                String b = "[def]";

                String pole = "+ —— + —— + —— +\n"
                        + "|    |    |    |\n"
                        + "+ —— + —— + —— +\n"
                        + "|    | " + monster + " |    | \n"
                        + "+ —— + —— + —— +\n"
                        + "|    | " + person + "  |    |\n"
                        + "+ —— + —— + —— +\n";
                System.out.println(pole);
                System.out.println("Количество жизней: " + personLive + " " + person);

                System.out.println("Введите куда будет ходить персонаж(ход возможен только по вертикали и горизонтали на одну клетку;");
                System.out.println("Координаты персонажа - (x: " + personX + ", y: " + personY + "))");
                int x = scanner.nextInt();
                int y = scanner.nextInt();

                if (x != personX && y != personY) {
                    System.out.println("Неккоректный ход");
                } else if (Math.abs(x - personX) == 1 || Math.abs(y - personY) == 1) {
                    personX = 1;
                    personY = 1;
                    step++;
                    System.out.println("Ход корректный; Новые координаты: " + personX + ", " + personY +
                            "\nХод номер: " + step);
                } else {
                    System.out.println("Координаты не изменены");
                }
            }
            default -> System.out.println("Данные введены неккоректно");
        }

    }



}
