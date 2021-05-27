package singleton;

/**
 * lazy loading
 * 也称懒汉式
 * 虽然达到了 按需初始化 [不会在类加载时就实例化对象] 的目的
 * 但却带来 线程不安全 的问题
 */
public class Mgr03 {
    private static Mgr03 INSTANCE;

    private Mgr03() {
    }

    public static Mgr03 getInstance() {
        if (INSTANCE == null) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Mgr03();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(Mgr03.getInstance().hashCode())).start();
        }
    }
}
