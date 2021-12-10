import java.util.ArrayList;

/** Creates objects that are workshops.
 * @author madel
 * */
public class Workshop <T>{


    private ArrayList<T> cars_in_shop;
    int capacity;


    /** Creates a workshop.*/
    Workshop(int capacity) {

        this.capacity = capacity;
        cars_in_shop = new ArrayList<>();
    }

    /** Receives a car in the workshop.
     * @param car
     * */
    public void receiveCar(T car){
        if(cars_in_shop.size()< capacity)
            cars_in_shop.add(car);
        System.out.println(cars_in_shop);
    }

    /** Retrieves a car from the workshop.
     * @param car
     * */
    public void retrieveCar(T car){
        if(cars_in_shop.size()>0)
            for(int i=0;i<cars_in_shop.size(); i++){
                if (cars_in_shop.get(i) == car){
                    cars_in_shop.remove(car);
                }
                System.out.println(cars_in_shop);
            }
    }

    /** Get information on what cars are in the workshop.
     * @return ArrayList what cars are in the workshop
     * */
    public ArrayList<T> getCars_in_shop() {
        return cars_in_shop;
    }
}