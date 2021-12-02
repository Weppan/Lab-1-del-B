import java.awt.*;
import java.util.ArrayList;

import static java.lang.Math.*;

/** Creates objects that are RetarderP400.
 * @author madel
 * */
public class RetarderP400 extends Truck implements Load {

    private ArrayList<Car> the_load;
    private String LoadErrorMsg;
    private String UnloadErrorMsg;


    /** Creates a RetarderP400.*/
    public RetarderP400() {
        super(2,250, Color.orange, "Scania P400 E5 6x2 Komplett Zug Anhänger Retarder", 24_000,0,0,0, 0);
        the_load = new ArrayList<>();
    }

    /** Raises the ramp of a RetarderP400.*/
    public void raise() {
        if (getCurrentSpeed() == 0) {
            setPlatformAngle(0);
        }
        else { setPlfrmErrorMsg();
            System.out.println(getPlfrmErrorMsg());
        }
    }

    /** Lowers the ramp of a RetarderP400.*/
    public void lower() {
        if (getCurrentSpeed() == 0) {
            setPlatformAngle(-30);
        }
        else{ setPlfrmErrorMsg();
            System.out.println(getPlfrmErrorMsg());
        }
    }

    /** Loads a RetarderP400.
     * @param vehicle
     * */
    public void load(Car vehicle){
        if
        (the_load.size() < 8 && this.getPlatformAngle() == -30
                && (abs(this.getCenterPointx() - vehicle.getCenterPointx())) < 10
                && (abs(this.getCenterPointy() - vehicle.getCenterPointy())) < 10
                && vehicle != this
                && vehicle.getWeight() <2500){
            the_load.add(vehicle);
            vehicle.setLoaded(true);
            vehicle.setCurrentSpeed(0);
            vehicle.setCenterPointx(this.getCenterPointx());
            vehicle.setCenterPointy(this.getCenterPointy());
        }
        else setLoadErrorMsg();
        System.out.println(getThe_load());
    }



    /** Unloads a RetarderP400.*/
    public void unload(){
        if(this.getPlatformAngle() == -30 && the_load.size() != 0){
        Car last_car = the_load.get(the_load.size()-1);
        the_load.remove(the_load.size()-1);
        last_car.setCenterPointy(this.getCenterPointy()-10);
        last_car.setCenterPointx(this.getCenterPointx()-10);
        last_car.setLoaded(false);
        }
        else setUnloadErrorMsg();
        System.out.println(getUnloadErrorMsg());
    }
    @Override
    public void move() {

        double distance = getCurrentSpeed() * 1; //1 är tidsenheten.

        if (0 <= this.getDirection() && this.getDirection() < PI / 2) {
            this.setCenterPointx(this.getCenterPointx() + cos(this.getDirection()) * distance);
            this.setCenterPointy(this.getCenterPointy() + sin(this.getDirection()) * distance);
            System.out.println("x " + this.getCenterPointx());
            System.out.println("y " + this.getCenterPointy());

        } else if (PI / 2 <= this.getDirection() && this.getDirection() < PI) {
            this.setCenterPointx(this.getCenterPointx() - sin(this.getDirection()) * distance);
            this.setCenterPointy(this.getCenterPointy() + cos(this.getDirection()) * distance);
            System.out.println("x " + this.getCenterPointx());
            System.out.println("y " + this.getCenterPointy());
        } else if (PI <= this.getDirection() && this.getDirection() < (3 * PI) / 2) {
            this.setCenterPointx(this.getCenterPointx() - cos(this.getDirection()) * distance);
            this.setCenterPointy(this.getCenterPointy() - sin(this.getDirection()) * distance);
            System.out.println("x " + this.getCenterPointx());
            System.out.println("y " + this.getCenterPointy());
        } else {
            this.setCenterPointx(this.getCenterPointx() + sin(this.getDirection()) * distance);
            this.setCenterPointy(this.getCenterPointy() - cos(this.getDirection()) * distance);
            System.out.println("x " + this.getCenterPointx());
            System.out.println("y " + this.getCenterPointy());
        }
        this.updateTheLoadPosition();
    }

    private void updateTheLoadPosition(){
        for (Car i : the_load) {
            i.setCenterPointx(this.getCenterPointx());
            i.setCenterPointy(this.getCenterPointy());
        }
    }

    /** Gets the load error message of a RetarderP400.
     * @return String load error message
     * */
    public String getLoadErrorMsg() {
        return LoadErrorMsg;
    }

    /** Sets the load error message of a RetarderP400.*/
    public void setLoadErrorMsg() {
        LoadErrorMsg = "Can't load vehicle";
    }

    /** Gets the unload error message of a RetarderP400.
     * @return String unload error message
     * */
    public String getUnloadErrorMsg() {
        return UnloadErrorMsg;
    }

    /** Sets the unload error message of a RetarderP400.*/
    public void setUnloadErrorMsg() {
        UnloadErrorMsg = "Can't unload vehicle";
    }

    /** Gets the load of a RetarderP400, i.e. what is loaded.
     * @return ArrayList the load of a RetarderP400
     * */
    public ArrayList<Car> getThe_load() {
        return the_load;
    }
}

