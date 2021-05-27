package factory.abstractfactory;

public class Main {
    public static void main(String[] args) {
        AbastractFactory a = new ModernFactory();
        Food f = a.createFood();
        f.printName();
        Vehicle v = a.createVehicle();
        v.go();
        Weapon w = a.createWeapon();
        w.shoot();
    }
}
