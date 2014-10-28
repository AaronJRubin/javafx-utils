package inputs;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;


public class IntegerInput extends TextField {

	private int maxDigits;

	public IntegerInput(final Integer defaultValue) {
		super();
		maxDigits = 3;
		int width = maxDigits * 13;
		setMinWidth(width);
		setMaxWidth(width);
		if (defaultValue != null) {
			setText(Integer.toString(defaultValue));
			focusedProperty().addListener(new ChangeListener<Boolean>() {
				@Override
				public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
				{
					if (newPropertyValue) {
						//     System.out.println("Textfield on focus");
					}
					else {
						if (getText().equals("")) {
							setText(Integer.toString(defaultValue));
						} else if (Integer.parseInt(getText()) == 0) {
							/* Yes, I do not allow 0 when there is a 
							 * non-zero default value. This could of course
							 * be changed, or a boolean argument could be
							 * passed to this constructor to make this an 
							 * optional feature
							 */
							setText(Integer.toString(defaultValue));
						} else {
							setText(Integer.toString(Integer.parseInt(getText())));
						}
						//  System.out.println("Textfield out focus");
					}
				}
			});
		}
	}
	
	@Override
	public void replaceText(int start, int end, String text) {
		if (!text.equals("")) {
			if (!text.matches("[0-9]")) {
				return;
			}
		}
		if (getText().length() < maxDigits || text.equals("")) {
			super.replaceText(start, end, text);
		}
	}

	@Override
	public void replaceSelection(String text) {
		if (!text.equals("")) {
			if (!text.matches("[0-9]")) {
				return;
			}
		}
		super.replaceSelection(text);
		if (getText().length() > maxDigits) {
			String maxSubString = getText().substring(0,  maxDigits);
			setText(maxSubString);
			positionCaret(maxDigits);
		}
	}

	public int getInt() {
		try {
			return Integer.parseInt(getText());
		} catch (Exception e) {
			System.err.println("Empty text field?");
			return 0;
		}
	}
	
	public void setInt(int newInt) {
		setText(Integer.toString(newInt));
	}

}
