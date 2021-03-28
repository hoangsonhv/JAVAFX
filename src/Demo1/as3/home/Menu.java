package Demo1.as3.home;

import Demo1.as3.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

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
        Main.mainStage.setTitle("Cập Nhật Sinh Viên");
        Main.mainStage.setScene(new Scene(root, 600, 400));
    }

    public void xoaSV() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../xoasinhvien/xoasinhvien.fxml"));
        Main.mainStage.setTitle("Xóa Sinh Viên");
        Main.mainStage.setScene(new Scene(root, 600, 400));
    }
}
