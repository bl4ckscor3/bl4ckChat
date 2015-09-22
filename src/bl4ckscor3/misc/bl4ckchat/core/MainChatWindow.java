package bl4ckscor3.misc.bl4ckchat.core;

import bl4ckscor3.misc.bl4ckchat.util.Reference;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainChatWindow
{
	public MainChatWindow(Stage stage)
	{
		Pane layout = new Pane();
		Scene scene;
		
		stage.setTitle("bl4ckChat ("+ Reference.VERSION +")");
		
		scene = new Scene(layout, 1600, 900);
		stage.setScene(scene);
		stage.show();
	}
}
