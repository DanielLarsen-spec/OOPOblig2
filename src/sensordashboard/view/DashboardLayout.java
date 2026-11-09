package sensordashboard.view;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import sensordashboard.model.Sensor;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.ProgressBar;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import java.util.List;

public class DashboardLayout{
    
    private final BorderPane root = new BorderPane();
    private final Button updateButton = new Button("Update");
    private final Button startButton = new Button("Start");
    private final Button stopButton = new Button("Stop");
    private final Slider slider = new Slider(0, 100, 70);

    public DashboardLayout(List<Sensor> sensors) {
        Label title = new Label("Sensor Monitor Dashboard");
        root.setTop(title);
        root.setPadding(new Insets(20));
        
        Label thresholdLabel = new Label();
        thresholdLabel.textProperty().bind(slider.valueProperty().asString("Alert threshold: %.0f%%"));

        HBox buttons = new HBox(10);
        buttons.getChildren().addAll(updateButton, startButton, stopButton, thresholdLabel ,slider);

        HBox cards = new HBox(20);
        for(Sensor sensor : sensors) {
            VBox card = createCard(sensor);
            cards.getChildren().add(card);
        }
        root.setCenter(cards);
        root.setBottom(buttons);
    
    }

    public BorderPane getRoot() {
        return root;
    }

    public Button getUpdateButton(){
        return updateButton;
    }

    public Button getStartButton(){
        return startButton;
    }

    public Button getStopButton(){
        return stopButton;
    }

    public Slider getSlider(){
        return slider;
    }

    private VBox createCard(Sensor sensor) {
        Label nameLabel = new Label(sensor.getName());
        Label valueLabel = new Label();
        Label trendLabel = new Label();
        ProgressBar bar = new ProgressBar();

        

        valueLabel.textProperty().bind(sensor.valueProperty().asString("%.0f").concat(sensor.getUnit()));
        bar.progressProperty().bind(sensor.valueProperty().divide(100));

        trendLabel.valueProperty().addListener((obs, oldValue, newValue) -> {
            if(newValue.doubleValue() > oldValue.doubleValue()) {
                trendLabel.setText("▲");
            } else if(newValue.doubleValue() < oldValue.doubleValue()) {
                trendLabel.setText("▼");
            } else {
                trendLabel.setText("-");
            }
        });
       
        VBox card = new VBox(10, nameLabel, valueLabel, bar);

        BooleanBinding overThreshould = sensor.valueProperty().greaterThan(slider.valueProperty());
        
        card.styleProperty().bind(
            Bindings.when(overThreshould).then("-fx-background-color: #ffcccc; -fx-padding: 15;")
            .otherwise("-fx-background-color: #eeeeee; -fx-padding: 15;")
        );


        return card;

    }



}
