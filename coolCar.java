import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.shape.Polygon;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.ColorPicker;

public class coolCar extends Application {

    public Polygon carChassis() {
        Polygon chassis = new Polygon(100, 300, 300, 300, 350, 250, 50, 250);
        chassis.setFill(Color.RED);
        return chassis;
    }

    public Circle carWheel(double centerX, double centerY) {
        Circle wheel = new Circle(centerX, centerY, 30);
        wheel.setFill(Color.BLACK);
        return wheel;
    }

    public Rectangle carWindow(double x, double y) {
        Rectangle window = new Rectangle(x, y, 80, 40);
        window.setFill(Color.LIGHTBLUE);
        return window;
    }

    public void start(Stage primaryStage) {
        Group root = new Group();
        Polygon chassis = carChassis();
        Circle frontWheel = carWheel(90, 300);
        Circle rearWheel = carWheel(310, 300);
        Rectangle frontWindow = carWindow(130, 230);
        Rectangle rearWindow = carWindow(230, 230);
        root.getChildren().addAll(chassis, frontWheel, rearWheel, frontWindow, rearWindow);
        ColorPicker colorPicker = new ColorPicker();
        colorPicker.setValue(Color.RED);
        colorPicker.setOnAction(event -> {
            Color selectedColor = colorPicker.getValue();
            chassis.setFill(selectedColor);
        });
        colorPicker.setTranslateX(400);
        colorPicker.setTranslateY(150);
        root.getChildren().add(colorPicker);
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setTitle("Cool Car :)");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
