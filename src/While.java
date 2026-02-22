public class While {
    public static void main(String[] args) throws InterruptedException {
        int x = 0;

        while (x < 10) {
            System.out.println(x++ + " меньше 10");
            Thread.sleep(50);
            if (x > 10) break;
        }

        //x = 0;   цикл заупстится хотя бы 1 раз.
        //do {
           // System.out.println("true");
          //  Thread.sleep(50);
        //} while (x > -1);

        String[] array = new String[5];
        array[2] = "Mm";
        for (int i = 0;i < array.length;i += 1) {      // fori - быстрый ввод структуры
            System.out.println(array[i]);
        }

    }
}
