import java.util.ArrayList;

public class Repair_Shop <T,V>{
    T obj;
    V obj2;
    private ArrayList<T> cars_in_shop;

        Repair_Shop(T obj, V obj2) {
        this.obj = obj;
        this.obj2 = obj2;
    }

    public void recieveCar(){
        if(cars_in_shop.size()> (int) obj2-1)   //Funkar (int)??
            cars_in_shop.add(obj);
    }

//    public void retrieveCar(){
//        if(cars_in_shop.size()>0)
//            cars_in_shop.remove();
//    }
}
