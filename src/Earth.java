import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.binding.Bindings;
import javafx.scene.shape.CullFace;
import javafx.scene.shape.DrawMode;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class Earth extends SpaceBody {
	
	public Earth(String image, double radius) {
		this.setRadius(radius);
		this.setMaterial(getTexture(image));
		this.setDrawMode(DrawMode.FILL);
		this.setCullFace(CullFace.BACK);
		this.setTranslateX(-60);
	}

	public void animation() {
		this.translateXProperty().bind(Bindings.createDoubleBinding(() -> {
			return (TRANSLATION_X_CONSTANT*SUN_EARTH_DISTANCE * Math.cos(Math.toRadians(EarthRevolutionAngle.get())));
		} , EarthRevolutionAngle));

		this.translateZProperty().bind(Bindings.createDoubleBinding(() -> {
			return (TRANSLATION_Z_CONSTANT*SUN_EARTH_DISTANCE * Math.sin(Math.toRadians(EarthRevolutionAngle.get())));
		} , EarthRevolutionAngle));

		
		this.setRotationAxis(Rotate.Y_AXIS);
		this.rotateProperty().bind(Bindings.multiply(-1.0, EarthRevolutionAngle));
		rotation = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(EarthRevolutionAngle, 0.0)),
				new KeyFrame(Duration.seconds(EARTH_ROTATION_DURATION), new KeyValue(EarthRevolutionAngle, 360.0)));
		rotation.setCycleCount(Timeline.INDEFINITE);
		rotation.setAutoReverse(false);
		rotation.play();
	}
	
	public void play() {
		this.translateXProperty().bind(Bindings.createDoubleBinding(() -> {
			return (TRANSLATION_X_CONSTANT*SUN_EARTH_DISTANCE * Math.cos(Math.toRadians(EarthRevolutionAngle.get())));
		} , EarthRevolutionAngle));
		this.translateZProperty().bind(Bindings.createDoubleBinding(() -> {
			return (TRANSLATION_Z_CONSTANT*SUN_EARTH_DISTANCE * Math.sin(Math.toRadians(EarthRevolutionAngle.get())));
		} , EarthRevolutionAngle));
		rotation.play();
	}
	

	
}
