import cars.Car;
import cars.RetarderP400;
import cars.Volvo240;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RetarderP400test {
    @Test
    public void Ramp_tests() {
        RetarderP400 truck = new RetarderP400();
        truck.lower();
        assertEquals(-30, truck.getPlatformAngle());

        truck.raise();
        assertEquals(0, truck.getPlatformAngle());

        truck.setCurrentSpeed(50);
        truck.lower();
        assertEquals("Must be stationary", truck.getPlfrmErrorMsg());

        truck.setCurrentSpeed(30);
        truck.raise();
        assertEquals("Must be stationary",truck.getPlfrmErrorMsg());
    }

    @Test
    public void gas_test() {
        RetarderP400 truck = new RetarderP400();

        truck.gas(1.5);
        assertEquals("Please provide a value between 0 and 1", truck.getGas_error_message());

        truck.setPlatformAngle(0);
        double initial_speed = truck.getCurrentSpeed();
        truck.gas(0.9);
        double current_speed = truck.getCurrentSpeed();
        assertTrue(initial_speed < current_speed);

        truck.setCurrentSpeed(0);
        truck.setPlatformAngle(-30);
        double initial_speed2 = truck.getCurrentSpeed();
        truck.gas(0.9);
        double current_speed2 = truck.getCurrentSpeed();
        assertEquals(initial_speed2, current_speed2);
    }

    @Test
    public void Getter_test(){
        RetarderP400 truck = new RetarderP400();

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

        truck.setLoadErrorMsg();
        String load_error = truck.getLoadErrorMsg();
        assertEquals("Can't load vehicle", load_error);

        truck.setUnloadErrorMsg();
        String unload_error = truck.getUnloadErrorMsg();
        assertEquals("Can't unload vehicle", unload_error);

        //ArrayList<cars.Car> theLoadList = truck.getThe_load(); Hur gör man detta?
        //assertEquals(Collections.EMPTY_LIST,theLoadList);
    }

    @Test
    public void Setter_test(){
        RetarderP400 truck = new RetarderP400();

        truck.setPlfrmToHighGasErrorMsg();
        assertEquals("Platform must be lowered",truck.getPlfrmToHighGasErrorMsg());

        truck.setPlfrmToLowGasErrorMsg();
        assertEquals("Platform must be raised",truck.getPlfrmToLowGasErrorMsg());

        truck.setPlatformAngle(10);
        assertEquals(10,truck.getPlatformAngle());

        truck.setPlfrmErrorMsg();
        assertEquals("Must be stationary", truck.getPlfrmErrorMsg());

        truck.setLoadErrorMsg();
        assertEquals("Can't load vehicle", truck.getLoadErrorMsg());

        truck.setUnloadErrorMsg();
        assertEquals("Can't unload vehicle", truck.getUnloadErrorMsg());
    }

    @Test
    public void Speedfactor_test(){
        RetarderP400 truck = new RetarderP400();

        double speedfactor = truck.speedFactor();
        assertEquals(1, speedfactor);
    }

    @Test
    public void Load_tests(){
        RetarderP400 truck = new RetarderP400();
        Volvo240 car = new Volvo240();
        truck.lower();
        truck.load(car);
        assertFalse(truck.getThe_load().isEmpty());
        assertEquals(truck.getCenterPointy(),car.getCenterPointy());
        assertEquals(truck.getCenterPointx(), car.getCenterPointx());
        assertTrue(car.isLoaded());

        Car last_car = truck.getThe_load().get(truck.getThe_load().size()-1);
        truck.unload();
        assertFalse(last_car.isLoaded());
        assertTrue(truck.getThe_load().isEmpty());
        assertEquals(truck.getCenterPointx(), last_car.getCenterPointx(),10);
        assertEquals(truck.getCenterPointy(), last_car.getCenterPointy(), 10);
    }


    @Test
    public void move_tests(){
        RetarderP400 car = new RetarderP400();

        double old_pos = car.getCenterPointx();
        car.startEngine();
        car.move();
        double output = car.getCenterPointx();
        assertTrue(old_pos != output);

        double old_pos2 = car.getCenterPointx();
        car.setDirection(3);
        car.startEngine();
        car.move();
        double output2 = car.getCenterPointx();
        assertTrue(old_pos2 != output2);

        double old_pos3 = car.getCenterPointx();
        car.setDirection(3.5);
        car.startEngine();
        car.move();
        double output3 = car.getCenterPointx();
        assertTrue(old_pos3 != output3);

        double old_pos4 = car.getCenterPointx();
        car.setDirection(6);
        car.startEngine();
        car.move();
        double output4 = car.getCenterPointx();
        assertTrue(old_pos4 != output4);

        car.setCurrentSpeed(0);
        Volvo240 volvo = new Volvo240();
        car.lower();
        car.load(volvo);
        car.raise();
        car.gas(0.5);
        car.move();
        assertEquals(car.getCenterPointx(), volvo.getCenterPointx());
        assertEquals(car.getCenterPointy(), volvo.getCenterPointy());
    }
}

