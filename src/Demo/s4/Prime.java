package Demo.s4;

public class Prime {
    int x= 1;
    int y = 1;
    int z = 0;

    public void tangXY(){
        x++;
        y++;

    }

    public void ketQua(){
        System.out.println(Thread.currentThread().getName()+"--");
        System.out.println("X = "+x);
        System.out.println("Y = "+y);
    }

    public synchronized void thaydoiXY(){
        tangXY();
        ketQua();
    }

    public synchronized void tangZ(){
        z++;
        System.out.println(Thread.currentThread().getName()+"--");
        System.out.println("Z = "+z);
    }
}
