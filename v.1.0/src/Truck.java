import java.awt.*;

public abstract class Truck extends Car {

    private double platformAngle;

    public Truck(int nrDoors, double enginePower, Color color,String modelName, double weight, double centerPointx, double centerPointy, double direction, double platformAngle) {
        super(nrDoors, enginePower, color, modelName, weight, centerPointx, centerPointy, direction);
        this.platformAngle = platformAngle;
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


    @Override
    public void gas(double amount) {
    if (getPlatformAngle() == 0)
        if (getCurrentSpeed() > getEnginePower()) setCurrentSpeed(getEnginePower());
        if (getCurrentSpeed() < 0) setCurrentSpeed(0);
        if (0 <= amount && amount < 1) {
            incrementSpeed(amount);
        } else {
            setgas_error_message();
            System.out.println(getGas_error_message());
        }
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
