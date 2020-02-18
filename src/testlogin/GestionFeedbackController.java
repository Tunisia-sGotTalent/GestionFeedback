package testlogin;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.tgt.Entite.feedback;
import com.tgt.Service.servicefeedback;
import com.tgt.Utils.DataBase;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static java.util.Collections.list;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class GestionFeedbackController implements Initializable {

    @FXML
    private TableColumn<feedback, Integer> col_id_feedback;
    @FXML
    private TableColumn<feedback, Integer> col_note_feedback;
    @FXML
    private TableColumn<feedback, String> col_date_feedback;
    @FXML
    private TableColumn<feedback, String> col_commentaire_feedback;
    @FXML
    private JFXTextField t_nnote_feedback;
    @FXML
    private JFXTextArea t_commentaire_feedback;
    @FXML
    private JFXDatePicker t_date_feedback;

    ObservableList<feedback> arr = FXCollections.observableArrayList();
    @FXML
    private TableView<feedback> table;
    @FXML
    private BarChart<?, ?> barChart;
    @FXML
    private JFXButton btnload;
    private Connection con;
    private Statement ste;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        col_id_feedback.setCellValueFactory(new PropertyValueFactory<>("id_feedback"));
        col_note_feedback.setCellValueFactory(new PropertyValueFactory<>("note_feedback"));
        col_date_feedback.setCellValueFactory(new PropertyValueFactory<>("date_feedback"));
        col_commentaire_feedback.setCellValueFactory(new PropertyValueFactory<>("commentaire_feedback"));
        feedback E = new feedback();

        try {
            servicefeedback ser = new servicefeedback();
            arr = ser.afficher(E);

        } catch (SQLException ex) {
            System.out.println(ex);

        }
        table.setItems((ObservableList<feedback>) arr);
        System.out.println("iciiiiiiiiiiiiiiiiiiii");
    }

    @FXML
    private void AjouterFeedback(MouseEvent event) {

        feedback f = new feedback();

        f.setNote_feedback(Integer.parseInt(t_nnote_feedback.getText()));
        f.setCommentaire_feedback(t_commentaire_feedback.getText());
        String value = t_date_feedback.getValue().toString();
        servicefeedback ser = new servicefeedback();
        try {
            ser.ajouter(f);
        } catch (Exception e) {

        }
        arr.clear();
        col_id_feedback.setCellValueFactory(new PropertyValueFactory<>("id_feedback"));
        col_note_feedback.setCellValueFactory(new PropertyValueFactory<>("note_feedback"));
        col_date_feedback.setCellValueFactory(new PropertyValueFactory<>("date_feedback"));
        col_commentaire_feedback.setCellValueFactory(new PropertyValueFactory<>("commentaire_feedback"));
        feedback E = new feedback();

        try {

            arr = ser.afficher(E);

        } catch (SQLException ex) {
            System.out.println(ex);

        }
        table.setItems((ObservableList<feedback>) arr);
    }

    @FXML
    private void UpdateFeedback(MouseEvent event) {
    }

    @FXML
    private void DeleteFeedback(MouseEvent event) throws SQLException {
        feedback f = table.getSelectionModel().getSelectedItem();
        servicefeedback ser = new servicefeedback();
        ser.deleteParXID(f);
        arr.clear();
        arr.addAll(ser.readAll());

    }

//    public void modifierNoteFeedback(CellEditEvent editcell) throws SQLException {
//        servicefeedback ser = new servicefeedback();
//        feedback feedbackselectionne = table.getSelectionModel().getSelectedItem();
//        feedbackselectionne.setNote_feedback((int) editcell.getNewValue());
//        System.out.println(feedbackselectionne);
//        ser.update(feedbackselectionne);
//    }
    @FXML
    private void searchFeedback(MouseEvent event) throws SQLException {
        feedback f = new feedback();
        servicefeedback ser = new servicefeedback();
        if (!(ser.rechercherParID(f).isEmpty())) {
            arr.clear();
            arr.addAll(ser.rechercherParID(f));
        } else if (ser.rechercherParID(f).isEmpty()) {
            System.out.println("vide");
            arr = ser.afficher(f);
            table.setItems(arr);
        }
        System.out.println(ser.rechercherParID(f));
    }

    @FXML
    private void loadChart(ActionEvent event) throws SQLException {
        con = DataBase.getInstance().getConnection();
        ste = con.createStatement();
        String query = "Select date_feedback,note_feedback FROM feedback";
        XYChart.Series series = new XYChart.Series<>();
        ResultSet rs = ste.executeQuery(query);
        while (rs.next()) {
            XYChart.Data<String, Number> data =  new XYChart.Data<String, Number>(rs.getString(2),rs.getDouble(1));
           series.getData().add(data);
//            series.getData().add(new XYChart.Data<>(rs.getInt("id_feedback"), rs.getInt("note_feedback")));
        }
//        barChart.getData().add(series);
    }

}
