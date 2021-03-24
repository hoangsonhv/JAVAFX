package sample.as3.home;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import sample.as3.Main;

public class Menu {

    public  void danhSachSV() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../danhsach/DanhSachSV.fxml"));
        Main.mainStage.setTitle("Danh Sách Sinh Viên");
        Main.mainStage.setScene(new Scene(root,600,400));
    }

    public void capNhatSV() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../themsinhvien/ThemSV.fxml"));
        Main.mainStage.setTitle("Thêm Sinh Viên");
        Main.mainStage.setScene(new Scene(root, 600, 400));;
    }

    public void suaTTSV() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../suasinhvien/SuaSV.fxml"));
        Main.mainStage.setTitle("Thêm Sinh Viên");
        Main.mainStage.setScene(new Scene(root, 600, 400));
    }
}
