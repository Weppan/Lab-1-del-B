package cars;

public class CarFactory {


        public static Car makeVolvo240(){
            return new Volvo240();
        }
        public static Car makeSaab95() {
            return new Saab95(); }
        public static Car makeScaniaR450() { return new ScaniaR450(); }
    public static Car makeRetarderP400() { return new RetarderP400(); }


}




