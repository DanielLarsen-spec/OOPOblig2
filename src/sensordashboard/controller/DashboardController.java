package sensordashboard.controller;

import sensordashboard.view.DashboardLayout;
import sensordashboard.model.Sensor;
import java.util.List;

public class DashboardController {
    private final List<Sensor> sensors;


    public DashboardController(List<Sensor> sensors, DashboardLayout layout) {
        this.sensors = sensors;

        layout.getUpdateButton().setOnAction(e -> updateSensors());
    }

    private void updateSensors(){
        for(Sensor sensor : sensors ) {
            sensor.setValue(Math.random() * 100);
        }
    }





}
