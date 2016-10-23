import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.Material;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;

public abstract class SpaceBody extends Sphere implements CelestialProperties {
	
	Timeline rotation;	//Variable that controls the animation of the orbit.
	abstract void animation(); //Method that must be implemented for animation to be possible.
	abstract void play(); //Method that must be implemented to play the animation.
	
	public void pause() { //All SpaceBodies will share a similar pause method.
		this.translateXProperty().unbind();
		this.translateZProperty().unbind();
		rotation.pause();
	}
	
	public Material getTexture(String name) { //All SpaceBodies will share a similar getTexture method.
		//Interaction with light
			PhongMaterial material = new PhongMaterial();
			Image textureImage = new Image(getClass().getResourceAsStream(name));
			material.setDiffuseMap(textureImage);
			material.setDiffuseColor(Color.WHITE);
			return material;
	}

}

