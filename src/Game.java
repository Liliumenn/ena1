import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class Game {

    public static void main(String[] args) {

        Person person = new Person();

        int maxStep = 2;

        String castle = "Зз";

        int step = 0;
        int sizeboard = 5;
        int castleY = 1;

        String leftBlock = " | ";
        String rightBlock = " |";
        String wall = " + —— + —— + —— + —— + —— + ";

        String[][] board = new String[sizeboard][sizeboard];
        for (int y = 0; y < sizeboard; y++) {
            for (int b = 0; b < sizeboard; b++) {
                board[y][b] = "  ";

            }
        }

        int countMonster = sizeboard * sizeboard - sizeboard - 1;
        Random r = new Random();

        Monster[] arrMonster = new Monster[countMonster + 1];
        int count = 0;
        Monster test;
        while (count <= countMonster) {
            if (r.nextInt(3)==0){
                test = new Monster(sizeboard);
            }else if (r.nextInt(3)==1){
                test = new BigMonster(sizeboard);
            }else {
                test = new MyMonster(sizeboard);
            }
            if (board[test.getY()][test.getX()].equals("  ")){
                board[test.getY()][test.getX()] = test.getImage();
                arrMonster[count] = test;
                count++;
            }

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
                if (difficultGame < 1) {
                    difficultGame = 1;}
                if (difficultGame > 5){
                    difficultGame = 5;}
                System.out.println("Выбранная сложность: " + difficultGame);


                System.out.println("Количество жизней: " + person.getLive() + " " + person);
                while (true) {
                    board[person.getY() - 1][person.getX() - 1] = person.getImage();

                    for (int x = 1; x <= sizeboard; x++) {
                        System.out.println(wall);
                        for (int y = 1; y <= sizeboard; y++) {
                            System.out.print(leftBlock);

                            System.out.print(board[x - 1][y - 1]);

                        }
                        System.out.println(rightBlock);
                    }
                    System.out.println(wall);

                    System.out.println("Введите куда будет ходить персонаж (ход только по вертикали и горизонтали на одну клетку;");
                    System.out.println("Координаты персонажа - (x: " + person.getX() + ", y: " + person.getY() + "))");
                    int x = scanner.nextInt();
                    int y = scanner.nextInt();

                    if (person.moveCorrect(x, y)) {
                        String next = board[y - 1][x - 1];
                        if (next.equals("  ")) {
                            board[person.getY() - 1][person.getX() - 1] = "  ";
                            person.move(x, y);
                            step++;
                            System.out.println("Ход корректный; Новые координаты: " + person.getX() + ", " + person.getY() +
                                    "\nХод номер: " + step);
                        } else if (next.equals(castle)) {
                            System.out.println("Вы прошли игру!");
                            break;
                        } else {
                            for (Monster monster : arrMonster) {
                                if (monster.conflictPerson(person)) {
                                    if (monster.taskMonster(difficultGame)) {
                                        board[person.getY() - 1][person.getX() - 1] = "  ";
                                        person.move(x, y);
                                    } else {
                                        person.downlive();
                                    }
                                    break;
                                }
                            }
                        }
                    } else {
                        System.out.println("Координаты не изменены");
                    }
                }
            } case "НЕТ" -> {
                System.out.println("Почему не хочешь :(" + "\nЗаходи ещё");
            }
            default -> System.out.println("Данные введены неккоректно");
        }
    }
}


