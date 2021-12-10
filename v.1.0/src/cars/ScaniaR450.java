package cars;

import java.awt.*;

/** Creates objects that are cars.ScaniaR450.
 * @author madel
 * */
public class ScaniaR450 extends Truck implements Ibed {

    /** Creates a cars.ScaniaR450.*/
    public ScaniaR450(){
        super(2,250, Color.white, "R-450-LA4x2MEB", 18_000,0,0,0, 0);
    }

    /**Decide platform angle between 0 and 70 degrees
     * @param angle platform angle */
    public void decidePlatformAngle(int angle) {
        if (getCurrentSpeed() == 0) {
            setPlatformAngle(angle);
            if (getPlatformAngle() > 70)
                setPlatformAngle(70);
            if (getPlatformAngle() < 0)
                setPlatformAngle(0);
        }
        else setPlfrmErrorMsg();
        System.out.println(getPlfrmErrorMsg());
    }
}
