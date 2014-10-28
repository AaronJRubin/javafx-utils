package dialogs;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
//import javafx.scene.input.MouseEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmationBox extends Dialog {

    private final Button confirmButton;
    private final Button cancelButton;

    public ConfirmationBox(final Stage stage, String message) {
        super(stage, message);
    	initModality(Modality.WINDOW_MODAL);
		initOwner(stage);
		/*
        EventHandler<MouseEvent> close = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
             //   stage.getScene().getRoot().setEffect(null);
                close();
            }
        }; */
        
        EventHandler<ActionEvent> close = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
             //   stage.getScene().getRoot().setEffect(null);
                close();
            }
        };
        confirmButton = new Button("Confirm");
        confirmButton.setDefaultButton(true);
 //       confirmButton.addEventHandler(MouseEvent.MOUSE_CLICKED, eitherButtonPressed);
        confirmButton.setOnAction(close);
        cancelButton = new Button("Cancel");
        cancelButton.setCancelButton(true);
        cancelButton.setOnAction(close);
        /*
        cancelButton.setOnAction(new EventHandler<ActionEvent> () {
        	@Override
        	public void handle(ActionEvent e) {
        		close();
        	}
        });
        cancelButton.addEventHandler(MouseEvent.MOUSE_CLICKED, eitherButtonPressed); */
        HBox gridButtons = new HBox();
        gridButtons.getChildren().addAll(confirmButton, cancelButton);
        gridButtons.setAlignment(Pos.CENTER);
        addNode(gridButtons);
    }
    
    private EventHandler<ActionEvent> addCloseToHandler(final EventHandler<ActionEvent> input) {
    	return new EventHandler<ActionEvent>() {
    		@Override
    		public void handle(ActionEvent e) {
    			input.handle(e);
    			close();
    		}
    	};
    }

    public void setConfirmButtonAction(EventHandler<ActionEvent> eventHandler) {
    //    confirmButton.setOnAction(eventHandler);
    	confirmButton.setOnAction(addCloseToHandler(eventHandler));
    }

    public void setCancelButtonAction(EventHandler<ActionEvent> eventHandler) {
    	cancelButton.setOnAction(addCloseToHandler(eventHandler));
   //     cancelButton.setOnAction(eventHandler);
    }

}
