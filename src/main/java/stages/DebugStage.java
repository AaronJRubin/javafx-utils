package stages;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class DebugStage extends Stage {
	
//	HBox box;
//	Label message;
	
	public DebugStage() {
		super();
		Label message = new Label("Nothing to report");
	//	HBox.setHgrow(message, Priority.ALWAYS);
		HBox box = new HBox();
		box.setPadding(new Insets(10, 10, 10, 10));
		box.getChildren().add(message);
		setScene(new Scene(box));
	}

	public void setMessage(String newMessage) {
		//	message.setText(newMessage);
		//	HBox.setHgrow(message, Priority.ALWAYS);
		HBox box = new HBox();
		box.setPadding(new Insets(10, 10, 10, 10));
		box.getChildren().add(new Label(newMessage));
		setScene(new Scene(box));
		/*
		box.getChildren().clear();
		box.getChildren().add(new Label(newMessage));
		setScene(new Scene(box)); */
	//	setHeight(box.getHeight());// + box.getPadding().getTop() + box.getPadding().getBottom());
	//	setWidth(box.getWidth());// + box.getPadding().getLeft() + box.getPadding().getRight());
	}

}
