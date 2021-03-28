package sample.as2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.text.Text;
import javafx.util.converter.IntegerStringConverter;


import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.ResourceBundle;

import java.net.URL;
import java.util.Collections;
import java.util.Comparator;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public TextField name;
    public TextField age;
    public TextField mark;
    public Text txtValidate;
    public Button btnSort;
    public TableView<Student1> ds;
    public TableColumn<Student1,String> ten;
    public TableColumn<Student1,Integer> tuoi;
    public TableColumn<Student1,Integer> diem;
    public static Integer identity = 0;
    public static Student1 editSinhVien;


    static boolean change = true;
    ObservableList<Student1> dsSV = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ten.setCellValueFactory(new PropertyValueFactory<Student1,String>("name"));
        tuoi.setCellValueFactory(new PropertyValueFactory<Student1,Integer>("age"));
        diem.setCellValueFactory(new PropertyValueFactory<Student1,Integer>("mark"));

        ds.setItems(dsSV);
    }

    public void input() {
        try {
            String n = name.getText();
            int a = Integer.parseInt(age.getText());
            int m = Integer.parseInt(mark.getText());
            if(!n.isEmpty()){
                if(editSinhVien != null){
                    editSinhVien.setName(n);
                    editSinhVien.setAge(a);
                    editSinhVien.setMark(m);
                    for(Student1 s:dsSV){
                        if(s.getId()== editSinhVien.getId()){
                            s = editSinhVien;
                            break;
                        }
                    }
                    ds.refresh();
                }else {
                    identity++;
                    Student1 s = new Student1(identity,n,a,m);
                    dsSV.add(s);
                    ds.setItems(dsSV);
                }
                editSinhVien = null;
                txtValidate.setText("");
                name.setText("");
                age.setText("");
                mark.setText("");

            }else {
                txtValidate.setText("Vui lòng nhập tên, tuổi và điểm thi");
                txtValidate.setDisable(false);
            }
        }catch (Exception e){
            txtValidate.setText("Vui lòng nhập tên, tuổi và điểm thi");
            txtValidate.setDisable(false);
        }
    }

    public void sort(){
        change = !change;
        if (change){
            Collections.sort(dsSV, new Comparator<Student1>() {
                @Override
                public int compare(Student1 o1, Student1 o2) {
                    return o1.getMark() - o2.getMark();
                }
            });
        }else {
            Collections.sort(dsSV, new Comparator<Student1>() {
                @Override
                public int compare(Student1 o1, Student1 o2) {
                    return o2.getMark() - o1.getMark();
                }
            });
        }
        String txt = "";
        for(Student1 st:dsSV){
            txt+= st.getName()+"--"+st.getAge()+"--"+st.getMark()+"\n";
        }
    }

    public void edit(){
//        ten.setCellFactory(TextFieldTableCell.forTableColumn());
//        ten.setOnEditCommit(e ->{
//            e.getTableView().getItems().get(e.getTablePosition().getRow()).setName(e.getNewValue());
//        });
//
//        tuoi.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
//        tuoi.setOnEditCommit(e ->{
//            e.getTableView().getItems().get(e.getTablePosition().getRow()).setAge(e.getNewValue());
//        });
//
//        diem.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
//        diem.setOnEditCommit(e ->{
//            e.getTableView().getItems().get(e.getTablePosition().getRow()).setMark(e.getNewValue());
//        });
//
//        ds.setEditable(true);

        Student1 s = ds.getSelectionModel().getSelectedItem();
        name.setText(s.getName());
        age.setText(s.getAge().toString());
        mark.setText(s.getMark().toString());
        editSinhVien = s;
    }

}
