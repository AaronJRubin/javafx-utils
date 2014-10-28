package inputs;

import java.awt.image.BufferedImage;
import java.util.Arrays;

import javax.imageio.ImageIO;

import dialogs.ErrorBox;

import javafx.stage.Stage;

public class ImageFileInputField extends FileInputField {
	
	private BufferedImage currentImage;
	
	public ImageFileInputField(final Stage primaryStage) {//, final List<String> permittedExtensions) {
		super(primaryStage, Arrays.asList(ImageIO.getReaderFileSuffixes()));
	}

	@Override
	protected void changedFile() {
		if (currentFile != null) {
			try {
				currentImage = ImageIO.read(currentFile);
			} catch (Exception e) {
				ErrorBox err = new ErrorBox(primaryStage, "An error occurred with reading this file!");
				err.show();
				currentImage = null;
				currentFile = null;
				setText("");
			}
		}
	}
	
	public BufferedImage getImg() {
		return currentImage;
	}
		
}

