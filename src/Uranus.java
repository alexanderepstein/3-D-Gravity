import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.binding.Bindings;
import javafx.scene.shape.CullFace;
import javafx.scene.shape.DrawMode;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class Uranus extends SpaceBody{
	public Uranus(String image, double radius) {
		this.setRadius(radius);
		this.setMaterial(getTexture(image));
		this.setDrawMode(DrawMode.FILL);
		this.setCullFace(CullFace.BACK);
		this.setTranslateX(-60);
	}
	@Override
	public void animation() {
		this.translateXProperty().bind(Bindings.createDoubleBinding(() -> {
			return (TRANSLATION_X_CONSTANT*SUN_URANUS_DISTANCE * Math.cos(Math.toRadians(UranusRevolutionAngle.get())));
		} , UranusRevolutionAngle));

		this.translateZProperty().bind(Bindings.createDoubleBinding(() -> {
			return (TRANSLATION_Z_CONSTANT*SUN_URANUS_DISTANCE * Math.sin(Math.toRadians(UranusRevolutionAngle.get())));
		} , UranusRevolutionAngle));

		
		this.setRotationAxis(Rotate.Y_AXIS);
		this.rotateProperty().bind(Bindings.multiply(-1.0, UranusRevolutionAngle));
		rotation = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(UranusRevolutionAngle, 0.0)),
				new KeyFrame(Duration.seconds(URANUS_ROTATION_DURATION), new KeyValue(UranusRevolutionAngle, 360.0)));
		rotation.setCycleCount(Timeline.INDEFINITE);
		rotation.setAutoReverse(false);
		rotation.play();
	}
	
	public void play() {
		
		this.translateXProperty().bind(Bindings.createDoubleBinding(() -> {
			return (TRANSLATION_X_CONSTANT*SUN_URANUS_DISTANCE * Math.cos(Math.toRadians(UranusRevolutionAngle.get())));
		} , UranusRevolutionAngle));

		this.translateZProperty().bind(Bindings.createDoubleBinding(() -> {
			return (TRANSLATION_Z_CONSTANT*SUN_URANUS_DISTANCE * Math.sin(Math.toRadians(UranusRevolutionAngle.get())));
		} , UranusRevolutionAngle));

		rotation.play();
	}
}
