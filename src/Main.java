import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.AmbientLight;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.PointLight;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.SubScene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

public class Main extends Application implements CelestialProperties {
	
	//Planets
	private static Earth earth;
	private static Sun sun;
	private static Venus venus;
	private static Mercury mercury;
	private static Mars mars;
	private static Jupiter jupiter;
	private static Saturn saturn;
	private static Uranus uranus;
	private static Neptune neptune;
	private static Background bkg;
	
	public static void main(String[] args) {
		loadImages();
		setCamera(camera);
		setAmLight(-60,0);
		setPointLight(sun.getTranslateX()+RADIUS_ARRAY[0]+5, sun.getTranslateY(),sun.getTranslateZ());
		Application.launch(args);
		
		

	}

	@Override
	public void start(Stage stage) {
		Pane pane = new Pane();
		Group root = new Group(earth, sun,venus, camera, amLight,pointLight,mercury,mars,jupiter,saturn,uranus,neptune);
		root.getChildren().addAll(bkg.Boxes);
		SubScene threeDScene = make3DScene(root, camera);
//		Paint Stars = new ImagePattern(new Image(images.get("stars")),0,0,1,1,false);
//		threeDScene.setFill(Stars);
		pane.getChildren().add(threeDScene);
		pane.getChildren().add(PositionsWrapper());
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.setMaximized(true);
		stage.setTitle("3D Orbits");
		Controller KPH = new Controller();
		scene.setOnKeyPressed(KPH);
		stage.show();
		animatePlanets();
		
	}
	
	private VBox PositionsWrapper()
	{
		Label CurrentX = new Label();
		CurrentX.setTextFill(Color.WHITE);
		CurrentX.textProperty().bindBidirectional(camera.translateXProperty(), new NumberStringConverter());
		Label CurrentY = new Label();
		CurrentY.setTextFill(Color.WHITE);
		CurrentY.textProperty().bindBidirectional(camera.translateYProperty(), new NumberStringConverter());
		Label CurrentZ = new Label();
		Label lblx = new Label("X");
		Label lbly = new Label("Y");
		Label lblz = new Label("Z");
		lblx.setTextFill(Color.WHITE);
		lbly.setTextFill(Color.WHITE);
		lblz.setTextFill(Color.WHITE);
		CurrentZ.setTextFill(Color.WHITE);
		CurrentZ.textProperty().bindBidirectional(camera.translateZProperty(), new NumberStringConverter());
		VBox PositionsWrapper = new VBox(10);
		HBox Cords = new HBox(60);
		Cords.getChildren().addAll(lblx,lbly,lblz);
		HBox Positions = new HBox(30);
		PositionsWrapper.getChildren().addAll(Positions,Cords);
		Positions.setAlignment(Pos.BOTTOM_LEFT);
		Positions.getChildren().addAll(CurrentX,CurrentY,CurrentZ);
		PositionsWrapper.setAlignment(Pos.BOTTOM_LEFT);
		return PositionsWrapper;
	}
	
	
	
	//Animates the planets based
	private void animatePlanets(){
		sun.animation();
		earth.animation();
		venus.animation();
		mercury.animation();
		mars.animation();
		jupiter.animation();
		saturn.animation();
		uranus.animation();
		neptune.animation();
		
	}
	

	
	//Create an instance of subscene with a specified camera
	private SubScene make3DScene(Group root, Camera camera) {
		Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
		SubScene scene = new SubScene(root, primaryScreenBounds.getWidth(), primaryScreenBounds.getHeight(), true,
				SceneAntialiasing.BALANCED);
		scene.setFill(Color.rgb(5, 5, 5));
		scene.setCamera(camera);
		return scene;
	}
	
	//Create the camera with a birds eye view
	private static Camera setCamera(Camera cam) {
		cam.setTranslateZ(-10);
		cam.setTranslateY(-1500);
		cam.setTranslateX(-60);
		cam.setRotationAxis(Rotate.X_AXIS);
		cam.setRotate(-90);
		cam.setFarClip(6000);
		return cam;
	}
	
	//Create the Pointlight at the given x,y and z coordinates
	private static PointLight setPointLight(double x, double y,double z) {
		pointLight.setTranslateX(x);
		pointLight.setTranslateY(y);
		pointLight.setTranslateZ(z);
		pointLight.setLightOn(false);
		return pointLight;
	}
	
	//Create the Ambientlight at the given x and y coordinates
	private static AmbientLight setAmLight(double x, double y) {
		amLight.setTranslateX(x);
		amLight.setTranslateY(y);
		amLight.setLightOn(true);
		return amLight;
	}
	
	
	

	//Loads images into the images hashmap
	private static void loadImages()
	{
		images.put("earth", "Images/earth.jpg");
		images.put("moon", "Images/moon.jpg");
		images.put("sun", "Images/sun.jpg");
		images.put("jupiter", "Images/jupiter.jpg");
		images.put("venus", "Images/venus.jpg");
		images.put("mercury", "Images/mercury.png");
		images.put("mars", "Images/mars.jpg");
		images.put("saturn", "Images/saturn.jpg");
		images.put("uranus", "Images/uranus.png");
		images.put("neptune", "Images/neptune.jpg");
		images.put("stars","Images/stars.jpg");
		earth = new Earth(images.get("earth"), RADIUS_ARRAY[1]);
		sun = new Sun(images.get("sun"), RADIUS_ARRAY[0]);
		venus = new Venus(images.get("venus"),RADIUS_ARRAY[4]);
		mercury = new Mercury(images.get("mercury"),RADIUS_ARRAY[5]);
		mars = new Mars(images.get("mars"),RADIUS_ARRAY[6]);
		jupiter = new Jupiter(images.get("jupiter"), RADIUS_ARRAY[7]);
		saturn = new Saturn(images.get("saturn"),RADIUS_ARRAY[8]);
		uranus = new Uranus(images.get("uranus"),RADIUS_ARRAY[9]);
		neptune = new Neptune(images.get("neptune"),RADIUS_ARRAY[10]);
		bkg = new Background(images.get("stars"));
	}
	
	//Pauses the animation of the planets in the current position
	static void pausePlanets(){
		earth.pause();
		jupiter.pause();
		mars.pause();
		mercury.pause();
		neptune.pause();
		saturn.pause();
		sun.pause();
		uranus.pause();
		venus.pause();
		
	}
	
	//Plays the animation of the planets from the current position
	static void playPlanets(){
			earth.play();
			jupiter.play();
			mars.play();
			mercury.play();
			neptune.play();
			saturn.play();
			sun.play();
			uranus.play();
			venus.play();
			
		}
	

	
	
		
	}


