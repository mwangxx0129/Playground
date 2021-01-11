package VMware;
import java.util.Random;

public class Solutions {
    public static void main(String[] args) {
        System.out.println("hello");
        int res = randNumber(12);
        System.out.println(res);
    }
    public static int randNumber(int n) {
        Random randomGenerator = new Random();
        int MAX = 10;//100000000;
        int min = n + 1;
        do {
            ++ min;
        } while (min % 10 == 0);

        min = min / 10;
        if (MAX <= min) return -1;
        int range = MAX - min;
        int randomInt = randomGenerator.nextInt(range) + min;
        return randomInt * 10;

    }
}
