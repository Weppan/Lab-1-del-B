import java.awt.*;
import java.util.ArrayList;

import static java.lang.Math.abs;

public class RetarderP400 extends Truck implements Load {

    private ArrayList<String> load;

    public RetarderP400() {
        super(2,300, Color.orange, "Scania P400 E5 6x2 Komplett Zug Anhänger Retarder", 0,0,0, 0);
    }

    @Override
    public void raise() {
        if (getCurrentSpeed() == 0) {
            setPlatformAngle(0);
        }
        else System.out.println("Must be stationary");
    }
    @Override
    public void lower() {
        if (getCurrentSpeed() == 0) {
            setPlatformAngle(-30);
        }
        else System.out.println("Must be stationary");

    }
    public void load(RetarderP400 cartransoporter, Car vehicle){
        if
        (load.size() < 8 && getPlatformAngle() == -30
                && (abs(cartransoporter.getCenterPointx() - vehicle.getCenterPointx())) < 10
                && (abs(cartransoporter.getCenterPointy() - vehicle.getCenterPointy())) < 10
                && vehicle != cartransoporter)
            load.add(vehicle.getModelName());
    }
}

