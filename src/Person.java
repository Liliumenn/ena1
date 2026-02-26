public class Person {
    int x, y;
    String image = "Гг";
    int live = 3;

    void move(int x,int y) {
        this.x = x;
        this.y = y;
    }

    public boolean moveCorrect(int x,int y){
        return this.x == x && Math.abs(this.y - y) == 1 || this.y == y && Math.abs(this.x - x) == 1;

    }

}

