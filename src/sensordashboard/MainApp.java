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
import sensordashboard.view.DashboardLayout;



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
            
            
            DashboardLayout layout = new DashboardLayout(sensors);
            
            Scene scene = new Scene(layout.getRoot(), 700, 400);
            
            Image icon = new Image("Icon.png");   
            stage.getIcons().add(icon);
            stage.setTitle("Sensor Dashboard");
            stage.setScene(scene);
            stage.show();
        
        
        
    }

    public static void main(String[] args) {
        launch(args);
    }
}
