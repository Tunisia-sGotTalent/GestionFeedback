package testlogin;

import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class PageAccueilClientController implements Initializable {

    @FXML
    private JFXTextField tnom1;
    private MediaPlayer mediaPlayer;
    private Media media;
    @FXML
    private MediaView mediaView;

    public void setTnom1(JFXTextField tnom1) {
        this.tnom1.setText(tnom1.getText());
    }

    public JFXTextField getTnom1() {
        return tnom1;
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /*  String path;
        path = new File("src/image/fr.mp4").getAbsolutePath();
   media=new Media(new File(path).toURI().toString());
  mediaPlayer= new MediaPlayer(media);
    mediaView.setMediaPlayer(mediaPlayer);
   mediaPlayer.play();
         */
    }

    @FXML
    private void retour(MouseEvent event) {
        try {
            //   try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));

            Parent root = (Parent) fxmlLoader.load();
            FXMLDocumentController apc = fxmlLoader.getController();
            apc.setTnom((JFXTextField) tnom1);

            tnom1.getScene().setRoot(root);
            // stage.setTitle("hello");
            //       stage.setScene(new Scene(root));
            //  stage.show();
        } catch (IOException e) {
            System.out.println("can't load new window");
        }

    }

}
