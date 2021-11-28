import java.awt.*;
import java.util.ArrayList;

import static java.lang.Math.abs;

public class RetarderP400 extends Truck implements Load {

    private ArrayList<Car> the_load;

    public RetarderP400() {
        super(2,300, Color.orange, "Scania P400 E5 6x2 Komplett Zug Anhänger Retarder", 24_000,0,0,0, 0);
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
        (the_load.size() < 8 && this.getPlatformAngle() == -30
                && (abs(this.getCenterPointx() - vehicle.getCenterPointx())) < 10
                && (abs(this.getCenterPointy() - vehicle.getCenterPointy())) < 10
                && vehicle != this
                && vehicle.getWeight() <2500)
            the_load.add(vehicle);
            vehicle.setCenterPointx(this.getCenterPointx());
            vehicle.setCenterPointy(this.getCenterPointy());
    }


            //Dont forget to add error message



    public void unload(){
        if(this.getPlatformAngle() == -30 && the_load.size() != 0){
        Car last_car = the_load.get(the_load.size()-1);
        the_load.remove(the_load.size()-1);
        last_car.setCenterPointy(this.getCenterPointy()-10);
        last_car.setCenterPointx(this.getCenterPointx()-10);
        }
    }
}

