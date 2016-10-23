import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.Material;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;

public class Background implements CelestialProperties {
 public static Box faceone = new Box(1,2*ybound+50,2*zbound+50);
 public static Box facetwo = new Box(1,2*ybound+50,2*zbound+50);
 public static  Box facethree = new Box(2*xbound+50,1,2*zbound+50);
 public static Box facefour = new Box(2*xbound+50,1,2*zbound+50);
 public static Box facefive = new Box(2*xbound+50,2*ybound+50,1);
 public static Box facesix = new Box(2*xbound+50,2*ybound+50,1);
 ArrayList<Box> Boxes = new ArrayList<>();
 public Background(String image)
	{
		faceone.setMaterial(getTexture(image));
		facetwo.setMaterial(getTexture(image));
		facethree.setMaterial(getTexture(image));
		facefour.setMaterial(getTexture(image));
		facefive.setMaterial(getTexture(image));
		facesix.setMaterial(getTexture(image));
		faceone.setTranslateX(-xbound);
		faceone.setTranslateY(ybound/4-350);
		facetwo.setTranslateX(xbound);
		facetwo.setTranslateY(ybound/4-350);
		facethree.setTranslateX(-xbound/8+200);
		facethree.setTranslateY(-ybound);
		facethree.setTranslateZ(zbound/8-200);
		facefour.setTranslateX(-xbound/8+200);
		facefour.setTranslateY(ybound);
		facefour.setTranslateZ(zbound/8-200);
		facefive.setTranslateX(-xbound/4+350);
		facefive.setTranslateY(ybound/4-350);
		facefive.setTranslateZ(zbound);
		facesix.setTranslateX(-xbound/4+350);
		facesix.setTranslateY(-ybound/4+350);
		facesix.setTranslateZ(-zbound);
		Boxes.add(faceone);
		Boxes.add(facetwo);
		Boxes.add(facethree);
		Boxes.add(facefour);
		Boxes.add(facefive);
		Boxes.add(facesix);
	}
	
	public Material getTexture(String name) { 
		//Interaction with light
			PhongMaterial material = new PhongMaterial();
			Image textureImage = new Image(getClass().getResourceAsStream(name));
			material.setDiffuseMap(textureImage);
			material.setDiffuseColor(Color.WHITE);
			return material;
	}
	
}
