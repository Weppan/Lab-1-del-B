import java.awt.*;

/** Creates objects that are Volvo240.
 * @author madel
 * */
public class Volvo240 extends Car {

    final double trimFactor = 1.25;


    /** Creates a Volvo240.*/
    public Volvo240() {
        super(4, 100, Color.black, "Volvo240", 1_495,0, 0, 0);

    }
    /** Calculates the speed factor for Volvo240.
     * @return double a speed factor
     * */
    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }
}