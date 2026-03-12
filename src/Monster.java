import java.util.Random;
import java.util.Scanner;

public class Monster {
    private String image = "Мм";
    private int x, y;
    Random r = new Random();

    Monster(int sizeboard) {
        this.x = r.nextInt(sizeboard-1);
        this.y = r.nextInt(sizeboard);
    }

    public String getImage() {
        return image;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Random getR() {
        return r;
    }

    public boolean taskMonster(int difficultGame) {
        return taskMonster();
    }

    public boolean taskMonster() {
        Random r = new Random();
        int x = r.nextInt(10);
        int y = r.nextInt(10);
        int trueAnswer = x + y;
        System.out.println("Реши пример " + x + " + " + y + " =");
        Scanner sc = new Scanner(System.in);
        int ans = sc.nextInt();
        if (ans == trueAnswer) {
            System.out.println("Молодец, ты прошёл");
            return true;
        } else {
            System.out.println("Ты проиграл(");
            return false;
        }
    }

    public boolean conflictPerson ( Person p) {
        return (p.getX() - 1) == this.x && (p.getY() - 1 )== this.y;
    }
}
