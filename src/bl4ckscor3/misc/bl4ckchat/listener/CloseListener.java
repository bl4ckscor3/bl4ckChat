package bl4ckscor3.misc.bl4ckchat.listener;

import bl4ckscor3.misc.bl4ckchat.util.Reference;
import javafx.event.EventHandler;
import javafx.stage.WindowEvent;

public class CloseListener implements EventHandler<WindowEvent>
{
	@Override
	public void handle(WindowEvent event)
	{
		if(Reference.isBotStarted)
			Reference.bot.sendIRC().quitServer("bl4ckChat, a crappy IRC Client");
	}
}
