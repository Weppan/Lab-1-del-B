import java.awt.*;

import static java.lang.Math.*;
import static java.lang.Math.PI;

public class Scania extends Car{

    private double platformAngle;

    public Scania(){
        super(2,200, Color.white, "R-450-LA4x2MEB", 0,0,0);
        this.platformAngle = 0;
    }






    public void raise() {
        if (getCurrentSpeed() == 0) {
            platformAngle = platformAngle + 10;
            if (platformAngle > 70)
                platformAngle = 70;
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


    public void condition() {
        if (platformAngle == 0)
            move();
            //System.out.println("Platform must be flat");

    }


    @Override
    public double speedFactor() {
        return getEnginePower();
    }


    public double getPlatformAngle() {
        return platformAngle;
    }

    public void setPlatformAngle(double platformAngle) {
        this.platformAngle = platformAngle;
    }
}
