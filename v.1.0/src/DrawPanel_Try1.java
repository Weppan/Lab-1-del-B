//import java.awt.*;
//import java.awt.image.BufferedImage;
//import java.io.IOException;
//import java.util.ArrayList;
//import javax.imageio.ImageIO;
//import javax.swing.*;
//
//// This panel represent the animated part of the view with the car images.
//
//public class DrawPanel_Try1 extends JPanel{
//
//    // Just a single image, TODO: Generalize
//    //BufferedImage volvoImage;
//    BufferedImage carImage;
//
//    // To keep track of a singel cars position
//    Point carPoint = new Point();
//    //list of cars
//    ArrayList<BufferedImage> images = new ArrayList<>();
//
//    // TODO: Make this genereal for all cars
//    void moveit(int x, int y){
//        carPoint.x = x;
//        carPoint.y = y;
//    }
//
//    // Initializes the panel and reads the images
//    public DrawPanel_Try1(int x, int y) {
//        this.setDoubleBuffered(true);
//        this.setPreferredSize(new Dimension(x, y));
//        this.setBackground(Color.pink);
//        // Print an error message in case file is not found with a try/catch block
//        try {
//            // You can remove the "pics" part if running outside of IntelliJ and
//            // everything is in the same main folder.
//            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));
//
//            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
//            // if you are starting in IntelliJ.
//
//
//
//            for(Car car : CarController.cars)
//                if(car instanceof Volvo240){
//                    carImage = ImageIO.read(DrawPanel_Try1.class.getResourceAsStream("pics/Volvo240.jpg"));
//                    images.add(carImage);
//                }
//                else if(car instanceof Saab95){
//                    carImage = ImageIO.read(DrawPanel_Try1.class.getResourceAsStream("pics/Saab95.jpg"));
//                    images.add(carImage);
//                }
//                else if(car instanceof ScaniaR450)
//                    carImage = ImageIO.read(DrawPanel_Try1.class.getResourceAsStream("pics/Scania.jpg"));
//                    images.add(carImage);
//
//        } catch (IOException ex)
//        {
//            ex.printStackTrace();
//        }
//
//    }
//
//    // This method is called each time the panel updates/refreshes/repaints itself
//    // TODO: Change to suit your needs.
//    @Override
//    protected void paintComponent(Graphics g) {
//        for (BufferedImage image: images){
//            super.paintComponent(g);
//            g.drawImage(image, carPoint.x, carPoint.y, null); // see javadoc for more info on the parameters
//    }
//    }
//}
