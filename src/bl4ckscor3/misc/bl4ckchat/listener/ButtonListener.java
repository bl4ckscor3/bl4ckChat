package bl4ckscor3.misc.bl4ckchat.listener;


import org.pircbotx.Configuration;
import org.pircbotx.PircBotX;

import bl4ckscor3.misc.bl4ckchat.core.bl4ckChat;
import bl4ckscor3.misc.bl4ckchat.util.Reference;
import bl4ckscor3.misc.bl4ckchat.util.android.ArrayMap;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ButtonListener implements EventHandler<ActionEvent>
{
	private static final ArrayMap<String,Button> buttons = new ArrayMap<String,Button>();

	@Override
	public void handle(ActionEvent event)
	{
		if(event.getSource() == buttons.get("network_connect"))
		{
			if(bl4ckChat.nameField.equals(""))
			{
				System.out.println("Please fill out the name field.");
				return;
			}
			
			if(bl4ckChat.networkField.equals(""))
			{
				System.out.println("Please fill out the network field.");
				return;
			}
			
			if(bl4ckChat.portField.equals(""))
				bl4ckChat.portField.setText("6669");
			
			try
			{
				Configuration<PircBotX> config = new Configuration.Builder<PircBotX>()
						.setName(bl4ckChat.nameField.getText())
						.setLogin(bl4ckChat.nameField.getText())
						.setServer(bl4ckChat.networkField.getText(), Integer.parseInt(bl4ckChat.portField.getText()))
						.setAutoNickChange(true)
						.setMessageDelay(0)
						.buildConfiguration();
				Reference.bot = new PircBotX(config);
				Reference.bot.startBot();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else
			System.out.println("BUTTON NOT REGISTERED");
	}

	public static void add(String id, Button button)
	{
		if(!buttons.containsKey(id))
			buttons.put(id, button);
		else
			System.out.println("ID " + id + " ALREADY REGISTERED");
	}
}
