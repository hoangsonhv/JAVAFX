package sample.as3.suasinhvien;

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
import sample.as2.Student1;
import sample.as3.Main;
import sample.as3.SinhVien;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{
    public TextField txtname;
    public TextField txtage;
    public TextField txtmark;
    public Text txtValidate;
    public Button btnSort;
    public TableView<SinhVien> danhsach;
    public TableColumn<SinhVien,String> nameSV;
    public TableColumn<SinhVien,Integer> ageSV;
    public TableColumn<SinhVien,Integer> markSV;

    public static SinhVien editSV;
    ObservableList<SinhVien> ds = FXCollections.observableArrayList();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nameSV.setCellValueFactory(new PropertyValueFactory<SinhVien,String>("name"));
        ageSV.setCellValueFactory(new PropertyValueFactory<SinhVien,Integer>("age"));
        markSV.setCellValueFactory(new PropertyValueFactory<SinhVien,Integer>("mark"));


        try {
            FileInputStream fis = new FileInputStream("sinhvien.bin");
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
            danhsach.setItems(ds);
        }catch (IOException io){
            System.out.println("ERROR");
        }
    }

    public void input() {
        try {
            String n = txtname.getText();
            int a = Integer.parseInt(txtage.getText());
            int m = Integer.parseInt(txtmark.getText());
            if(!n.isEmpty()){
                if(editSV != null){
                    editSV.setName(n);
                    editSV.setAge(a);
                    editSV.setMark(m);
                    for(SinhVien s:ds){
                        if(s.getName()== editSV.getName()){
                            s = editSV;
                            break;
                        }
                    }
                    danhsach.refresh();
                }else {
                    SinhVien s = new SinhVien(n,a,m);
                    ds.add(s);
                    danhsach.setItems(ds);
                }
                editSV = null;
                txtValidate.setText("");
                txtname.setText("");
                txtage.setText("");
                txtmark.setText("");

            }else {
                txtValidate.setText("Vui lòng nhập tên, tuổi và điểm thi");
                txtValidate.setDisable(false);
            }
        }catch (Exception e){
            txtValidate.setText("Vui lòng nhập tên, tuổi và điểm thi");
            txtValidate.setDisable(false);
        }
    }


    public void edit(){
        SinhVien s = danhsach.getSelectionModel().getSelectedItem();
        txtname.setText(s.getName());
        txtage.setText(s.getAge().toString());
        txtmark.setText(s.getMark().toString());
        editSV = s;
    }

    public void trove() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../home/Menu.fxml"));
        Main.mainStage.setTitle("Menu");
        Main.mainStage.setScene(new Scene(root, 600, 400));
    }
}
