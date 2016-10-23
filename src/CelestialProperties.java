import java.util.HashMap;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.AmbientLight;
import javafx.scene.PointLight;
import javafx.scene.Camera;
import javafx.scene.PerspectiveCamera;
import javafx.scene.paint.Color;

interface CelestialProperties {
	//Cameras and lights
	static final Camera camera = new PerspectiveCamera(true);
	static final AmbientLight amLight = new AmbientLight(Color.WHITE);
	static final PointLight pointLight = new PointLight(Color.WHITE);
	
	//Celestial Constants
	static final Double SPEED_OF_LIGHT = 300 * Math.pow(10, 6);
	static final Double G = 6.67 * Math.pow(10, -11);
	final double[] RADIUS_ARRAY = { 30, 4, 5, 1.7 ,3.4,2.5,3,20,15,7.5,7.3};
	final double TRANSLATION_X_CONSTANT = 7;
	final double TRANSLATION_Z_CONSTANT = 2.25;
	
	//Planet to sun distance
	final double SUN_EARTH_DISTANCE = 35;
	final double SUN_VENUS_DISTANCE = 30;
	final double SUN_MERCURY_DISTANCE = 25;
	final double SUN_MARS_DISTANCE = 40;
	final double SUN_JUPITER_DISTANCE = 60;
	final double SUN_SATURN_DISTANCE = 80;
	final double SUN_URANUS_DISTANCE = 95;
	final double SUN_NEPTUNE_DISTANCE = 105;
	
	//Planet Speeds & Revolution Angle Property
	final int EARTH_ROTATION_DURATION = 7;
	final int SATURN_ROTATION_DURATION = 70;
	final int URANUS_ROTATION_DURATION = 210;
	final int NEPTUNE_ROTATION_DURATION = 300;
	final int MARS_ROTATION_DURATION = 11;
	final int MERCURY_ROTATION_DURATION = 2;
	final int VENUS_ROTATION_DURATION = 6;
	final int JUPITER_ROTATION_DURATION = 42;
	final DoubleProperty UranusRevolutionAngle = new SimpleDoubleProperty(0.0);
	final DoubleProperty MercuryRevolutionAngle = new SimpleDoubleProperty(0.0);
	final DoubleProperty MarsRevolutionAngle = new SimpleDoubleProperty(0.0);
	final DoubleProperty EarthRevolutionAngle = new SimpleDoubleProperty(0.0);
	final DoubleProperty NeptuneRevolutionAngle = new SimpleDoubleProperty(0.0);
	final DoubleProperty VenusRevolutionAngle = new SimpleDoubleProperty(0.0);
	final DoubleProperty SaturnRevolutionAngle = new SimpleDoubleProperty(0.0);
	final DoubleProperty JupiterRevolutionAngle = new SimpleDoubleProperty(0.0);

	//Bounds of space
	final int xbound = 1500;
	final int ybound = 1500;
	final int zbound = 1500;
	
	//Planet Images
	static HashMap<String, String> images = new HashMap<String, String>();


	

}
