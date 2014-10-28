package dialogs;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ErrorBox extends MessageBox {

	public ErrorBox(Stage stage, String message) {
		super(stage, message);
		initModality(Modality.WINDOW_MODAL);
		initOwner(stage);
	}
	
}
