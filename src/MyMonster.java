import java.util.Scanner;

public class MyMonster extends BigMonster {

    private String image = "Am";

    MyMonster(int sizeBoard) {
        super(sizeBoard);
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean taskMonster(int difficultGame) {
        System.out.println("Решите задачу:");
        if (difficultGame == 1) {
            System.out.println("какая буква пропущена? - к_лосок 1)а 2)о ");
        } else {
            int x = r.nextInt(10 * (difficultGame - 1), 10 * difficultGame);
            int y = r.nextInt(10 * (difficultGame - 1), 10 * difficultGame);
            int z = r.nextInt(100 * (difficultGame - 1), 100 * difficultGame);
            int trueAnswer = x * y - z;
            System.out.println("Реши пример: " + x + " * " + y + " - " + z + " = ?");
            Scanner sc = new Scanner(System.in);
            int ans = sc.nextInt();
            if (trueAnswer == ans) {
                System.out.println("Ты победил монстра");
                return true;
            }
            System.out.println("Ты проиграл");
        }

        return false;
    }
    public boolean taskMonster() {
        return super.taskMonster(0);
    }
}
