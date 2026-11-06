package sensordashboard.model;

public class Thermostate extends Sensor {
   
    

    public Thermostate(String name, double value) {
        super(name, value);
        
    }
    @Override
    public String getUnit() {
        return "°C";
    }





}
