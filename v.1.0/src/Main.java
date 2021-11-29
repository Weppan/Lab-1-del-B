import java.util.ArrayList;

public class Main {

    public void userInterface(Movable moveable) {
        char x = ' ';
        //char x = getCharacterFromUser();
        if (x == 'm') moveable.move();
        if (x == 'l') moveable.turnLeft();
    }

    public static void main (String[] args) {


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



//        car.startEngine();
//        car.move();
//        car.turnLeft();
//        car.turnLeft();
//        car.turnRight();

        Volvo240 car = new Volvo240();
//        userInterface(car);
        Saab95 car2 = new Saab95();
        Saab95 car3 = new Saab95();

        //Workshop<Car, Saab95> repairshop1 = new Workshop<>(car2, car3, 4);


        Workshop<Volvo240> repairshop1 = new Workshop<>(4);
        Workshop<Saab95> repairshop2 = new Workshop<>(4);


        repairshop1.recieveCar(car);
        //repairshop1.retrieveCar(car2);



        String word1 = new String("Hello");
        ArrayList<String> strList = new ArrayList<String>();
        ArrayList<Car> carList = new ArrayList<>();
        carList.add(car3);
        System.out.println(carList);



    }
}
