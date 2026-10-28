package sensordashboard.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public abstract class Sensor {
    protected String name;
    private final DoubleProperty value = new SimpleDoubleProperty();
    
    public Sensor(String name, double value) {
        this.name = name;
        this.value.set(value);
    }

    public String getName() {
        return name;
    }

    public double getValue() {
        return value.get();
    }

    public void setValue(double value){
        this.value.set(value);
    }

    public DoubleProperty valueProperty(){
        return value;
    }
    












}