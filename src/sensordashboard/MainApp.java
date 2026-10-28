package sensordashboard;
import java.util.List;
import java.util.ArrayList;
import sensordashboard.model.*;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.image.Image;     
import javafx.scene.image.ImageView; 


public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        Sensor thermostate = new Thermostate("Termostat", 21.0);
        Sensor light = new Light("Lampe", 60);
        Sensor humidity = new Humidity("Fuktighetsmåler", 40);
        
        List<Sensor> sensors = new ArrayList<Sensor>(); 
            sensors.add(thermostate);
            sensors.add(light);
            sensors.add(humidity);
        
            Group root = new Group();
            Scene scene = new Scene(root, Color.BLACK);  
            Image icon = new Image("Icon.png");  
        
            stage.getIcons().add(icon);
            stage.setScene(scene);
            stage.show();
        
        
        
    }

    public static void main(String[] args) {
        launch(args);
    }
}
