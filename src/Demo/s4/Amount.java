package Demo.s4;

public class Amount {
    int balance;

    public synchronized void naptien(int amount){
        balance +=amount;
        System.out.println("Nap "+amount+" Thanh cong");
        try {
            notify();
        }catch (Exception e){}
    }

    public synchronized void ruttien(int amount){
        if (balance<amount){
            System.out.println("Khong du tien tai khoan...");
            try {
                wait();
            }catch (Exception e){}
        }
        balance -= amount;
        System.out.println("Rut "+amount+" Thanh cong.!");
    }
}
