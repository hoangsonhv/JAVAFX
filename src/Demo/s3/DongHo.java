package Demo.s3;

public class DongHo implements Runnable {
    @Override
    public void run() {
        for (int i = 0;i<20;i++){
            System.out.println("i = "+i);
            try{
                Thread.sleep(1000);
            }catch (Exception e){}
        }
    }

    public void startTimer(){
        int min = 10;
        int sec = 0;

        Thread th = new Thread();
        for (int i = 0;i<20;i++){
            System.out.println("i = "+i);
            try{
                Thread.sleep(1000);
            }catch (Exception e){}
        }
    }

}
