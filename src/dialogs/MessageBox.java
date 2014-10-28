package dialogs;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class MessageBox extends Dialog {
	
	Button closeButton;

	public MessageBox(Stage stage, String message) {
		super(stage, message);
		closeButton = new Button("Close");
		closeButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent actionEvent) {
				close();
			}
		});
		HBox buttonBox = new HBox();
		buttonBox.getChildren().add(closeButton);
		buttonBox.setAlignment(Pos.CENTER);
		addNode(buttonBox);
	}
	
	public void setOnClose(final EventHandler<WindowEvent> e) {
		setOnCloseRequest(e);
		final MessageBox me = this;
		closeButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent q) {
				e.handle(new WindowEvent(me, WindowEvent.WINDOW_CLOSE_REQUEST));
				close();
			}
		});
	}

}
