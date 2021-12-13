import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Views extends JFrame {
    protected static final int X = 1000;
    protected static final int Y = 600;

    PanelView drawPanel;



    public Views(CarModel model, ControlView cv) {
        this.setTitle("CarSim 1.0");
        this.setPreferredSize(new Dimension(X,Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));


        this.drawPanel = new PanelView(X, Y-240, model);
        this.add(drawPanel);
        cv.addToFrame(this);

        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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