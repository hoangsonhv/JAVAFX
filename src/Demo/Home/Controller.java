package Demo.Home;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Controller {
    public void screenDS() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Main.mainStage.setTitle("Danh sách sinh viên");
        Main.mainStage.setScene(new Scene(root, 850, 450));
        Main.mainStage.show();
    }
    public void themSV() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("ThemSV.fxml"));
        Main.mainStage.setTitle("Thêm Sinh Viên");
        Main.mainStage.setScene(new Scene(root, 650, 450));
        Main.mainStage.show();
    }
    public void trove() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Home1.fxml"));
        Main.mainStage.setTitle("...");
        Main.mainStage.setScene(new Scene(root, 650, 450));
        Main.mainStage.show();
    }
}
