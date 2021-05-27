package singleton;

/**
 * lazy loading
 * 也称懒汉式
 * 虽然达到了 按需初始化 [不会在类加载时就实例化对象] 的目的
 * 但却带来 线程不安全 的问题
 * -> 可以通过 synchronized 解决，但也带来效率下降
 * -> 妄图通过减小同步代码块的方式提高效率，然而 不可行, 连 线程安全 都做不到了,相当于没加锁
 * -> 双重判断 加上 volatile
 */
public class Mgr06 {
    private static volatile Mgr06 INSTANCE;

    private Mgr06() {
    }

    public static Mgr06 getInstance() {
        if (INSTANCE == null) {
            synchronized (Mgr06.class){
                if (INSTANCE == null) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE = new Mgr06();
                }
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(Mgr06.getInstance().hashCode())).start();
        }
    }
}
