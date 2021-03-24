package manager.student.danhsach;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import manager.student.Main;
import manager.student.model.SinhVien;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public TableView<SinhVien> tbview;
    public TableColumn<SinhVien,String > namesv;
    public TableColumn<SinhVien,Integer > agesv;
    public TableColumn<SinhVien,Integer > marksv;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        namesv.setCellValueFactory(new PropertyValueFactory<SinhVien,String>("name"));
        agesv.setCellValueFactory(new PropertyValueFactory<SinhVien,Integer>("age"));
        marksv.setCellValueFactory(new PropertyValueFactory<SinhVien,Integer>("mark"));
        //tao sanh sach
        ObservableList<SinhVien> ds = FXCollections.observableArrayList();
        //lay sinh vien tu file student de nap vao danh sach
        try {
            FileInputStream fis = new FileInputStream("student.bin");
            DataInputStream dis = new DataInputStream(fis);
            int line = 0;
            String txt = dis.readLine();
            String [] str = new String[3];
            while (txt!=null){
                str[line] = txt;
                line++;
                txt = dis.readLine();
                if (line>=3){
                    SinhVien sv = new SinhVien(str[0],Integer.parseInt(str[1]),Integer.parseInt(str[2]));
                    ds.add(sv);
                    line = 0;
                }
            }
            tbview.setItems(ds);
        }catch (IOException io){
            System.out.println("ERROR");
        }
    }

    public void trangchu() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../home/home.fxml"));
        Main.mainStage.setScene(new Scene(root,600,400));
    }
}
