package sensordashboard.model;

public class Thermostate extends Sensor {
   private double temperature; 
    

    public Thermostate(String name, boolean status, double temperature) {
        super(name, status);
        this.temperature = temperature;
    }

    public double getTemperature(){
        return temperature;
    }

    public void setTemperature(double temperature){
        this.temperature = temperature;
    }



}
