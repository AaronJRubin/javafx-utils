package buttons;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class DownButton extends Button {

	private ImageView downView;
	
	public DownButton() {
		super();
		Image down = new Image(getClass().getClassLoader().getResourceAsStream("buttons/down_64.png"));
		downView = new ImageView(down);
		setGraphic(downView);
	}
	
	public DownButton(double x, double y) {
		this();
		setDimensions(x, y);
	}
	
	public void setDimensions(double x, double y) {
		setFitWidth(x);
		setFitHeight(y);
	}
	
	public void setFitWidth(double f) {
		downView.setFitWidth(f);
	}
	
	public void setFitHeight(double f) {
		downView.setFitHeight(f);
	}
	
}
