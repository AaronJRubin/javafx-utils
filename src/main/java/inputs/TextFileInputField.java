package inputs;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

import dialogs.ErrorBox;

import javafx.stage.Stage;

public class TextFileInputField extends FileInputField {
	
	String text;
	
	public TextFileInputField(Stage primaryStage, final List<String> permittedExtensions) {
		super(primaryStage, permittedExtensions);
	}
	
	public TextFileInputField(Stage primaryStage) {
		super(primaryStage, (List<String>) Arrays.asList(".txt"));
	}
	
	@Override
	protected void changedFile() {
		if (currentFile != null) {
			try {
				InputStreamReader r = new InputStreamReader(new FileInputStream(currentFile));
				long length = currentFile.length();
				char[] buffer = new char[(int) length];
				r.read(buffer);
				r.close();
				text = new String(buffer);
			} catch (IOException e) {
				ErrorBox err = new ErrorBox(primaryStage, "There was a failure reading this text file!");
				err.show();
				currentFile = null;
				setText("");
				text = "";
			}

		}
	}
}
