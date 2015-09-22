package bl4ckscor3.misc.bl4ckchat.custom;

import bl4ckscor3.misc.bl4ckchat.util.Reference;
import javafx.scene.control.Label;

public class CustomLabel extends Label
{
	public CustomLabel(String text)
	{
		super(text);
		
		setFont(Reference.DEFAULT_FONT);
	}
	
	public void setPosition(double x, double y)
	{
		setLayoutX(x);
		setLayoutY(y);
	}
}
