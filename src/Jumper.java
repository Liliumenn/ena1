public class Jumper {
    int height;

    public void jump() {
        height += 2;
    }

    public void bigJump() {    // метод нельзя запустить без прыгуна тк нет слова ststic
        height += 100;
    }

    public static double sqr(double x) {
       return x * x;
    }

    public static void main(String[] args) {
        double y = sqr(5.1);    // не требуется писать джампер. чтобы воспроизвести метод.
        System.out.println(y);

        Jumper jumper = new Jumper();
        jumper.height = 0;
        jumper.jump();
        jumper.bigJump();
        System.out.println(jumper.height);
    }

}
