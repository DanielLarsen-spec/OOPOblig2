package sensordashboard.model;

public class Light extends Sensor {
    

    public Light(String name, double value){
        super(name, value);
        
    }

    @Override
    public String getUnit(){
        return "%";
    }
    





    
}
