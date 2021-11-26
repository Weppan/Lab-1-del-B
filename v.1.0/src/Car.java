import java.awt.*; // ML. Is this needed?

import static java.lang.Math.*;


public abstract class Car implements Movable{

    private final int nrDoors; // Number of doors on the car
    private final double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private final String modelName; // The car model name
    private double centerPointx; // Position x coordinate
    private double centerPointy; // Position y coordinate
    private double direction; // Angle
    private String gas_error_message;
    private String brake_error_message;

    public Car(int nrDoors, double enginePower, Color color, String modelName, double centerPointx, double centerPointy, double direction) {
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
        this.stopEngine();
        this.centerPointx = centerPointx;
        this.centerPointy = centerPointy;
        this.direction = direction;
    }

    public int getNrDoors() {
        return nrDoors;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public Color getColor() {
        return color;
    }

    public double getCenterPointx() {
        return centerPointx;
    }

    public String getGas_error_message() {
        return gas_error_message;
    }

    public String getBrake_error_message() {
        return brake_error_message;
    }

    public double getCenterPointy() {
        return centerPointy;
    }

    public String getModelName() {
        return modelName;
    }

    public double getDirection() {
        return direction;
    }

    public void setColor(Color clr) {
        color = clr;
    }

    public void setgas_error_message() {
        gas_error_message = "Please provide a value between 0 and 1";
    }

    public void setbrake_error_message() {
        brake_error_message = "Please provide a value between 0 and 1";
    }

    public void startEngine() {
        currentSpeed = 0.1;
    }

    public void stopEngine() {
        currentSpeed = 0;
    }

    public void move() {

        double distance = currentSpeed * 1; //1 är tidsenheten.

        if (0 <= direction && direction < PI/2) {
            centerPointx = centerPointx + cos(direction) * distance;
            centerPointy = centerPointy + sin(direction) * distance;
            System.out.println("x " + centerPointx);
            System.out.println("y " + centerPointy);
        }
        else if (PI/2 <= direction && direction < PI) {
            centerPointx = centerPointx - sin(direction - PI / 2) * distance;
            centerPointy = centerPointy + cos(direction - PI / 2) * distance;
            System.out.println("x " + centerPointx);
            System.out.println("y " + centerPointy);
        }
        else if (PI <= direction && direction < (3*PI)/2) {
            centerPointx = centerPointx - cos(direction - PI) * distance;
            centerPointy = centerPointy - sin(direction - PI) * distance;
            System.out.println("x " + centerPointx);
            System.out.println("y " + centerPointy);
        }
        else {
            centerPointx = centerPointx + sin(direction - (3*PI)/2) * distance;
            centerPointy = centerPointy - cos(direction - (3*PI)/2) * distance;
            System.out.println("x " + centerPointx);
            System.out.println("y " + centerPointy);
        }

    }

    public void turnLeft() {
        direction = direction + 1;
        System.out.println("turnsleft" + direction);
    }

    public void turnRight() {
        direction = direction - 1;
        System.out.println("turnright" + direction);
    }

    public abstract double speedFactor();

    public void gas(double amount) {
        if (currentSpeed > enginePower) currentSpeed = enginePower;
        if (currentSpeed < 0) currentSpeed = 0;
        if (0 <= amount && amount < 1) {
            incrementSpeed(amount);
        } else {
            setgas_error_message();
            System.out.println(gas_error_message);
        }
    }
    public void brake(double amount) {
        if (currentSpeed > enginePower) currentSpeed = enginePower;
        if (currentSpeed < 0) currentSpeed = 0;
        if (0 <= amount && amount < 1) {
            decrementSpeed(amount);
        } else {
            setbrake_error_message();
            System.out.println(brake_error_message);
        }
    }

    public void incrementSpeed(double amount){
        currentSpeed =  Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    public void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

}

