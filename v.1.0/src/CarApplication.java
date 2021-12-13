import cars.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarApplication {
    //BEHÖVER ALLT VARA STATIC??????
    // member fields:


    //static PanelView drawPanel = new PanelView(X, Y-240);

    // The delay (ms) corresponds to 20 updates a sec (hz)
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    // The frame that represents this instance View of the MVC pattern
    //ControlView frame = new ControlView("CarSim 1.0");
    // A list of cars, modify if needed


    //methods:

    public static void main(String[] args) {

       CarModel model = new CarModel();
       model.carUniverse();
       Views view = new Views();
       CarController cc = new CarController(view, model); //view.drawpanel
        TimerListener timer = new TimerListener(model);












        // Instance of this class

 // Create model, views, controllers and have it call the start method



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
        model.start();
    }

    static private class TimerListener implements ActionListener {
        private CarModel model;

        public TimerListener(CarModel model) {
            this.model = model;
        }

        public void actionPerformed(ActionEvent e) {
            for (Car car : model.getCars()) {
                CarModel.borderLogic(car);
                car.move();
                view.repaint();
            }
        }
    }
}
