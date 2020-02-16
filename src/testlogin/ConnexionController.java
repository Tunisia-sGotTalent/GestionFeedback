package testlogin;

import com.jfoenix.controls.JFXTextField;
import com.tgt.Entite.Centre;
import com.tgt.Service.ServiceCentre;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;

public class ConnexionController implements Initializable {

    @FXML
    private JFXTextField tnom1;
    @FXML
    private JFXTextField nom_utilisateur;
    @FXML
    private JFXTextField mot_de_passe;

    public void setTnom1(JFXTextField tnom1) {
        this.tnom1.setText(tnom1.getText());
    }

    public JFXTextField getTnom1() {
        return tnom1;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void retour(MouseEvent event) {

        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));

            Parent root = (Parent) fxmlLoader.load();
            FXMLDocumentController apc = fxmlLoader.getController();
            apc.setTnom((JFXTextField) tnom1);

            tnom1.getScene().setRoot(root);

        } catch (IOException e) {
            System.out.println("can't load new window");
        }

    }

    @FXML
    private void connexionAction(ActionEvent event) throws IOException, SQLException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PageAccueilAdministrateur.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        PageAccueilAdministrateurController apc = fxmlLoader.getController();
        apc.setTnom1((JFXTextField) tnom1);
        tnom1.getScene().setRoot(root);
    }

}
