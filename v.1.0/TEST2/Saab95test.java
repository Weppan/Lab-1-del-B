import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class Saab95test {


    @Test
    public void Error() {
        Saab95 car = new Saab95();
        car.gas(1.5);
        assertEquals("Please provide a value between 0 and 1", car.getGas_error_message());
        car.brake(1.5);
        assertEquals("Please provide a value between 0 and 1", car.getBrake_error_message());
    }
    @Test
    public void Saab95_driving () {
        Saab95 car = new Saab95();
        double old_pos = car.getCenterPointx();
        car.startEngine();
        car.move();
        double output = car.getCenterPointx();
        assertTrue(old_pos != output);


        double test2 = car.getDirection();
        car.turnRight();
        double test3 = car.getDirection();
        assertTrue(test2 > test3);

        double test4 = car.getDirection();
        car.turnLeft();
        double test5 = car.getDirection();
        assertTrue(test4 < test5);

        double initial_speed = car.getCurrentSpeed();
        car.gas(0.9);
        double current_speed = car.getCurrentSpeed();
        assertTrue(initial_speed<current_speed);

        double initial_speed2 = car.getCurrentSpeed();
        car.brake(0.9);
        double current_speed2 = car.getCurrentSpeed();
        assertTrue(current_speed2<initial_speed2);
    }
    @Test
    public void Saab95_getter_test () {
        Saab95 car = new Saab95();
        int NrDoors = car.getNrDoors();
        assertEquals(2, NrDoors, 0);

        Color color = car.getColor();
        assertTrue(Color.red == color);

        double CurrentSpeed = car.getCurrentSpeed();
        assertEquals(0, CurrentSpeed);

        double EnginePower = car.getEnginePower();
        assertEquals(125, EnginePower);

        car.setColor(Color.red);
        Color clr = car.getColor();
        assertEquals(Color.red, clr);

        double centerpointx = car.getCenterPointx();
        assertEquals(0,centerpointx);

        double direction = car.getDirection();
        assertEquals(0,direction);

        String brake_error_message = car.getBrake_error_message();
        assertNull(brake_error_message);

        String gas_error_message = car.getGas_error_message();
        assertNull(gas_error_message);

        double centerpointy = car.getCenterPointy();
        assertEquals(0, centerpointy);

        String modelname = car.getModelName();
        assertSame("Saab95", modelname);
    }
    @Test
    public void Saab95_speed_behavior () {
        Saab95 car = new Saab95();
        double SpeedFactor = car.speedFactor();
        assertEquals(1.25, SpeedFactor);

        car.startEngine();
        double initial_speed = car.getCurrentSpeed();
        car.decrementSpeed(0.9);
        double current_speed = car.getCurrentSpeed();
        assertTrue(current_speed<initial_speed);

        double initial_speed2 = car.getCurrentSpeed();
        car.incrementSpeed(0.9);
        double current_speed2 = car.getCurrentSpeed();
        assertTrue(initial_speed2<current_speed2);
    }
    @Test
    public void Saab95_setup () {
        Saab95 car = new Saab95();

        car.startEngine();
        assertEquals(0.1, car.getCurrentSpeed());

        car.stopEngine();
        assertEquals(0, car.getCurrentSpeed());
    }

    @Test
    public void Saab95_set_turbo () {
        Saab95 car = new Saab95();
        car.setTurboOn();
        boolean on_or_off = car.turboOn;
        assertEquals(true, on_or_off);

        car.setTurboOff();
        boolean off_or_on = car.turboOn;
        assertEquals(false, off_or_on);
    }
}