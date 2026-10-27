package sensordashboard.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public abstract class Sensor {
    protected String name;
    protected boolean status;
    private final DoubleProperty value = new SimpleDoubleProperty();
    
    public Sensor(String name, boolean status, double value) {
        this.name = name;
        this.status = status;
        this.value.set(value);
    }

    












}