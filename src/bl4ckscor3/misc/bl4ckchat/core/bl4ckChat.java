package bl4ckscor3.misc.bl4ckchat.core;

import bl4ckscor3.misc.bl4ckchat.listener.CloseListener;
import bl4ckscor3.misc.bl4ckchat.listener.NumberTextFieldListener;
import bl4ckscor3.misc.bl4ckchat.util.CustomButton;
import bl4ckscor3.misc.bl4ckchat.util.CustomLabel;
import bl4ckscor3.misc.bl4ckchat.util.CustomTextField;
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
	public static CustomTextField portField = new CustomTextField();
	public static CustomTextField nickservField = new CustomTextField();
	public static CustomTextField channelField = new CustomTextField();
	
	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception //stage is the whole window and scene is what is inside
	{
		CustomLabel header = new CustomLabel("Network Setup");
		CustomLabel nameLabel = new CustomLabel("Your name:");
		CustomLabel networkLabel = new CustomLabel("Network:");
		CustomLabel portLabel = new CustomLabel("Port:");
		CustomLabel nickservLabel = new CustomLabel("NickServ Password:");
		CustomLabel channelLabel = new CustomLabel("Channels:");
		CustomButton connect = new CustomButton("Connect...");
		Pane layout = new Pane();
		Scene scene;

		stage.setTitle("bl4ckChat Network Setup ("+ Reference.VERSION +")");
		stage.setResizable(false);
		stage.setOnCloseRequest(new CloseListener());
		
		header.setPosition(190, 10);
		header.setFont(new Font("Arial", 18));
		layout.getChildren().add(header);

		nameLabel.setPosition(30, 53);
		nameField.setPosition(160, 50);
		layout.getChildren().add(nameLabel);
		layout.getChildren().add(nameField);

		networkLabel.setPosition(30, 83);
		networkField.setPosition(160, 80);
		layout.getChildren().add(networkLabel);
		layout.getChildren().add(networkField);

		portLabel.setPosition(30, 113);
		portField.setPosition(160, 110);
		portField.textProperty().addListener(new NumberTextFieldListener());
		layout.getChildren().add(portLabel);
		layout.getChildren().add(portField);

		nickservLabel.setPosition(30, 143);
		nickservField.setPosition(160, 140);
		layout.getChildren().add(nickservLabel);
		layout.getChildren().add(nickservField);
	
		channelLabel.setPosition(30, 173);
		channelField.setPosition(160, 170);
		layout.getChildren().add(channelLabel);
		layout.getChildren().add(channelField);
		
		connect.register("network_connect");
		connect.setPosition(400, 490);
		connect.setOnAction(Reference.buttonListener);
		layout.getChildren().add(connect);

		scene = new Scene(layout, 500, 600);
		stage.setScene(scene);
		Reference.buttonListener.setStage(stage);
		stage.show();
	}
}
