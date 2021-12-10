import cars.Car;
import cars.Saab95;
import cars.Volvo240;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Workshoptest {
    @Test
    public void workshoptests(){
        Workshop<Volvo240> workshop1 = new Workshop<>(4);
        Workshop<Car> workshop2 = new Workshop<>(4);
        Workshop<Car> workshop3 = new Workshop<>(1);
        Volvo240 car1 = new Volvo240();
        Volvo240 car2 = new Volvo240();
        Saab95 car3 = new Saab95();
        Saab95 car4 = new Saab95();

        workshop1.receiveCar(car1);
        assertEquals(1, workshop1.getCars_in_shop().size());
        workshop1.retrieveCar(car1);
        assertEquals(0,workshop1.getCars_in_shop().size());
        workshop2.receiveCar(car1);
        workshop2.receiveCar(car2);
        workshop2.receiveCar(car3);
        workshop2.receiveCar(car4);
        workshop2.retrieveCar(car3);
        assertFalse(workshop2.getCars_in_shop().contains(car3));

        workshop3.receiveCar(car1);
        workshop3.receiveCar(car2);
        assertEquals(1, workshop3.getCars_in_shop().size());
    }
}

