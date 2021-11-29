import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class Volvo240test {


    @Test
    public void Error() {
        Volvo240 car = new Volvo240();
        car.gas(1.5);
        assertEquals("Please provide a value between 0 and 1", car.getGas_error_message());
        car.brake(1.5);
        assertEquals("Please provide a value between 0 and 1", car.getBrake_error_message());
    }
    @Test
    public void Volvo240_driving () {
        Volvo240 car = new Volvo240();
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
    public void Volvo240_setter_test () {
        Volvo240 car = new Volvo240();

        car.setCenterPointx(60);
        double positionX = car.getCenterPointx();
        assertEquals(60, positionX);

        car.setCenterPointy(60);
        double positionY = car.getCenterPointy();
        assertEquals(60, positionY);

        car.setCurrentSpeed(100);
        double speed = car.getCurrentSpeed();
        assertEquals(100, speed);

        car.setDirection(3);
        double direction_angle = car.getDirection();
        assertEquals(3, direction_angle);
    }
    @Test
    public void Volvo240_getter_test() {
        Volvo240 car = new Volvo240();
        int NrDoors = car.getNrDoors();
        assertEquals(4, NrDoors, 0);

        Color color = car.getColor();
        assertTrue(Color.black == color);

        double CurrentSpeed = car.getCurrentSpeed();
        assertEquals(0, CurrentSpeed);

        double EnginePower = car.getEnginePower();
        assertEquals(100, EnginePower);

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
        assertSame("Volvo240", modelname);

        car.setColor(Color.black);
        Color clr = car.getColor();
        assertEquals(Color.black, clr);
    }
    @Test
    public void Volvo240_speed_behavior () {
        Volvo240 car = new Volvo240();

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
    public void Volvo240_setup () {
        Volvo240 car = new Volvo240();

        car.startEngine();
        assertEquals(0.1, car.getCurrentSpeed());

        car.stopEngine();
        assertEquals(0, car.getCurrentSpeed());
    }
}