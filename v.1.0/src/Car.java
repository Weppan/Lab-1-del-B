import java.awt.*; // ML. Is this needed?

import static java.lang.Math.*;

/** A template for a car.
 * @author madel
 * */
public abstract class Car implements Movable{

    private final int nrDoors; // Number of doors on the car
    private final double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private final String modelName; // The car model name
    private double weight;
    private double centerPointx; // Position x coordinate
    private double centerPointy; // Position y coordinate
    private double direction; // Angle
    private String gas_error_message;
    private String brake_error_message;

    /** Creates a car.*/
    public Car(int nrDoors, double enginePower, Color color, String modelName, double weight, double centerPointx, double centerPointy, double direction) {
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
        this.weight = weight;
        this.stopEngine();
        this.centerPointx = centerPointx;
        this.centerPointy = centerPointy;
        this.direction = direction;
    }

    /** Gets the number of doors of a car
     * @return int nrDoors
     * */
    public int getNrDoors() {
        return nrDoors;
    }

    /** Gets the engine power of a car
     * @return double enginePower
     * */
    public double getEnginePower() {
        return enginePower;
    }

    /** Gets the current speed of a car
     * @return double currentSpeed
     * */
    public double getCurrentSpeed() {
        return currentSpeed;
    }

    /** Gets the color of a car
     * @return Color
     * */
    public Color getColor() {
        return color;
    }

    /** Gets the center point (x direction) of a car
     * @return double centerPointx
     * */
    public double getCenterPointx() {
        return centerPointx;
    }

    /** Gets the gas error message of a car
     * @return String gas_error_message
     * */
    public String getGas_error_message() {
        return gas_error_message;
    }

    /** Gets the brake error message of a car
     * @return String brake_error_message
     * */
    public String getBrake_error_message() {
        return brake_error_message;
    }

    /** Gets the center point (y direction) of a car
     * @return double centerPointy
     * */
    public double getCenterPointy() {
        return centerPointy;
    }

    /** Gets the weight of a car
     * @return double weight
     * */
    public double getWeight() {
        return weight;
    }

    /** Sets the weight of a car
     * @param weight the weight of a car
     * */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /** Gets the model name of a car
     * @return String modelName
     * */
    public String getModelName() {
        return modelName;
    }

    /** Gets the direction (angle) of a car
     * @return double direction (angle)
     * */
    public double getDirection() {
        return direction;
    }

    /** Sets the current speed of a car
     * @param currentSpeed the current speed of a car
     * */
    public void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    /** Sets the color of a car
     * @param clr the color of a car
     * */
    public void setColor(Color clr) {
        color = clr;
    }

    /** Sets the gas error message of a car*/
    public void setgas_error_message() {
        gas_error_message = "Please provide a value between 0 and 1";
    }

    /** Sets the brake error message of a car*/
    public void setbrake_error_message() {
        brake_error_message = "Please provide a value between 0 and 1";
    }

    /** Starts the engine of a car*/
    public void startEngine() {
        currentSpeed = 0.1;
    }

    /** Stops the engine of a car*/
    public void stopEngine() {
        currentSpeed = 0;
    }

    /** Sets the center point (x direction) of a car
     * @param centerPointx the center point in x direction of a car
     * */
    public void setCenterPointx(double centerPointx) {
        this.centerPointx = centerPointx;
    }

    /** Sets the center point (y direction) of a car
     * @param centerPointy the center point in y direction of a car
     * */
    public void setCenterPointy(double centerPointy) {
        this.centerPointy = centerPointy;
    }

    /** Sets the direction (angle) of a car
     * @param direction the angle of a car
     * */
    public void setDirection(double direction) {
        this.direction = direction;
    }

    /** Moves a car*/
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

    /** Turns a car left. */
    public void turnLeft() {
        direction = direction + 1;
        System.out.println("turnsleft" + direction);
    }

    /** Turns a car right. */
    public void turnRight() {
        direction = direction - 1;
        System.out.println("turnright" + direction);
    }

    /** Calculates the speed factor. */
    public abstract double speedFactor();

    /** Gases a car.
     * @param amount
     * */
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

    /** Brakes a car.
     * @param amount
     * */
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

    /** Increments the speed of a car.
     * @param amount
     * */
    public void incrementSpeed(double amount){
        currentSpeed =  Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    /** Decrements the speed of a car.
     * @param amount
     * */
    public void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

}

