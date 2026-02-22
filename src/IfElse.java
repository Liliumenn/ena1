import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.concurrent.locks.Condition;

public class IfElse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\"ДА\" или \"НЕТ\": ");
        //int x = scanner.nextInt();
        String answer = scanner.nextLine();
        //String answer = "ДА";
        //boolean condition = x < 0 || x > 10;
        boolean condition = answer.equals("ДА");
        if (condition) {
            System.out.println("введено \"да\"");
        } else {
            if (answer.equals("НЕТ")) {
                System.out.println("введено \"нет\"");
            } else {
                System.out.println("введено что-то не то");
            }
            System.out.println("видно всегда");
        }
    }
}