package Demo.s4;

public class Main {
    public static void main(String [] args){
        Prime p = new Prime();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i =0;i<20;i++){
                    p.thaydoiXY();
//                    System.out.println("T1 i ="+i);
//                    synchronized (p){
//                        p.tangXY();
//                        p.ketQua();
//                    }
                    try {
                        Thread.sleep(1000);
                    }catch (Exception e){}
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i =0;i<50;i++){
                    p.thaydoiXY();
//                    System.out.println("T2 i ="+i);
//                    synchronized (p){
//                        p.tangXY();
//                        p.ketQua();
//                    }
                    try {
                        Thread.sleep(1000);
                    }catch (Exception e){}
                }
            }
        });
//        Thread t3 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i =0;i<10;i++){
////                    System.out.println("T3 i ="+i);
//                    p.tangXY();
//                    p.ketQua();
//                    try {
//                        Thread.sleep(1000);
//                    }catch (Exception e){}
//                }
//            }
//        });
        t1.start();
//        t2.setDaemon(true);
//        try {
//            t1.join();
//        }catch (Exception e){}
        t2.start();
//        t3.start();
    }
}
