
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
import java.util.Set;

public class CarController{
    private CarModel model;
    private ControlView cv;

    public CarController(Views view, CarModel model) {
        cv = new ControlView();
        view.add(cv);

        cv.gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.gasAll(cv.gasAmount);
            }
        });


        cv.brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    model.brakeAll(cv);
                }
        }); // Flytta logik till model. Flytta actionlistener till view (Då är knappar och listener på samma ställe)

        cv.turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Car car : model.getCars()) {
                    if (car instanceof Iturbo)
                        ((Iturbo) car).setTurboOn();
                }
            }
        });

        cv.turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Car car : model.getCars()) {
                    if (car instanceof Iturbo)
                        ((Iturbo) car).setTurboOff();
                }
            }
        });

        cv.lowerBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Car truck : model.getCars()) {
                    if (truck instanceof Ibed)
                        ((Ibed) truck).decidePlatformAngle(0);
                }
            }
        });
        cv.liftBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Car truck : model.getCars()) {
                    if (truck instanceof Ibed)
                        ((Ibed) truck).decidePlatformAngle(0);
                }
            }
        });

        cv.stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Car car : model.getCars()) {
                    car.stopEngine();
                }
            }
        });

        cv.startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Car car : model.getCars()) {
                    car.startEngine();
                }
            }
        });
    }
}