package sample;

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

    static boolean change = true;
    ObservableList<Student1> dsSV = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ten.setCellValueFactory(new PropertyValueFactory<Student1,String>("name"));
        tuoi.setCellValueFactory(new PropertyValueFactory<Student1,Integer>("age"));
        diem.setCellValueFactory(new PropertyValueFactory<Student1,Integer>("mark"));

        edit();
    }

    public void input() {
        try{
            String n = name.getText();
            Integer a = Integer.parseInt(age.getText());
            Integer m = Integer.parseInt(mark.getText());
            if (!n.isEmpty()) {
                Student1 st = new Student1(n,a,m);
                dsSV.add(st);

                txtValidate.setText("txt");
                name.setText("");
                age.setText("");
                mark.setText("");
                ds.setItems(dsSV);

            } else {
                txtValidate.setText("Vui lòng nhập đầy đủ thông tin..");
                txtValidate.setDisable(false);
            }
        }catch (Exception e){
            txtValidate.setText("Vui lòng nhập đầy đủ thông tin..");
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
        ten.setCellFactory(TextFieldTableCell.forTableColumn());
        ten.setOnEditCommit(e ->{
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setName(e.getNewValue());
        });

        tuoi.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        tuoi.setOnEditCommit(e ->{
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setAge(e.getNewValue());
        });

        diem.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        diem.setOnEditCommit(e ->{
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setMark(e.getNewValue());
        });

        ds.setEditable(true);
    }
}
