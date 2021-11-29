import java.awt.*;

public abstract class Truck extends Car {

    private double platformAngle;
    private String PlfrmToHighGasErrorMsg;
    private String PlfrmToLowGasErrorMsg;
    private String PlfrmErrorMsg;

    public Truck(int nrDoors, double enginePower, Color color,String modelName, double weight, double centerPointx, double centerPointy, double direction, double platformAngle) {
        super(nrDoors, enginePower, color, modelName, weight, centerPointx, centerPointy, direction);
        this.platformAngle = 0;
    }


    public void raise() {
        if (getCurrentSpeed() == 0) {
            platformAngle = platformAngle + 10;
            if (platformAngle > 70)
                platformAngle = 70;
        }
        else setPlfrmErrorMsg();
            System.out.println(getPlfrmErrorMsg());
    }

    public void lower() {
        if (getCurrentSpeed() == 0) {
            platformAngle = platformAngle - 10;
            if (platformAngle < 0)
                platformAngle = 0;
        }
        else setPlfrmErrorMsg();
            System.out.println(getPlfrmErrorMsg());
    }


    @Override
    public void gas(double amount) {
    if (getPlatformAngle() < 0){
        setPlfrmToLowGasErrorMsg();
        System.out.println(getPlfrmToLowGasErrorMsg());}
    else if (getPlatformAngle() > 0){
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
    public double speedFactor() {
        return getEnginePower() * 0.004;
    }

    public double getPlatformAngle() {
        return platformAngle;
    }

    public String getPlfrmToHighGasErrorMsg() {
        return PlfrmToHighGasErrorMsg;
    }

    public String getPlfrmToLowGasErrorMsg() {
        return PlfrmToLowGasErrorMsg;
    }

    public String getPlfrmErrorMsg() {
        return PlfrmErrorMsg;
    }

    public void setPlfrmErrorMsg() {
        PlfrmErrorMsg = "Must be stationary";
    }

    public void setPlatformAngle(double platformAngle) {
        this.platformAngle = platformAngle;
    }

    public void setPlfrmToHighGasErrorMsg() {
        PlfrmToHighGasErrorMsg = "Platform must be lowered";
    }

    public void setPlfrmToLowGasErrorMsg() {
        PlfrmToLowGasErrorMsg = "Platform must be raised";
    }
}
