import cars.Car;
import cars.CarFactory;
import cars.Ibed;
import cars.Iturbo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static java.lang.Math.PI;

public class CarModel {

    private ArrayList<Car> cars = new ArrayList<>();
    //static private final int delay = 50;
    //static private Timer timer = new Timer(delay, new TimerListener());

    static public void borderLogic(Car car) {   //I model
        if(
                car.getCenterPointx() < 0
                        || car.getCenterPointy() < 0
                        || car.getCenterPointx()+100 > ControlView.X
                        || car.getCenterPointy() > ControlView.Y){

            double initialSpeed = car.getCurrentSpeed();
            car.setCurrentSpeed(0);
            car.setDirection(car.getDirection() + PI);
            car.setCurrentSpeed(initialSpeed);
        }
    }

        public void carUniverse()  {
        cars.add(CarFactory.makeVolvo240());
        cars.add(CarFactory.makeSaab95());
        cars.add(CarFactory.makeScaniaR450());
        //cars.add(CarFactory.makeRetarderP400());

    }
//    public void start(){
//        timer.start();
//    }

    public void gasAll(double gasAmount) {
        double gas = (gasAmount) / 100;
        for (Car car : cars) {
            car.gas(gas);
        }
    }

    public void brakeAll(double brakeAmount) {
        double brake = (brakeAmount) / 100;
        for (Car car : cars) {
                car.brake(brake);
            }
        }

    public void turboOn() {
            for (Car car : cars) {
                if (car instanceof Iturbo)
                    ((Iturbo) car).setTurboOn();
            }
        }

        public void turboOff() {
            for (Car car : cars) {
                if (car instanceof Iturbo)
                    ((Iturbo) car).setTurboOff();
            }
        }


        public void lowerTruckBed() {
            for (Car truck : cars) {
                if (truck instanceof Ibed)
                    ((Ibed) truck).decidePlatformAngle(0);
            }
        }


        public void liftTruckBed() {
            for (Car truck : cars) {
                if (truck instanceof Ibed)
                    ((Ibed) truck).decidePlatformAngle(70);
            }
        }



        public void stopAllCars() {
            for (Car car : cars) {
                car.stopEngine();
            }
        }


        public void startAllCars() {
            for (Car car : cars) {
                car.startEngine();
            }
        }


    public ArrayList<Car> getCars() {
        return cars;
    }

}
