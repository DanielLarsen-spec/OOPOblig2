package sensordashboard.model;

public class Humidity extends Sensor {
    
    
    public Humidity(String name, double value) {
        super(name, value);
        
    }

    @Override
    public String getUnit(){
        return "%";
    }

    







}
