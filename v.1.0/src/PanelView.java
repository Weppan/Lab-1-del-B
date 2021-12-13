import cars.Car;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class PanelView extends JPanel {


        private CarModel model;



    // Just a single image, TODO: Generalize
    BufferedImage defaultImage;

    // Initializes the panel and reads the images
    public PanelView(int x, int y, CarModel model) {
        this.model = model;
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.pink);
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("cars.cars.Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            defaultImage = ImageIO.read(PanelView.class.getResourceAsStream("pics/cars.default.jpg"));
           // Image = ImageIO.read(PanelView.class.getResourceAsStream("pics/" + car.getClass().getName() + ".jpg"));

        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        BufferedImage Image;
        Image = defaultImage; //defaultImage
        for (Car car : model.getCars()) {
            String carName = car.getModelName();
            try {
                Image = ImageIO.read(PanelView.class.getResourceAsStream("pics/cars.Saab95.jpg"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            g.drawImage(Image, (int)Math.round(car.getCenterPointx()), (int)Math.round(car.getCenterPointy()), null); // see javadoc for more info on the parameters
        }
    }
}
