package cars;

import java.awt.*;

/** Creates objects that are cars.Saab95.
 * @author madel
 * */
public class Saab95 extends Car implements Iturbo {

    private boolean turboOn;

    /** Creates a cars.Saab95.*/
    public Saab95(){
        super(2,125, Color.red, "cars.Saab95", 1_495, 0,100,0);
	    turboOn = false;
    }

    /** Answers if turbo is turned on for cars.Saab95.
     * @return boolean. true if turned on, false if turned off
     * */
    public boolean getTurboOn(){
        return turboOn;
    }

    /** Turns the turbo on for cars.Saab95.*/
    public void setTurboOn(){
	    turboOn = true;
    }

    /** Turns the turbo off for cars.Saab95.*/
    public void setTurboOff(){
	    turboOn = false;
    }

//    /** Calculates the speed factor for cars.Saab95.
//     * @return double a speed factor
//     * */

    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }




}
