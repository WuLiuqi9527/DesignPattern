package singleton;

/**
 * 使用静态代码块初始化
 * 跟 01 是一个意思
 */
public class Mgr02 {
    private static final Mgr02 INSTANCE;

    static {
        INSTANCE = new Mgr02();
    }

    private Mgr02() {}

    public static Mgr02 getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        Mgr02 m1 = Mgr02.getInstance();
        Mgr02 m2 = Mgr02.getInstance();
        System.out.println(m1 == m2);
    }
}
