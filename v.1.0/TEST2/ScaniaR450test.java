import cars.ScaniaR450;
import cars.Truck;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ScaniaR450test {
    @Test
    public void Ramp_tests(){
        ScaniaR450 truck = new ScaniaR450();

        truck.decidePlatformAngle(10);
        assertEquals(10,truck.getPlatformAngle());

        truck.decidePlatformAngle(120);
        assertEquals(70,truck.getPlatformAngle());

        truck.decidePlatformAngle(-30);
        assertEquals(0,truck.getPlatformAngle());

//        double initial_angle = truck.getGetPlatformAngle();
//        truck.setPlatformAngle();
//        assertTrue(truck.getGetPlatformAngle()>initial_angle);
//
//        double initial_angle2 = truck.getGetPlatformAngle();
//        truck.lower();
//        assertTrue(truck.getGetPlatformAngle()<initial_angle2);
//
//        truck.setGetPlatformAngle(-10);
//        truck.lower();
//        assertEquals(0,truck.getGetPlatformAngle());
//
//        truck.setGetPlatformAngle(80);
//        truck.setPlatformAngle();
//        assertEquals(70,truck.getGetPlatformAngle());
//
//        truck.setCurrentSpeed(50);
//        truck.lower();
//        assertEquals("Must be stationary", truck.getPlfrmErrorMsg());
//
//        truck.setCurrentSpeed(30);
//        truck.setPlatformAngle();
//        assertEquals("Must be stationary",truck.getPlfrmErrorMsg());
    }
    @Test
    public void gas_tests(){
        Truck truck = new ScaniaR450();

        truck.gas(1.5);
        assertEquals("Please provide a value between 0 and 1", truck.getGas_error_message());

        truck.setPlatformAngle(0);
        double initial_speed = truck.getCurrentSpeed();
        truck.gas(0.9);
        double current_speed = truck.getCurrentSpeed();
        assertTrue(initial_speed<current_speed);

        truck.setCurrentSpeed(0);
        truck.setPlatformAngle(30); // testa med Retarder för att testa allt -30
        double initial_speed2 = truck.getCurrentSpeed();
        truck.gas(0.9);
        double current_speed2 = truck.getCurrentSpeed();
        assertEquals(initial_speed2, current_speed2);
    }

    @Test
    public void Getter_test(){
        Truck truck = new ScaniaR450();

        truck.setPlfrmToHighGasErrorMsg();
        String errorToHighMsg = truck.getPlfrmToHighGasErrorMsg();
        assertEquals("Platform must be lowered",errorToHighMsg);

        truck.setPlfrmToLowGasErrorMsg();
        String errorToLowMsg = truck.getPlfrmToLowGasErrorMsg();
        assertEquals("Platform must be raised", errorToLowMsg);

        double PltFrmAngle = truck.getPlatformAngle();
        assertEquals(0,PltFrmAngle);

        truck.setPlfrmErrorMsg();
        String error_msg_plf = truck.getPlfrmErrorMsg();
        assertEquals("Must be stationary",error_msg_plf);
    }

    @Test
    public void Setter_test(){
        Truck truck = new ScaniaR450();

        truck.setPlfrmToHighGasErrorMsg();
        assertEquals("Platform must be lowered",truck.getPlfrmToHighGasErrorMsg());

        truck.setPlfrmToLowGasErrorMsg();
        assertEquals("Platform must be raised",truck.getPlfrmToLowGasErrorMsg());

        truck.setPlatformAngle(10);
        assertEquals(10,truck.getPlatformAngle());

        truck.setPlfrmErrorMsg();
        assertEquals("Must be stationary", truck.getPlfrmErrorMsg());
    }

    @Test
    public void Speedfactor_test(){
        Truck truck = new ScaniaR450();

        double speedfactor = truck.speedFactor();
        assertEquals(1, speedfactor);
    }
}
