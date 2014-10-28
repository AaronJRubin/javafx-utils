package adjustables;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class AdjustableInt extends Adjustable {
	
	@SuppressWarnings("unused")
	private final int minValue;
	@SuppressWarnings("unused")
	private final int max;
	@SuppressWarnings("unused")
	private final int interval;
	
	public AdjustableInt(String title, final int minValue, final int max, final int interval) {
		super(title);
		this.minValue = minValue;
		this.max = max;
		this.interval = interval;
		setCurrentValue(Integer.toString(minValue));
		setPlusButtonAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				int cur = Integer.parseInt(getCurrentValue());
				cur = Math.min(cur + interval, max);
				setCurrentValue(Integer.toString(cur));
			}
		});
		setMinusButtonAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				int cur = Integer.parseInt(getCurrentValue());
				cur = Math.max(cur - interval, minValue);
				setCurrentValue(Integer.toString(cur));
			}
		});
	}
	
}
