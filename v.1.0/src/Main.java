import cars.*;

import javax.imageio.ImageIO;
import java.io.IOException;

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
        Car car575 = new Saab95();
        Saab95 car766 = new Saab95();

        ScaniaR450 truck = new ScaniaR450();
        truck.move();



//        car.startEngine();
//        car.move();
//        car.turnLeft();
//        car.turnLeft();
//        car.turnRight();

        Volvo240 car = new Volvo240();
        Volvo240 car2 = new Volvo240();
//        userInterface(car);
       // cars.Saab95 car2 = new cars.Saab95();
       // cars.Saab95 car3 = new cars.Saab95();

        //Workshop<cars.Car, cars.Saab95> repairshop1 = new Workshop<>(car2, car3, 4);


        //System.out.println(("\n"pics/" + car.getClass().getName() + ".jpg""));

        String fileName = new String("pics/" +car.getClass().getName()+ ".jpg");

        System.out.println(fileName);

        RetarderP400 platformer = new RetarderP400();


        platformer.lower();

        System.out.println(platformer.getThe_load());





//        String word1 = new String("Hello");
//        ArrayList<String> strList = new ArrayList<String>();
//        ArrayList<cars.Car> carList = new ArrayList<>();






    }
}
