import cars.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class CarApplication {
    //BEHÖVER ALLT VARA STATIC??????
    // member fields:
    protected static final int X = 1000;
    protected static final int Y = 600;


    static Views view = new Views();
    //static PanelView drawPanel = new PanelView(X, Y-240);

    // The delay (ms) corresponds to 20 updates a sec (hz)
    static private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    static private Timer timer = new Timer(delay, new TimerListener());
    // The frame that represents this instance View of the MVC pattern
    //ControlView frame = new ControlView("CarSim 1.0");
    // A list of cars, modify if needed

    static ArrayList<Car> cars = new ArrayList<>();
    CarController cc = new CarController(view.frame);

    //methods:

    public static void main(String[] args) {
        // Instance of this class


        cars.add(CarFactory.makeVolvo240());
        cars.add(CarFactory.makeSaab95());
        cars.add(CarFactory.makeScaniaR450());
        cars.add(CarFactory.makeRetarderP400());


/*        cars.add(new Volvo240());
        Volvo240 volvo = new Volvo240();
        cars.add(volvo);
        Saab95 saab = new Saab95();
        saab.setCenterPointy(100);
        cars.add(saab);
        ScaniaR450 scania = new ScaniaR450();
        scania.setCenterPointy(200);
        cars.add(scania);*/


        // Start a new view and send a reference of self
        //frame = new ControlView("CarSim 1.0");

        // Start the timer
        timer.start();
    }

    static private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Car car : cars) {
                CarModel.borderLogic(car);
                car.move();
                view.drawPanel.repaint();
            }
        }
    }
}
