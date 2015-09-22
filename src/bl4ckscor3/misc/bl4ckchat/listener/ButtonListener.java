package bl4ckscor3.misc.bl4ckchat.listener;

import java.lang.reflect.InvocationTargetException;

import javax.swing.SwingUtilities;

import org.pircbotx.Configuration;
import org.pircbotx.PircBotX;
import org.pircbotx.UtilSSLSocketFactory;

import bl4ckscor3.misc.bl4ckchat.core.MainChatWindow;
import bl4ckscor3.misc.bl4ckchat.core.bl4ckChat;
import bl4ckscor3.misc.bl4ckchat.util.BotConfiguration;
import bl4ckscor3.misc.bl4ckchat.util.Reference;
import bl4ckscor3.misc.bl4ckchat.util.android.ArrayMap;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;

@SuppressWarnings("unused")
public class ButtonListener implements EventHandler<ActionEvent>
{
	private static final ArrayMap<Button,String> buttons = new ArrayMap<Button,String>();
	private static Stage stage;
	
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
		final BotConfiguration cfg = new BotConfiguration(bl4ckChat.nameField.getText(), bl4ckChat.networkField.getText(), bl4ckChat.portField.getText(), bl4ckChat.nickservField.getText(), bl4ckChat.channelField.getText(), !bl4ckChat.sslBox.isDisabled());
		
		stage.close();
		new MainChatWindow(stage);
		
		SwingUtilities.invokeLater(() -> {
			boolean fail = false;
			
			if(cfg.getName().equals(""))
			{
				cfg.setName("bl4ckChat");
//				System.out.println("Please fill out the name field.");
//				fail = true;
			}

			if(cfg.getNetwork().equals(""))
			{
				cfg.setNetwork("irc.esper.net");
//				System.out.println("Please fill out the network field.");
//				fail = true;
			}

			if(cfg.getPort() == 0)
				cfg.setPort(6669);

			if(!fail)
			{
				try
				{
					Configuration.Builder<PircBotX> config = new Configuration.Builder<PircBotX>()
							.setName(cfg.getName())
							.setLogin(cfg.getName())
							.setServer(cfg.getNetwork(), cfg.getPort())
							.setAutoNickChange(false)
							.setMessageDelay(0);
					
					if(!cfg.getNickserv().equals(""))
						config.setNickservPassword(cfg.getNickserv());
					
					if(cfg.getChannels().length != 0)
					{
						for(String s : cfg.getChannels())
						{
							config.addAutoJoinChannel(s);
						}
					}
					
					if(cfg.useSsl())
						config.setSocketFactory(new UtilSSLSocketFactory().trustAllCertificates());
					
					Reference.bot = new PircBotX(config.buildConfiguration());
					Reference.isBotStarted = true;
					Reference.bot.startBot();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	public void add(Button button, String id)
	{
		if(!buttons.containsValue(id))
			buttons.put(button, id);
		else
			System.out.println("ID " + id + " ALREADY REGISTERED");
	}
	
	public void setStage(Stage s)
	{
		stage = s;
	}
}
