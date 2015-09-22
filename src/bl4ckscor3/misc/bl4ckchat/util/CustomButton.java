package bl4ckscor3.misc.bl4ckchat.util;

import javafx.scene.Cursor;
import javafx.scene.control.Button;

public class CustomButton extends Button
{
	public CustomButton(String text)
	{
		super(text);
		
		setCursor(Cursor.HAND);
	}
	
	public void register(String id)
	{
		Reference.buttonListener.add(this, id);
	}
	
	public void setPosition(double x, double y)
	{
		setLayoutX(x);
		setLayoutY(y);
	}
}
