import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Views{
    protected static final int X = 1000;
    protected static final int Y = 600;

    PanelView drawPanel = new PanelView(X, Y-240);

    ControlView frame = new ControlView("CarSim 1.0");

    public Views() {
        this.drawPanel = new PanelView(X, Y-240);
        this.frame = new ControlView("CarSim 1.0");
    }
}
//    // This actionListener is for the gas button only
//    // TODO: Create more for each component as necessary
//
//        ControlView.brakeButton.addActionListener(new ActionListener() {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            carC.brake(gasAmount);
//        }
//    });
//        gasButton.addActionListener(new ActionListener() {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            carC.gas(gasAmount);
//        }
//    });
//
//        turboOnButton.addActionListener(new ActionListener() {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            carC.TurboOn();
//        }
//    });
//
//        turboOffButton.addActionListener(new ActionListener() {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            carC.TurboOff();                                    //nu är det carC. Vi vill ha det saab95.
//        }
//    });
//
//        lowerBedButton.addActionListener(new ActionListener() {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            carC.LowerBed();
//        }
//    });
//        liftBedButton.addActionListener(new ActionListener() {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            carC.liftBed();
//        }
//    });
//        startButton.addActionListener(new ActionListener() {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            carC.startAllCars();
//        }
//    });
//        stopButton.addActionListener(new ActionListener() {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            carC.stopAllCars();
//        }
//    });
//}
// skapa de andra klasserna.