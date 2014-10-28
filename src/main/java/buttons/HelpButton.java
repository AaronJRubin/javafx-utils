package buttons;

import dialogs.MessageBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class HelpButton extends Button {
	
	String internalMessage;
	
	public HelpButton(final Stage primaryStage, String message) {
		super();
		setStyle("-fx-background-color: transparent;");
		this.internalMessage = message;
		ImageView helpButtonView = new ImageView();
		helpButtonView.setFitHeight(20);
		helpButtonView.setFitWidth(20);
		helpButtonView.setImage(new Image(HelpButton.class.getResourceAsStream("/info_64.png")));
		setGraphic(helpButtonView);
		setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				MessageBox dialog = new MessageBox(primaryStage, internalMessage);
				dialog.show();
			}
		});
	}
	
	public HelpButton(final Stage primaryStage) {
		this(primaryStage, "");
	}
	
	public void setMessage(String message) {
		this.internalMessage = message;
	}
	
}
