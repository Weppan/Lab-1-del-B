import java.util.ArrayList;

public class Workshop <T extends Car>{


    private ArrayList<T> cars_in_shop;
    int capacity;



    Workshop(int capacity) {

        this.capacity = capacity;
        cars_in_shop = new ArrayList<>();

    }

    public void recieveCar(T car){
        if(cars_in_shop.size()< capacity)   //Funkar (int)??
            cars_in_shop.add(car);
        System.out.println(cars_in_shop);
    }

//    public void retrieveCar(T car){
//        if(cars_in_shop.size()>0)
//            for(int i=0;i<cars_in_shop.size(); i++){
//                if (cars_in_shop.get(i) == car){
//                    cars_in_shop.remove(car);
//                }
//                System.out.println(cars_in_shop);
//            }
//    }
}