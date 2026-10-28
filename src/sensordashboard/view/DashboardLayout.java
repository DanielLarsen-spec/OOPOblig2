package sensordashboard.view;
//Layout-panes
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import sensordashboard.model.Sensor;
import javafx.scene.layout.GridPane;

//Kontroller
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.ProgressBar;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import java.util.List;

public class DashboardLayout{
    
    private final BorderPane root = new BorderPane();

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
    }

    public BorderPane getRoot() {
        return root;
    }

    private VBox createCard(Sensor sensor) {
        Label nameLabel = new Label(sensor.getName());
        Label valueLabel = new Label();
        ProgressBar bar = new ProgressBar();

        valueLabel.textProperty().bind(sensor.valueProperty().asString("%.0f%%"));

        VBox card = new VBox(10, nameLabel, valueLabel, bar);

        return card;

    }



}
