package cars;

import java.awt.*;

/** A template for a truck.
 * @author madel
 * @author egord
 * */
// och Olof
public abstract class Truck extends Car {

    private double platformAngle;
    private String PlfrmToHighGasErrorMsg;
    private String PlfrmToLowGasErrorMsg;
    private String PlfrmErrorMsg;

    /** Creates a truck.*/
    public Truck(int nrDoors, double enginePower, Color color,String modelName, double weight, double centerPointx, double centerPointy, double direction, double platformAngle) {
        super(nrDoors, enginePower, color, modelName, weight, centerPointx, centerPointy, direction);
        this.platformAngle = platformAngle;
    }

    /** Gases a truck.
     * @param amount
     * */
    @Override
    public void gas(double amount) {
    if (platformAngle < 0){
        setPlfrmToLowGasErrorMsg();
        System.out.println(getPlfrmToLowGasErrorMsg());}
    else if (platformAngle > 0){
        setPlfrmToHighGasErrorMsg();
        System.out.println(getPlfrmToHighGasErrorMsg());
    }
    else{
        if (getCurrentSpeed() > getEnginePower()) setCurrentSpeed(getEnginePower());
        if (getCurrentSpeed() < 0) setCurrentSpeed(0);
        if (0 <= amount && amount < 1) {
            incrementSpeed(amount);
        } else {
            setgas_error_message();
            System.out.println(getGas_error_message());
        }
    }
    }


    @Override
    /** Calculates the speed factor for a truck.
     * @return double a speed factor
     * */
    public double speedFactor() {
        return getEnginePower() * 0.004;
    }

    /** Gets the platform angle of a truck.
     * @return double platformAngle
     * */
    public double getPlatformAngle() {
        return platformAngle;
    }

    /** Gets the error message when ramp too high for driving.
     * @return String error message that platform too high
     * */
    public String getPlfrmToHighGasErrorMsg() {
        return PlfrmToHighGasErrorMsg;
    }

    /** Gets the error message when ramp too low of a truck.
     * @return String error message that platform too low
     * */
    public String getPlfrmToLowGasErrorMsg() {
        return PlfrmToLowGasErrorMsg;
    }

    /** Gets the error message of a truck.
     * @return String a platform error message
     * */
    public String getPlfrmErrorMsg() {
        return PlfrmErrorMsg;
    }

    /** Sets the error message of a truck.
     * */
    public void setPlfrmErrorMsg() {
        PlfrmErrorMsg = "Must be stationary";
    }

    /** Sets the platform angle of a truck.
     * @param platformAngleValue how much the ramp of a truck is tilted
     * */
    public void setPlatformAngle(double platformAngleValue) {
        platformAngle = platformAngleValue;
    }

    /** Sets the error message when ramp too high of a truck.*/
    public void setPlfrmToHighGasErrorMsg() {
        PlfrmToHighGasErrorMsg = "Platform must be lowered";
    }

    /** Sets the error message when ramp too low of a truck.*/
    public void setPlfrmToLowGasErrorMsg() {
        PlfrmToLowGasErrorMsg = "Platform must be raised";
    }
}
