import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

import static java.lang.Math.abs;

public class RetarderP400 extends Truck implements Load {

    private ArrayList<Car> the_load;
    private String LoadErrorMsg;
    private String UnloadErrorMsg;



    public RetarderP400() {
        super(2,250, Color.orange, "Scania P400 E5 6x2 Komplett Zug Anhänger Retarder", 24_000,0,0,0, 0);
    }

    @Override
    public void raise() {
        if (getCurrentSpeed() == 0) {
            setPlatformAngle(0);
        }
        else { setPlfrmErrorMsg();
            System.out.println(getPlfrmErrorMsg());
        }
    }
    @Override
    public void lower() {
        if (getCurrentSpeed() == 0) {
            setPlatformAngle(-30);
        }
        else{ setPlfrmErrorMsg();
            System.out.println(getPlfrmErrorMsg());
        }
    }
    public void load(RetarderP400 cartransoporter, Car vehicle){
        if
        (the_load.size() < 8 && this.getPlatformAngle() == -30
                && (abs(this.getCenterPointx() - vehicle.getCenterPointx())) < 10
                && (abs(this.getCenterPointy() - vehicle.getCenterPointy())) < 10
                && vehicle != this
                && vehicle.getWeight() <2500){
            the_load.add(vehicle);
            vehicle.setCenterPointx(this.getCenterPointx());
            vehicle.setCenterPointy(this.getCenterPointy());
        }
        else setLoadErrorMsg();
        System.out.println(getThe_load());
    }


            //Dont forget to add error message



    public void unload(){
        if(this.getPlatformAngle() == -30 && the_load.size() != 0){
        Car last_car = the_load.get(the_load.size()-1);
        the_load.remove(the_load.size()-1);
        last_car.setCenterPointy(this.getCenterPointy()-10);
        last_car.setCenterPointx(this.getCenterPointx()-10);
        }
        else setUnloadErrorMsg();
        System.out.println(getUnloadErrorMsg());
    }

    public String getLoadErrorMsg() {
        return LoadErrorMsg;
    }

    public void setLoadErrorMsg() {
        LoadErrorMsg = "Can't load vehicle";
    }

    public String getUnloadErrorMsg() {
        return UnloadErrorMsg;
    }

    public void setUnloadErrorMsg() {
        UnloadErrorMsg = "Can't unload vehicle";
    }

    public ArrayList<Car> getThe_load() {
        return the_load;
    }
}

