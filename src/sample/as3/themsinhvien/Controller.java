package sample.as3.themsinhvien;

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
import sample.as3.Main;
import sample.as3.SinhVien;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller{
    public TextField name;
    public TextField age;
    public TextField mark;
    public Text txtValidate;

    public void add(){
        try {
            FileInputStream fis = new FileInputStream("sinhvien.bin");
            DataInputStream dis = new DataInputStream(fis);
            String txt = dis.readLine();
            ArrayList<String > arr = new ArrayList<>();
            while (txt!=null){
                arr.add(txt);
                txt = dis.readLine();
            }

            FileOutputStream fos = new FileOutputStream("sinhvien.bin");
            DataOutputStream dos = new DataOutputStream(fos);
            dos.writeBytes(name.getText()+"\n");
            dos.writeBytes(age.getText()+"\n");
            dos.writeBytes(mark.getText()+"\n");
            for(String  s:arr){
                dos.writeBytes(s+"\n");
            }
            name.setText("");
            age.setText("");
            mark.setText("");
            txtValidate.setText("Thêm thành công.!");
            txtValidate.setDisable(false);

            Parent root = FXMLLoader.load(getClass().getResource("../danhsach/DanhSachSV.fxml"));
            Main.mainStage.setScene(new Scene(root,600,400));
        }catch (IOException e){
            System.out.println("ERROR");
        }
    }

    public void trove() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../home/Menu.fxml"));
        Main.mainStage.setTitle("Menu");
        Main.mainStage.setScene(new Scene(root, 600, 400));
    }
}
