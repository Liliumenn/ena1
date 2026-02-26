import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class Game {

    static void taskMonster() {
        Random r = new Random();
        int x = r.nextInt(10);
        int y = r.nextInt(10);
        int trueAnswer = x + y;
        System.out.println("Реши пример " + x + " + " + y + " =");
        Scanner sc = new Scanner(System.in);
        int ans = sc.nextInt();
        if (ans == trueAnswer) {
            System.out.println("Молодец, ты прошёл");
        } else {
            System.out.println("Ты проиграл(");
        }
    }

    public static void main(String[] args) {

        int maxStep = 2;

        String castle = "З";
        String person = "Гг";
        String monster = "Мм";
        int step = 0;
        int personX;
        int personY;
        int personLive = 3;
        int sizeboard = 5;
        personX = 1 + sizeboard / 2;
        personY = 1 + sizeboard / 2;
        int castleY = 1;

        String leftBlock = " | ";
        String rightBlock = " |";
        String wall = " + —— + —— + —— + —— + —— + ";

        String pole = "+ —— + —— + —— +\n"
                + "|    |    |    |\n"
                + "+ —— + —— + —— +\n"
                + "|    | " + monster + " |    | \n"
                + "+ —— + —— + —— +\n"
                + "|    |    | " + person + " |\n"
                + "+ —— + —— + —— +\n";

        String[][] board = new String[sizeboard][sizeboard];
        for (int y = 0; y < sizeboard; y++) {
            for (int x = 0; x < sizeboard; x++) {
                board[y][x] = "  ";

            }
        }

        int countMonster = sizeboard * sizeboard - sizeboard - 1;
        Random r = new Random();
        for (int i = 0; i <= countMonster; i++) {
            board[r.nextInt(sizeboard - 1)][r.nextInt(sizeboard)] = monster;
        }

        int castleX = r.nextInt(sizeboard);

        board[castleY][castleX] = castle;


        System.out.println("Привет! Ты готов начать играть в игру? (Напиши: ДА или НЕТ)");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        System.out.println("Ваш ответ:\t" + answer);

        switch (answer) {
            case "ДА" -> {
                System.out.println("Выбери сложность от 1 до 5");
                int difficultGame = scanner.nextInt();
                System.out.println("Выбранная сложность: " + difficultGame);


                System.out.println("Количество жизней: " + personLive + " " + person);
                while ((personLive > 0) && !(castleX == personX && castleY == personY)) {
                    board[personY - 1][personX - 1] = person;

                    for (int y = 1; y <= sizeboard; y++) {
                        System.out.println(wall);
                        for (int x = 1; x <= sizeboard; x++) {
                            System.out.print(leftBlock);

                                System.out.print(board[y - 1][x - 1]);

                        }
                        System.out.println(rightBlock);
                    }
                    System.out.println(wall);


                    System.out.println("Введите куда будет ходить персонаж (ход только по вертикали и горизонтали на одну клетку;");
                    System.out.println("Координаты персонажа - (x: " + personX + ", y: " + personY + "))");
                    int x = scanner.nextInt();
                    int y = scanner.nextInt();
                    if (x != personX && y != personY) {
                        System.out.println("Неккоректный ход");
                    } else if (Math.abs(x - personX) == 1 || Math.abs(y - personY) == 1) {
                        step++;
                        if (board[y - 1][x - 1].equals("  ")) {
                            board[personY - 1][personX - 1] = "  ";
                            personX = x;
                            personY = y;
                            System.out.println("Ход корректный; Новые координаты: " + personX + ", " + personY +
                                    "\nХод номер: " + step);
                        } else if (board[y - 1][x - 1].equals(castle)) {
                            System.out.println("Вы ПРОШЛИ игру!!!!!");
                        } else {
                            System.out.println("Реши задачку!");
                            taskMonster();
                        }

                    } else {
                        System.out.println("Координаты не изменены");
                    }
                }
                ///
            }

            case "НЕТ" -> {
                System.out.println("Почему не хочешь :(" + "\nЗаходи ещё");
            }
            default -> System.out.println("Данные введены неккоректно");

        }

    }


}
