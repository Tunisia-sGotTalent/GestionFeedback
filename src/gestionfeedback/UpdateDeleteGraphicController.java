package gestionfeedback;

import com.tgt.Entite.feedback;
import com.tgt.Utils.DataBase;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class UpdateDeleteGraphicController implements Initializable {

    @FXML
    private TextField idF;
    @FXML
    private TextField noteF;
    @FXML
    private TextField commentaireF;
    @FXML
    private TextField dateF;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void getFeedback(ActionEvent event) {
    }

    @FXML
    private void deletefeedback(ActionEvent event) {
    }

    @FXML
    private void updateFeedback(ActionEvent event) {
        String sid = idF.getText();
        int id = Integer.parseInt(sid);
        String txtnote = noteF.getText();
        int Nnote = Integer.parseInt(txtnote);
        String txtcommentaireF = commentaireF.getText();
        String txtdateF = dateF.getText();
        feedback fdbck = new feedback(id, Nnote, txtdateF, txtcommentaireF);
        fdbck.setId_feedback(id);
        fdbck.setNote_feedback(Nnote);
        fdbck.setCommentaire_feedback(txtcommentaireF);
        fdbck.setDate_feedback(txtdateF);
        int status = DataBase.update(fdbck);
    }

}
