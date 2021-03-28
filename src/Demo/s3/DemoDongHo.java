package Demo.s3;

public class DemoDongHo {
    public static void main(String [] args){
        DongHo dh = new DongHo();
        Thread t = new Thread(dh);
        t.start();

        int x= 10;
        Runnable r = new Runnable() {
            @Override
            public void run() {
                for (int i = 0;i<20;i++){
                    System.out.println("i2 = "+i);
                    try{
                        Thread.sleep(1000);
                    }catch (Exception e){}
                }
            }
        };
        Thread t2 = new Thread(r);
        t2.start();
    }
}
