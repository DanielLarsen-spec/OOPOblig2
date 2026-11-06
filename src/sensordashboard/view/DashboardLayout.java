package sensordashboard.view;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import sensordashboard.model.Sensor;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.geometry.Insets;
import java.util.List;







public class DashboardLayout{
    
    private final BorderPane root = new BorderPane();
    private final Button updateButton = new Button("Update");

    public DashboardLayout(List<Sensor> sensors) {
        Label title = new Label("Sensor Monitor Dashboard");
        root.setTop(title);
        root.setPadding(new Insets(20));
        

        HBox cards = new HBox(20);
        for(Sensor sensor : sensors) {
            VBox card = createCard(sensor);
            cards.getChildren().add(card);
        }
        root.setCenter(cards);
        root.setBottom(updateButton);
    
    }

    public BorderPane getRoot() {
        return root;
    }

    public Button getUpdateButton(){
        return updateButton;
    }

    private VBox createCard(Sensor sensor) {
        Label nameLabel = new Label(sensor.getName());
        Label valueLabel = new Label();
        ProgressBar bar = new ProgressBar();

        

        valueLabel.textProperty().bind(sensor.valueProperty().asString("%.0f").concat(sensor.getUnit()));
        bar.progressProperty().bind(sensor.valueProperty().divide(100));
        VBox card = new VBox(10, nameLabel, valueLabel, bar);
        


        return card;

    }



}
