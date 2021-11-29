import java.util.ArrayList;

public class Main {

    public void userInterface(Movable moveable) {
        char x = ' ';
        //char x = getCharacterFromUser();
        if (x == 'm') moveable.move();
        if (x == 'l') moveable.turnLeft();
    }

    public static void main (String[] args) {
        Volvo240 car = new Volvo240();
//        userInterface(car);
        Saab95 car2 = new Saab95();

/*        car
        System.out.println("Number of doors: " + car.getNrDoors());
        System.out.println("Engine power: " + car.getEnginePower());
        System.out.println("Current speed: " + car.getCurrentSpeed());
        car.startEngine();
        System.out.println("Current speed: " + car.getCurrentSpeed());
        car.gas(0.5);
        System.out.println("Current speed: " + car.getCurrentSpeed());*/

        ScaniaR450 truck = new ScaniaR450();
        truck.move();
        ArrayList<Object> list1 = new ArrayList<>();
        Workshop<Car, Volvo240> repairshop1 = new Workshop<Car, Volvo240>(car2, car, 4);

        repairshop1.recieveCar(car2);


//        car.startEngine();
//        car.move();
//        car.turnLeft();
//        car.turnLeft();
//        car.turnRight();

    }
}
