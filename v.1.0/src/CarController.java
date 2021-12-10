
/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

import cars.Car;
import cars.Ibed;
import cars.Iturbo;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

public class CarController implements ActionListener{
    ControlView carV;
    public CarController(ControlView cv) {
        this.carV = cv;
        cv.gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double gas = ((double) cv.gasAmount) / 100;
                for (Car car : CarApplication.cars) {
                    car.gas(gas);
                }
            }
        });


        cv.brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double gas = ((double) cv.gasAmount) / 100;
                for (Car car : CarApplication.cars) {
                    car.brake(gas);
                }
            }
        });

        cv.turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Car car : CarApplication.cars) {
                    if (car instanceof Iturbo)
                        ((Iturbo) car).setTurboOn();
                }
            }
        });

        cv.turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Car car : CarApplication.cars) {
                    if (car instanceof Iturbo)
                        ((Iturbo) car).setTurboOff();
                }
            }
        });

        cv.lowerBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Car truck : CarApplication.cars) {
                    if (truck instanceof Ibed)
                        ((Ibed) truck).decidePlatformAngle(0);
                }
            }
        });
        cv.liftBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Car truck : CarApplication.cars) {
                    if (truck instanceof Ibed)
                        ((Ibed) truck).decidePlatformAngle(0);
                }
            }
        });

        cv.stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Car car : CarApplication.cars) {
                    car.stopEngine();
                }
            }
        });

        cv.startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Car car : CarApplication.cars) {
                    car.startEngine();
                }
            }
        });
    }
}