package dialogs;

import java.util.List;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public abstract class Dialog extends Stage {
	
	private VBox root;

	public Dialog(final Stage stage, String message) {
		super();
		setResizable(false);
		root = new VBox();
		root.setAlignment(Pos.CENTER);
		root.setSpacing(10);
		root.setPadding(new Insets(25, 25, 25, 25));
		root.getChildren().add(new Label(message));
		setScene(new Scene(root));
		if (stage != null) {
			List<String> styles = stage.getScene().getStylesheets();
			getScene().getStylesheets().addAll(styles);
		}
	}
	
	protected void addNode(Node node) {
		root.getChildren().add(node);
	}
	
	protected void addNode(int index, Node node) {
		root.getChildren().add(index, node);
	}
	
}
