package sensordashboard.model;

public class Light extends Sensor {
    private int brightness;

    public Light(String name, boolean status, int brightness){
        super(name, status);
        this.brightness = brightness;
    }

    public int getBrightness(){
        return brightness;
    }

    public void setBrightness(int brightness){
        this.brightness = brightness;
    }





    
}
