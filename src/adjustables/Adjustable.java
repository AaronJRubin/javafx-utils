package adjustables;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

abstract class Adjustable extends GridPane {
	
	private Button plusButton;
	private Button minusButton;
	private Label currentValue;
	
	Adjustable(String title) {
		setHgap(10);
		Label label = new Label(title);
		GridPane.setHalignment(label, HPos.CENTER);
		plusButton = sizedButton("+");
		minusButton = sizedButton("-");
		currentValue = new Label("");
		add(label, 0, 0, 2, 1);
		add(plusButton, 0, 1);
		add(minusButton, 0, 2);
		add(currentValue, 1, 1, 1, 2);
	}
	
	private Button sizedButton(String text) {
		Button toReturn = new Button(text);
		toReturn.setMinWidth(30);
		return toReturn;
	}
	
	protected void setPlusButtonAction(EventHandler<ActionEvent> e) {
		plusButton.setOnAction(e);
	}
	
	protected void setMinusButtonAction(EventHandler<ActionEvent> e) {
		minusButton.setOnAction(e);
	}
	
	
	public String getCurrentValue() {
		return currentValue.getText();
	}
	
	protected void setCurrentValue(String value) {
		currentValue.setText(value);
	}

}
