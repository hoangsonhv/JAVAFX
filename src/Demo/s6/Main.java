package Demo.s6;
import com.sun.org.apache.bcel.internal.generic.Select;

import java.sql.*;
import java.util.Collections;

public class Main {
    public final static String connectString = "jdbc:mysql://localhost:3306/t2008m";
    public final static String user = "root";
    public final static String password = "";

    public static void main(String [] args){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(connectString,user,password);
            Statement stt = conn.createStatement();
            String txt_sql  = "select * from SinhVien";
//them sinh vien

            String insert_sql = "insert into SinhVien(name,age,mark) values('Trương Quang Huy',19,1)";
            stt.execute(insert_sql);

            //liet ke sinh vien

            ResultSet rs = stt.executeQuery(txt_sql);
            while (rs.next()){
                System.out.println(rs.getInt("id"));
                System.out.println(rs.getString("name"));
                System.out.println(rs.getInt("age"));
                System.out.println(rs.getInt("mark"));
            }

        }catch (ClassNotFoundException e){
            System.out.println("Class Not Found");
        }catch (SQLException e){
            System.out.println("SQL ERROR");
        }
    }
}
