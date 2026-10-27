package sensordashboard.model;

public class Light extends Sensor {
    private int brightness;

    public Light(String name, boolean status, int brightness){
        super(name, status);
        this.brightness = brightness;
    }







    
}
