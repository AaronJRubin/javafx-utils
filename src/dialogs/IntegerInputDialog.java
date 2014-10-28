package dialogs;

import inputs.IntegerInput;
import javafx.stage.Stage;

public class IntegerInputDialog extends ConfirmationBox {
	
	private IntegerInput input;

	public IntegerInputDialog(Stage stage, String message, int def) {
		super(stage, message);
		input = new IntegerInput(def);
		input.setMinHeight(20);
		addNode(1, input);
	}
	
	public int getInput() {
		return input.getInt();
	}
	
	

}
