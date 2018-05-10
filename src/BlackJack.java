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
