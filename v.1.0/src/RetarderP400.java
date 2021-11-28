import java.awt.*;

public class RetarderP400 extends Truck implements Load {


    public RetarderP400() {
        super(2,300, Color.orange, "Scania P400 E5 6x2 Komplett Zug Anhänger Retarder", 0,0,0, 0);
    }


    public void raise() {
        if (getCurrentSpeed() == 0) {
            setPlatformAngle(70);
        }
        else System.out.println("Must be stationary");
    }

    public void lower() {
        if (getCurrentSpeed() == 0) {
            platformAngle = platformAngle - 10;
            if (platformAngle < 0)
                platformAngle = 0;
        }
        else System.out.println("Must be stationary");
    }



}
