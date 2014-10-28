package dialogs;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TextInputDialog extends ConfirmationBox {
	
	private TextField input;

	public TextInputDialog(Stage stage, String message) {
		super(stage, message);
		input = new TextField();
		input.setMinHeight(20);
		addNode(1, input);
	}
	
	public String getInput() {
		return input.getText();
	}
	

}

