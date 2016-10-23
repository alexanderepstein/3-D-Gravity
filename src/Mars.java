import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.binding.Bindings;
import javafx.scene.shape.CullFace;
import javafx.scene.shape.DrawMode;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class Mars extends SpaceBody {

	public Mars(String image, double radius) {
		this.setRadius(radius);
		this.setMaterial(getTexture(image));
		this.setDrawMode(DrawMode.FILL);
		this.setCullFace(CullFace.BACK);
		this.setTranslateX(-60);
	}
	
	@Override
	public void animation() {
		this.translateXProperty().bind(Bindings.createDoubleBinding(() -> {
			return (TRANSLATION_X_CONSTANT*SUN_MARS_DISTANCE * Math.cos(Math.toRadians(MarsRevolutionAngle.get())));
		} , MarsRevolutionAngle));

		this.translateZProperty().bind(Bindings.createDoubleBinding(() -> {
			return (TRANSLATION_Z_CONSTANT*SUN_MARS_DISTANCE * Math.sin(Math.toRadians(MarsRevolutionAngle.get())));
		} , MarsRevolutionAngle));

		
		this.setRotationAxis(Rotate.Y_AXIS);
		this.rotateProperty().bind(Bindings.multiply(-1.0, MarsRevolutionAngle));
		rotation = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(MarsRevolutionAngle, 0.0)),
				new KeyFrame(Duration.seconds(MARS_ROTATION_DURATION), new KeyValue(MarsRevolutionAngle, 360.0)));
		rotation.setCycleCount(Timeline.INDEFINITE);
		rotation.setAutoReverse(false);
		rotation.play();
	}
	

	public void play() {
		this.translateXProperty().bind(Bindings.createDoubleBinding(() -> {
			return (TRANSLATION_X_CONSTANT*SUN_MARS_DISTANCE * Math.cos(Math.toRadians(MarsRevolutionAngle.get())));
		} , MarsRevolutionAngle));

		this.translateZProperty().bind(Bindings.createDoubleBinding(() -> {
			return (TRANSLATION_Z_CONSTANT*SUN_MARS_DISTANCE * Math.sin(Math.toRadians(MarsRevolutionAngle.get())));
		} , MarsRevolutionAngle));
		rotation.play();
	}

}
