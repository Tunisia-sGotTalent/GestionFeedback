package testlogin;

import com.jfoenix.controls.JFXTextField;
import com.tgt.Entite.Centre;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

public class GestionCentreController implements Initializable {

    @FXML
    private JFXTextField tnom1;
    @FXML
    private TableColumn<Centre, String> col_nom;

    @FXML
    private TableView<?> Table_Centre;

    @FXML
    private TableColumn<?, ?> col_adresse;

    @FXML
    private TableColumn<?, ?> col_domaine;

    @FXML
    private TableColumn<?, ?> col_mail;

    @FXML
    private TableColumn<?, ?> col_numero;
    @FXML
    private TableColumn<?, ?> col_image;

    public void setTnom1(JFXTextField tnom1) {
        this.tnom1.setText(tnom1.getText());
    }

    public JFXTextField getTnom1() {
        return tnom1;
    }

    @FXML
    void connexionAction(ActionEvent event) {

    }

    @FXML
    void gestionCentreAction(ActionEvent event) {

    }

    @FXML

    void retour(MouseEvent event) {

        try {
            //   try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PageAccueilAdministrateur.fxml"));

            Parent root = (Parent) fxmlLoader.load();
            PageAccueilAdministrateurController apc = fxmlLoader.getController();
            apc.setTnom1((JFXTextField) tnom1);

            tnom1.getScene().setRoot(root);
            // stage.setTitle("hello");
            //       stage.setScene(new Scene(root));
            //  stage.show();
        } catch (IOException e) {
            System.out.println("can't load new window");
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void connexionAction(MouseEvent event) {
    }


}
