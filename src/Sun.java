import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.shape.CullFace;
import javafx.scene.shape.DrawMode;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class Sun extends SpaceBody{
	public Sun(String image, double radius){
		this.setRadius(radius);
		this.setMaterial(getTexture(image));
		this.setDrawMode(DrawMode.FILL);
		this.setCullFace(CullFace.BACK);
		this.setTranslateX(-60);
	}
	
	
	public void animation() {
		this.setRotationAxis(Rotate.Y_AXIS);
		rotation = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(this.rotateProperty(), 360.0)),
		new KeyFrame(Duration.seconds(200), new KeyValue(this.rotateProperty(), 0.0)));
		rotation.setCycleCount(Timeline.INDEFINITE);
		rotation.setAutoReverse(false);
		rotation.play();
	}
	public void play()
	{
		rotation.play();
	}


}
