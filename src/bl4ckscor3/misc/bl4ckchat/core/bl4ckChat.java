package bl4ckscor3.misc.bl4ckchat.core;

import bl4ckscor3.misc.bl4ckchat.custom.CustomButton;
import bl4ckscor3.misc.bl4ckchat.custom.CustomCheckBox;
import bl4ckscor3.misc.bl4ckchat.custom.CustomLabel;
import bl4ckscor3.misc.bl4ckchat.custom.CustomNumberTextField;
import bl4ckscor3.misc.bl4ckchat.custom.CustomPasswordField;
import bl4ckscor3.misc.bl4ckchat.custom.CustomTextField;
import bl4ckscor3.misc.bl4ckchat.listener.CloseListener;
import bl4ckscor3.misc.bl4ckchat.util.Reference;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class bl4ckChat extends Application
{
	public static CustomTextField nameField = new CustomTextField();
	public static CustomTextField networkField = new CustomTextField();
	public static CustomNumberTextField portField = new CustomNumberTextField();
	public static CustomPasswordField serverPasswordField = new CustomPasswordField();
	public static CustomPasswordField nickservField = new CustomPasswordField();
	public static CustomTextField channelField = new CustomTextField();
	public static CustomCheckBox sslBox = new CustomCheckBox("Use SSL connection", "Make sure to put in the correct SSL port of your network.");
	private static boolean shouldIncrementByThree = false;
	private static int currentYPosition = 30;
	
	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception //stage is the whole window and scene is what is inside
	{
		CustomLabel header = new CustomLabel("Network Setup");
		CustomLabel nameLabel = new CustomLabel("Your name:", "This will be your ident, too.");
		CustomLabel networkLabel = new CustomLabel("Network:");
		CustomLabel portLabel = new CustomLabel("Port:", "If you use SSL, make sure to put in the correct SSL port of your network.");
		CustomLabel serverPasswordLabel = new CustomLabel("Server password:");
		CustomLabel nickservLabel = new CustomLabel("NickServ Password:");
		CustomLabel channelLabel = new CustomLabel("Channels:", "Seperate multiple channels with a comma.");
		CustomButton connect = new CustomButton("Connect...");
		Pane layout = new Pane();
		Scene scene;

		stage.setTitle("bl4ckChat Network Setup ("+ Reference.VERSION +")");
		stage.setResizable(false);
		stage.setOnCloseRequest(new CloseListener());	
		
		header.setPosition(190, 10);
		header.setFont(new Font("Arial", 18));
		layout.getChildren().add(header);

		nameField.setPosition(160, getNextY());
		nameLabel.setPosition(30, getNextY());
		layout.getChildren().add(nameLabel);
		layout.getChildren().add(nameField);

		networkField.setPosition(160, getNextY());
		networkLabel.setPosition(30, getNextY());
		layout.getChildren().add(networkLabel);
		layout.getChildren().add(networkField);

		portField.setPosition(160, getNextY());
		portLabel.setPosition(30, getNextY());
		layout.getChildren().add(portLabel);
		layout.getChildren().add(portField);

		serverPasswordField.setPosition(160, getNextY());
		serverPasswordLabel.setPosition(30, getNextY());
		layout.getChildren().add(serverPasswordLabel);
		layout.getChildren().add(serverPasswordField);
		
		nickservField.setPosition(160, getNextY());
		nickservLabel.setPosition(30, getNextY());
		layout.getChildren().add(nickservLabel);
		layout.getChildren().add(nickservField);

		channelField.setPosition(160, getNextY());
		channelLabel.setPosition(30, getNextY());
		layout.getChildren().add(channelLabel);
		layout.getChildren().add(channelField);
		
		sslBox.setPosition(30, 493);
		layout.getChildren().add(sslBox);
		
		connect.register("network_connect");
		connect.setPosition(230, 490);
		connect.setOnAction(Reference.buttonListener);
		layout.getChildren().add(connect);

		scene = new Scene(layout, 500, 600);
		stage.setScene(scene);
		Reference.buttonListener.setStage(stage);
		stage.show();
	}
	
	private static int getNextY()
	{
		if(shouldIncrementByThree)
			currentYPosition += 3;
		else
			currentYPosition += 30;

		shouldIncrementByThree = !shouldIncrementByThree;
		return currentYPosition;
	}
}
