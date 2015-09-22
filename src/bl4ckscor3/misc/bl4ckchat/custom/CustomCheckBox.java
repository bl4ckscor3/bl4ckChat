package bl4ckscor3.misc.bl4ckchat.custom;

import javafx.scene.control.CheckBox;
import javafx.scene.control.Tooltip;

public class CustomCheckBox extends CheckBox
{
	public CustomCheckBox(String text)
	{
		super(text);
	}
	
	public CustomCheckBox(String text, String tooltip)
	{
		super(text);
		
		setTooltip(new Tooltip(tooltip));
	}
	
	public void setPosition(double x, double y)
	{
		setLayoutX(x);
		setLayoutY(y);
	}
}
