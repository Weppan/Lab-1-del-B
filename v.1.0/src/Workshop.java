import java.util.ArrayList;

public class Workshop <T extends Car, V>{
    T obj;
    V obj2;
    private ArrayList<T> cars_in_shop;
    int capacity;

    Workshop(T obj, V obj2, int capacity) {
        this.obj = obj;
        this.obj2 = obj2;
        this.capacity = capacity;
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