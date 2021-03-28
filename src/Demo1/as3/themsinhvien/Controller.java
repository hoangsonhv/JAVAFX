package Demo1.as3.themsinhvien;

import Demo1.as3.Main;
import Demo1.as3.SinhVien;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.lang.reflect.Executable;
import java.sql.*;

import java.io.*;
import java.util.ArrayList;

public class Controller{
    public String name;
    public int age;
    public int mark;
    public TextField txtname;
    public TextField txtage;
    public TextField txtmark;
    public Text txtValidate;
    public final static String connectString = "jdbc:mysql://localhost:3306/t2008m";
    public final static String user = "root";
    public final static String password = "";

    public void add() throws ClassNotFoundException, SQLException{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(connectString,user,password);
            String n = txtname.getText();
            int a = Integer.parseInt(txtage.getText());
            int m = Integer.parseInt(txtmark.getText());
            String sql = "INSERT INTO sinhvien (name, age, mark) VALUES (?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, n);
            statement.setInt(2, a);
            statement.setInt(3, m);
            int rowsCreate = statement.executeUpdate();
            if (rowsCreate > 0) {
                txtValidate.setText("Thêm thành công.!");
                txtValidate.setDisable(false);

                Parent root = FXMLLoader.load(getClass().getResource("../danhsach/DanhSachSV.fxml"));
                Main.mainStage.setScene(new Scene(root,600,400));
            }
        }catch (Exception e){
            txtValidate.setText("Vui lòng nhập đầy đủ thông tin");
            txtValidate.setDisable(false);
        }
    }

    public void trove() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../home/Menu.fxml"));
        Main.mainStage.setTitle("Menu");
        Main.mainStage.setScene(new Scene(root, 600, 400));
    }
}
