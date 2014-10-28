package buttons;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class UpButton extends Button {
	
	private ImageView upView; 
	
	public UpButton() {
		super();
		Image up = new Image(getClass().getClassLoader().getResourceAsStream("buttons/up_64.png"));
		upView = new ImageView(up);
		setGraphic(upView);
	}
	
	public UpButton(double x, double y) {
		this();
		setDimensions(x, y);
	}
	
	public void setDimensions(double x, double y) {
		setFitWidth(x);
		setFitHeight(y);
	}
	
	public void setFitWidth(double f) {
		upView.setFitWidth(f);
	}
	
	public void setFitHeight(double f) {
		upView.setFitHeight(f);
	}
	
	

}
