import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.transform.Rotate;

public class Controller implements EventHandler<KeyEvent>, CelestialProperties{
	//Modify how keys navigate 3d space
		private static boolean playing = true;
		private static boolean rotatex = false;
		private static boolean ytrans = false;
		private double rotationamt = .25;
		private Double currentCameraZ,currentCameraX,currentCameraY;
	

		//This method is the handler for the keypress events, this handler is 
		//the logic behind moving in three dimensional space.
	@Override
	public void handle(KeyEvent key) {
		
		switch (key.getCode()) {
		case V:
			System.out.println("X = " + camera.getTranslateX());
			System.out.println("Y = " + camera.getTranslateY());
			System.out.println("Z = " + camera.getTranslateZ());
			System.out.println("Rotation value" + camera.getRotate());
			break;
		case R:
			camera.setTranslateX(-10);
			camera.setTranslateY(0);
			camera.setTranslateZ(-600);
			camera.setRotate(0);
			break;
		case SPACE:
			camera.setTranslateX(-60);
			camera.setTranslateY(-1500);
			camera.setTranslateZ(-10);
			camera.setRotationAxis(Rotate.X_AXIS);
			camera.setRotate(-90);
			break;
		case ENTER:
			currentCameraX = camera.getTranslateX();
			currentCameraY = camera.getTranslateY();
			currentCameraZ = camera.getTranslateZ();
			if (ytrans == false) {
				ytrans = true;
				camera.setTranslateX(currentCameraX);
				camera.setTranslateY(currentCameraY);
				camera.setTranslateZ(currentCameraZ);
				break;
			}
			ytrans = false;
			camera.setTranslateX(currentCameraX);
			camera.setTranslateY(currentCameraY);
			camera.setTranslateZ(currentCameraZ);
			break;
		case UP:
			if (!ytrans) {
				// System.out.println("Hit down");
				if (zbound > camera.getTranslateZ()+10) camera.setTranslateZ(camera.getTranslateZ() + 10);
			} else {
				if (-ybound < camera.getTranslateY()-10) camera.setTranslateY(camera.getTranslateY() - 10);
				
			}

			break;
		case DOWN:
			if (!ytrans) {
				if (-zbound < camera.getTranslateZ()-10) camera.setTranslateZ(camera.getTranslateZ() - 10);
			} else {
				if (ybound > camera.getTranslateY()+10) camera.setTranslateY(camera.getTranslateY() + 10);
			}
			// System.out.println("Hit up");

			break;
		case LEFT:
			// System.out.println("Hit left");
			if (-xbound < camera.getTranslateX()-10) camera.setTranslateX(camera.getTranslateX() - 10);
			break;
		case RIGHT:
			// System.out.println("Hit right");
			if (xbound > camera.getTranslateX()+10) camera.setTranslateX(camera.getTranslateX() + 10);
			break;
		case L:
			setAmLight();
			setPointLight();
			break;
		case F:
			currentCameraX = camera.getTranslateX();
			currentCameraY = camera.getTranslateY();
			currentCameraZ = camera.getTranslateZ();
			if (rotationamt == 3)
			{
				rotationamt = .25;
				camera.setTranslateX(currentCameraX);
				camera.setTranslateY(currentCameraY);
				camera.setTranslateZ(currentCameraZ);
				break;
			}
			rotationamt=3;
			camera.setTranslateX(currentCameraX);
			camera.setTranslateY(currentCameraY);
			camera.setTranslateZ(currentCameraZ);
			break;
		case W:
			if (!rotatex)
			{
				camera.setRotationAxis(Rotate.X_AXIS);
				camera.setRotate(camera.getRotate() + rotationamt);
			}
			else
			{
				camera.setRotationAxis(Rotate.X_AXIS);
				camera.setRotate(rotationamt);
				rotatex=false;
			}
			break;
		case S:
			if (!rotatex)
			{
				camera.setRotationAxis(Rotate.X_AXIS);
				camera.setRotate(camera.getRotate() - rotationamt);
			}
			else
			{
				camera.setRotationAxis(Rotate.X_AXIS);
				camera.setRotate(-rotationamt);
				rotatex=false;
			}
			break;
		case A:
			if (rotatex)
			{
				camera.setRotationAxis(Rotate.Y_AXIS);
				camera.setRotate(camera.getRotate() - rotationamt);
			}
			else
			{
				camera.setRotationAxis(Rotate.Y_AXIS);
				camera.setRotate(-rotationamt);
				rotatex=true;
			}
			
			
			break;
		case D:
			if (rotatex)
			{
				camera.setRotationAxis(Rotate.Y_AXIS);
				camera.setRotate(camera.getRotate() + rotationamt);
			}
			else
			{
				camera.setRotationAxis(Rotate.Y_AXIS);
				camera.setRotate(rotationamt);
				rotatex=true;
			}
			
			break;
		case P:
			if (playing)
			{
				Main.pausePlanets();
				playing = false;
				break;
			}
			else
			{
				Main.playPlanets();
				playing = true;
				break;
			}
		default:
			break;
		}
	}

	//Call method as lightswitch for the ambient light
		private void setAmLight() {
			if (amLight.isLightOn()) {
				amLight.setLightOn(false);
				return;
			}
			amLight.setLightOn(true);
		}
		
		//Call method as lightswitch for the point light
		private void setPointLight() {
			if (pointLight.isLightOn()) {
				pointLight.setLightOn(false);
				return;
			}
			pointLight.setLightOn(true);
		}
		
}
