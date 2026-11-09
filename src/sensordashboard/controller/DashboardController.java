package sensordashboard.controller;

import sensordashboard.view.DashboardLayout;
import sensordashboard.model.Sensor;
import java.util.List;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class DashboardController {
    private final List<Sensor> sensors;
    private final BooleanProperty running = new SimpleBooleanProperty(false);

    public DashboardController(List<Sensor> sensors, DashboardLayout layout) {
        this.sensors = sensors;

        layout.getUpdateButton().setOnAction(e -> updateSensors());
        layout.getStartButton().setOnAction(e -> running.set(true));
        layout.getStopButton().setOnAction(e -> running.set(false));

        layout.getUpdateButton().disableProperty().bind(running.not());
        layout.getStartButton().disableProperty().bind(running);
        layout.getStopButton().disableProperty().bind(running.not());

    }

    private void updateSensors(){
        for(Sensor sensor : sensors ) {
            sensor.setValue(Math.random() * 100);
        }
    }





}
