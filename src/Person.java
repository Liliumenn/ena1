import java.util.Random;

public class Person {
    private int x, y;
    private String image = "Гг";
    private int live = 3;
    Random r = new Random();

    Person (int sizeboard) {
        y = sizeboard;
        int n = r.nextInt(sizeboard);
        x = n == 0 ? 1 : n;
    }

    Person(int x, int y) {
        this.x = x;
        this.y = y;
    }

    Person() {
        this(1,1);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getImage() {
        return image;
    }

    public int getLive() {
        return live;
    }

    public Random getR() {
        return r;
    }

    void move(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean moveCorrect(int x,int y){
        if (this.x == x && Math.abs(this.y -y) == 1 || this.y == y && Math.abs(this.x - x) == 1){
            return true;
        }
        return false;
    }

    public void downlive() {
        live--;
    }

    public boolean conflictPerson ( Person person) {
        return person.getX() == this.x && person.getY() == this.y;
    }

}

