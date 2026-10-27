package sensordashboard.model;

public class Humidity extends Sensor {
    private int humidityValue;
    
    public Humidity(String name, boolean status, int humidityValue) {
        super(name, status);
        this.humidityValue = humidityValue;
    }

    public int getHumidityValue(){
        return humidityValue;
    }

    public void setHumidityValue(int humidityValue){
        this.humidityValue = humidityValue;
    }








}
