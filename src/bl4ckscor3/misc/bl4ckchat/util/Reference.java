package bl4ckscor3.misc.bl4ckchat.util;

import org.pircbotx.PircBotX;

import bl4ckscor3.misc.bl4ckchat.listener.ButtonListener;
import javafx.scene.text.Font;

public class Reference
{
	public static final Font DEFAULT_FONT = new Font("System Regular", 14);
	public static final String VERSION = "v0.1";
	public static final ButtonListener buttonListener = new ButtonListener();
	public static PircBotX bot;
	public static boolean isBotStarted = false;
}
