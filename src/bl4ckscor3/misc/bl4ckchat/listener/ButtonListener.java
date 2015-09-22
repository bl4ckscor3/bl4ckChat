package bl4ckscor3.misc.bl4ckchat.listener;

import java.lang.reflect.InvocationTargetException;

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
	private static final ArrayMap<Button,String> buttons = new ArrayMap<Button,String>();

	@Override
	public void handle(ActionEvent event)
	{
		try
		{
			getClass().getDeclaredMethod(buttons.get(event.getSource()), ActionEvent.class).invoke(this, event);
		}
		catch(IllegalAccessException | IllegalArgumentException | InvocationTargetException | SecurityException e)
		{
			e.printStackTrace();
		}
		catch(NullPointerException e)
		{
			System.out.println("BUTTON NOT REGISTERED");
		}
		catch(NoSuchMethodException e)
		{
			System.out.println("METHOD FOR BUTTON NOT DECLARED");
		}
	}

	private void network_connect(ActionEvent event)
	{
		boolean fail = false;
		
		if(bl4ckChat.nameField.getText().equals(""))
		{
			System.out.println("Please fill out the name field.");
			fail = true;
		}

		if(bl4ckChat.networkField.getText().equals(""))
		{
			System.out.println("Please fill out the network field.");
			fail = true;
		}

		if(bl4ckChat.portField.getText().equals(""))
			bl4ckChat.portField.setText("6669");

		if(!fail)
		{
			try
			{
				Configuration<PircBotX> config = new Configuration.Builder<PircBotX>()
						.setName(bl4ckChat.nameField.getText())
						.setLogin(bl4ckChat.nameField.getText())
						.setServer(bl4ckChat.networkField.getText(), Integer.parseInt(bl4ckChat.portField.getText()))
						.setAutoNickChange(false)
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
	}
	
	public static void add(Button button, String id)
	{
		if(!buttons.containsKey(id))
			buttons.put(button, id);
		else
			System.out.println("ID " + id + " ALREADY REGISTERED");
	}
}
