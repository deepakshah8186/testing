package mac;

public class Singleton {

    private static Singleton singleton = null;

    private Singleton() {
    }

    public static Singleton  getInstance(){
        if(singleton == null){
            return null;
        }
        return new Singleton();
    }
    public void showMessage(){
        System.out.println("Please show message::");
    }

//    public static void main(String[] args)
//    {
//        Singleton singleton1 = Singleton.getInstance();
//        Singleton singleton2 = Singleton.getInstance();
//        if(singleton1 == singleton2){
//            System.out.println("Both the instances are the same");
//        }
//    }
}
