package cn.itcast.jvm.t1.stack;

public class HanDemo1 {
    public static void main(String[] args) {

    }

    // 多个线程同时执行此方法
    static void m1() {
        int x = 0;
        for (int i = 0; i < 5000; i++) {
            x++;
        }
        System.out.println(x);
    }
}
