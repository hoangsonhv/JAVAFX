package Demo1.as3.xoasinhvien;

import java.sql.*;
import Demo1.as3.Main;
import Demo1.as3.SinhVien;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{
    public TextField txtname;
    public TextField txtage;
    public TextField txtmark;
    public TextField txtid;
    public Text txtValidate;
    public Button btnSort;
    public TableView<SinhVien> danhsach1;
    public TableColumn<SinhVien,Integer> idSV;
    public TableColumn<SinhVien,String> nameSV;
    public TableColumn<SinhVien,Integer> ageSV;
    public TableColumn<SinhVien,Integer> markSV;
    public final static String connectString = "jdbc:mysql://localhost:3306/t2008m";
    public final static String user = "root";
    public final static String password = "";

    public static SinhVien editSV;
    ObservableList<SinhVien> ds = FXCollections.observableArrayList();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        idSV.setCellValueFactory(new PropertyValueFactory<SinhVien,Integer>("id"));
        nameSV.setCellValueFactory(new PropertyValueFactory<SinhVien,String>("name"));
        ageSV.setCellValueFactory(new PropertyValueFactory<SinhVien,Integer>("age"));
        markSV.setCellValueFactory(new PropertyValueFactory<SinhVien,Integer>("mark"));

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(connectString,user,password);
            Statement statement = conn.createStatement();
            String txt_sql  = "select * from SinhVien";

            ResultSet rs = statement.executeQuery(txt_sql);
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                int mark = rs.getInt("mark");
                SinhVien sv = new SinhVien(id,name,age,mark);
                ds.add(sv);
            }
            danhsach1.refresh();
            danhsach1.setItems(ds);
        }catch (ClassNotFoundException e){
            System.out.println("Class Not Found");
        }catch (SQLException e){
            System.out.println("SQL ERROR");
        }
    }


    public void delete(){
        try {
            SinhVien s = danhsach1.getSelectionModel().getSelectedItem();
            int i = s.getId();
            Connection conn = DriverManager.getConnection(connectString,user,password);
            String sql = "DELETE FROM sinhvien WHERE id=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, i);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A user was deleted successfully!");
                String txt_sql  = "select * from SinhVien";

                ResultSet rs = statement.executeQuery(txt_sql);
                while (rs.next()){
                    int id = rs.getInt("ID");
                    String name = rs.getString("name");
                    int age = rs.getInt("age");
                    int mark = rs.getInt("mark");
                    SinhVien sv = new SinhVien(id,name,age,mark);
                    ds.add(sv);
                }
                Parent root = FXMLLoader.load(getClass().getResource("../xoasinhvien/xoasinhvien.fxml"));
                Main.mainStage.setScene(new Scene(root,600,400));
            }
        }catch (Exception e) {
            txtValidate.setText("Vui lòng chọn danh mục sửa.!");
            txtValidate.setDisable(false);
        }
    }

    public void trove() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../home/Menu.fxml"));
        Main.mainStage.setTitle("Menu");
        Main.mainStage.setScene(new Scene(root, 600, 400));
    }
}
