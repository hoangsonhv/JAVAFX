package Demo.s4;

public class DemoWait {
    public static void main(String [] args){
        Amount a = new Amount();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                a.ruttien(20000);
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                a.naptien(40000);
            }
        });
        t1.start();
        t2.start();
    }
}
