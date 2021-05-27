package singleton;

/**
 * lazy loading
 * 也称懒汉式
 * 虽然达到了 按需初始化 [不会在类加载时就实例化对象] 的目的
 * 但却带来 线程不安全 的问题
 * -> 可以通过 synchronized 解决，但也带来效率下降
 */
public class Mgr04 {
    private static Mgr04 INSTANCE;

    private Mgr04() {
    }

    public static synchronized Mgr04 getInstance() {
        if (INSTANCE == null) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Mgr04();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(Mgr04.getInstance().hashCode())).start();
        }
    }
}
