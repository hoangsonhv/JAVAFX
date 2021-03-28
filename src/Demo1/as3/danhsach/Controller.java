package Demo1.as3.danhsach;

import Demo1.as3.Main;
import Demo1.as3.SinhVien;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    public TableView<SinhVien> danhsach;
    public TableColumn<SinhVien,Integer>idSV;
    public TableColumn<SinhVien,String> nameSV;
    public TableColumn<SinhVien,Integer>ageSV;
    public TableColumn<SinhVien,Integer>markSV;
    public final static String connectString = "jdbc:mysql://localhost:3306/t2008m";
    public final static String user = "root";
    public final static String password = "";

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        idSV.setCellValueFactory(new PropertyValueFactory<SinhVien,Integer>("id"));
        nameSV.setCellValueFactory(new PropertyValueFactory<SinhVien,String>("name"));
        ageSV.setCellValueFactory(new PropertyValueFactory<SinhVien,Integer>("age"));
        markSV.setCellValueFactory(new PropertyValueFactory<SinhVien,Integer>("mark"));


        ObservableList<SinhVien> ds = FXCollections.observableArrayList();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(connectString,user,password);
            Statement stt = conn.createStatement();
            String txt_sql  = "select * from SinhVien";

            ResultSet rs = stt.executeQuery(txt_sql);
            while (rs.next()){
                int id = rs.getInt("ID");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                int mark = rs.getInt("mark");
                SinhVien sv = new SinhVien(id,name,age,mark);
                ds.add(sv);
            }
            danhsach.setItems(ds);
        }catch (ClassNotFoundException e){
            System.out.println("Class Not Found");
        }catch (SQLException e){
            System.out.println("SQL ERROR");
        }
    }

    public void trove() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../home/Menu.fxml"));
        Main.mainStage.setTitle("Menu");
        Main.mainStage.setScene(new Scene(root, 600, 400));
    }
}
