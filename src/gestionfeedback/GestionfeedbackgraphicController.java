package gestionfeedback;

import com.tgt.Entite.feedback;
import com.tgt.Utils.DataBase;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class GestionfeedbackgraphicController implements Initializable {

    @FXML
    private TableView<feedback> table_feedback;
    @FXML
    private TableColumn<feedback, Integer> col_id_feedback;
    @FXML
    private TableColumn<feedback, Integer> col_note_feedback;
    @FXML
    private TableColumn<feedback, String> col_commentaire_feedback;
    @FXML
    private TableColumn<feedback, String> col_date_feedback;

    public ObservableList<feedback> data = FXCollections.observableArrayList();

    public void viewFeedback() {

        try {
            Connection con = DataBase.getInstance().getConnection();
            String sql = " Select * from feedback";
            PreparedStatement stat = con.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            while (rs.next()) {
                data.add(new feedback(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4)));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        col_id_feedback.setCellValueFactory(new PropertyValueFactory<>("id_feedback"));
        col_note_feedback.setCellValueFactory(new PropertyValueFactory<>("note_feedback"));
//     col_commentaire_feedback.setCellFactory(new PropertyValueFactory<>("commentaire_feedback"));
//     col_date_feedback.setCellFactory(new PropertyValueFactory<>("date_feedback"));
        table_feedback.setItems(data);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
