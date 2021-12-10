import cars.Car;

import static java.lang.Math.PI;

public class CarModel {
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
}
