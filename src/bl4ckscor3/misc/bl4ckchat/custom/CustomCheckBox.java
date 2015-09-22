package bl4ckscor3.misc.bl4ckchat.custom;

import javafx.scene.control.CheckBox;

public class CustomCheckBox extends CheckBox
{
	public CustomCheckBox(String text)
	{
		super(text);
	}
	
	public void setPosition(double x, double y)
	{
		setLayoutX(x);
		setLayoutY(y);
	}
}
