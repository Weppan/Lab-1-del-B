import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static java.lang.Math.PI;



/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {



    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Car> cars = new ArrayList<>(); //Får denna vara Static??


    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

//        cc.cars.add(new Volvo240());       default code
//        Volvo240 volvo = new Volvo240();
//        cc.cars.add(volvo);
        Saab95 saab = new Saab95();
        saab.setCenterPointy(100);      //detta känns dåligt
        cc.cars.add(saab);
//        ScaniaR450 scania = new ScaniaR450();
//        scania.setCenterPointy(200);
//        cc.cars.add(scania);


        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Car car : cars) {

                borderLogic(car);

                car.move();

                int x = (int) Math.round(car.getCenterPointx());
                int y = (int) Math.round(car.getCenterPointy());
                frame.drawPanel.moveit(x, y);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }

    private void borderLogic(Car car) {
        if(
                car.getCenterPointx() < 0
                || car.getCenterPointy() < 0
                || car.getCenterPointx() > CarView.X
                || car.getCenterPointy() > CarView.Y){

            double initialSpeed = car.getCurrentSpeed();
            car.setCurrentSpeed(0);
            car.setDirection(car.getDirection() + PI);
            car.setCurrentSpeed(initialSpeed);
        }
    }


    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars) {
            car.gas(gas);
        }
    }
    void brake(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars) {
            car.brake(gas);
        }
    }
}
