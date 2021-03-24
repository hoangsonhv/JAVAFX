package manager.student.home;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import manager.student.Main;

public class Controller {
    public void danhsach() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../danhsach/danhsach.fxml"));
        Main.mainStage.setScene(new Scene(root,600,400));
    }
    public void themmoi() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../themmoi/themmoi.fxml"));
        Main.mainStage.setScene(new Scene(root,600,400));
    }
}
