package styles;


public class Styles {
	
	private Styles() {
	}
	
	public static String getStylesheet() {
		return (Styles.class.getResource("stylesheet.css").toExternalForm());
	}

}
