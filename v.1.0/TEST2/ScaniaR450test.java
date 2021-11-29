import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.awt.*;
import static org.junit.jupiter.api.Assertions.*;

public class ScaniaR450test {
    @Test
    public void Ramp_tests(){
        Truck truck = new ScaniaR450();
        double initial_angle = truck.getPlatformAngle();
        truck.raise();
        assertTrue(truck.getPlatformAngle()>initial_angle);

        double initial_angle2 = truck.getPlatformAngle();
        truck.lower();
        assertTrue(truck.getPlatformAngle()<initial_angle2);

        truck.setPlatformAngle(-10);
        truck.lower();
        assertEquals(0,truck.getPlatformAngle());

        truck.setPlatformAngle(80);
        truck.raise();
        assertEquals(70,truck.getPlatformAngle());

        truck.setCurrentSpeed(50);
        truck.lower();
        assertEquals("Must be stationary", truck.getPlfrmErrorMsg());

        truck.setCurrentSpeed(30);
        truck.raise();
        assertEquals("Must be stationary",truck.getPlfrmErrorMsg());
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
