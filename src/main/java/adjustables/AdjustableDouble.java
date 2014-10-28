package adjustables;

import java.text.DecimalFormat;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class AdjustableDouble extends Adjustable {
	
	@SuppressWarnings("unused")
	private final double minValue;
	@SuppressWarnings("unused")
	private final double max;
	@SuppressWarnings("unused")
	private final double interval;
	
	public AdjustableDouble(String title, final double minValue, final double max, final double interval) {
		super(title);
		this.minValue = minValue;
		this.max = max;
		this.interval = interval;
		final DecimalFormat df = new DecimalFormat("#.#");
		setCurrentValue(Double.toString(minValue));
		setPlusButtonAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				double cur = Double.parseDouble(getCurrentValue());
				cur = Math.min(cur + interval, max);
				String curString = df.format(cur);
				if (curString.equals("0") || curString.equals("1")) {
					curString = curString + ".0";
				}
				setCurrentValue(curString);
			}
		});
		setMinusButtonAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				double cur = Double.parseDouble(getCurrentValue());
				cur = Math.max(cur - interval, minValue);
				String curString = df.format(cur);
				if (curString.equals("0") || curString.equals("1")) {
					curString = curString + ".0";
				}
				setCurrentValue(curString);
			}
		});
	}
}
