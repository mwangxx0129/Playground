//题目：backjack / 21 点， 给你一堆牌，从1到10，每张牌被抽的概率为1/10，问你dealer busted的概率是多少？
//        1. 如果dealer点数和不到17，将继续从牌堆抽牌；
//        2. 如果dealer点数和是在17-21，dealer stands，不继续抽牌;
//        3. 如果dealer点数和大于21，dealer busted；
//        条件2和条件3视为结束抽牌。
//
//        实现个LostProbability(int sum)的方法，返回输掉概率。sum是当前点数。求大米，谢谢
public class BlackJack {
    public static void main(String[] args) {
        long start=System.currentTimeMillis();   //获取开始时间
        test();
        long end=System.currentTimeMillis(); //获取结束时间
        System.out.println((end-start)+"ms");
    }

    public static void test() {
        Double[] mm = new Double[17];
//        lostProMM(0, mm); // 0ms
        lostPro(0); // 4ms
    }

    public static double lostProMM(int sum, Double[] mm) {
        if (sum >=17 && sum <= 21) return 0;
        if (sum > 21) return 1;
        if (mm[sum] != null) return mm[sum];
        double T = 0;
        for (int i = 1; i <= 10; ++ i)
            T += lostProMM(sum + i, mm) * 0.1;
        return mm[sum] = T;
    }

    public static double lostPro(int sum) {
        if (sum >=17 && sum <= 21) return 0;
        if (sum > 21) return 1;
        double T = 0;
        for (int i = 1; i <= 10; ++ i) {
            T += lostPro(sum + i) * 0.1;
        }
        return T;
    }
}
