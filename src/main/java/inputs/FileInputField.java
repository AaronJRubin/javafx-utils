package inputs;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;

import dialogs.ErrorBox;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class FileInputField extends TextField {
	
	final private List<String> permittedExtensions;
	final protected Stage primaryStage;
	protected File currentFile;
	
	public FileInputField(final Stage primaryStage, final List<String> permittedExtensions) {
		super();
		this.primaryStage = primaryStage;
		this.permittedExtensions = permittedExtensions;
		setEditable(false);
		setOnDragOver(new EventHandler<DragEvent>() {
		    public void handle(DragEvent event) {
		        /* data is dragged over the target */
		        /* accept it only if it has files */
		        if (event.getDragboard().hasFiles()) {
		            /* allow for both copying and moving, whatever user chooses */
		            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
		        }
		        event.consume();
		    }
		});
		setOnDragEntered(new EventHandler<DragEvent>() {
			public void handle(DragEvent event) {
				/* the drag-and-drop gesture entered the target */
				/* show to the user that it is an actual gesture target */
				if (event.getDragboard().hasFiles()) {
					 setStyle("-fx-effect: innershadow(three-pass-box, gray, 12 , 0.5, 1, 1);");
				}
				event.consume();
			}
		});
		setOnDragExited(new EventHandler<DragEvent>() {
		    public void handle(DragEvent event) {
		        /* mouse moved away, remove the graphical cues */
		        setStyle("-fx-effect: null;");
		        event.consume();
		    }
		});
		setOnDragDropped(new EventHandler<DragEvent>() {
			@Override
			public void handle(DragEvent d) {
				Dragboard board = d.getDragboard();
				if (board.hasFiles()) {
					List<File> files = board.getFiles();
					File f = files.get(0);
					if (isPermitted(f, permittedExtensions)) {
						changeFile(f);
					} else {
						ErrorBox err = new ErrorBox(primaryStage, "This box only accepts files with the " +
								"following extension(s) : " + permittedExtensions);
						err.show();
					}
				}
			}
		});
	}
	
	private boolean isPermitted(File f, List<String> permittedExtensions) {
		if (permittedExtensions == null) {
			return true;
		} else {
			for (String s : permittedExtensions) {
				if (f.getName().endsWith(s)) {
					return true;
				}
			}
			return false;
		}
	}
	
	public static boolean isValidImage(File f) {
		String name = f.getName();
		String[] suffixes = ImageIO.getReaderFileSuffixes();
		for (String s : suffixes) {
			if (name.endsWith(s)) {
				return true;
			}
		}
		return false;
	}	
	
	public void changeFile(File f) {
		this.currentFile = f;
		setText(currentFile.getName());
		changedFile();
	}
	
	protected void changedFile() {
		return;
	}
	
	public File getFile() {
		return currentFile;
	}
	
	public Button getSelectorButton() {
		Button selectButton = new Button("Select a File");
		selectButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				FileChooser chooser = new FileChooser();
				List<String> extensions = new LinkedList<String>();
				for (String s : permittedExtensions) {
					extensions.add("*" + s);
				}
				chooser.getExtensionFilters().add(new ExtensionFilter("Text Files", extensions));
				File f = chooser.showOpenDialog(primaryStage);
				if (f != null) {
					changeFile(f);
				}
			}
		});
		return selectButton;
	}
	

}
