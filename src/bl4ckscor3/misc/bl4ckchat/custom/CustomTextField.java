package bl4ckscor3.misc.bl4ckchat.custom;

import javafx.scene.control.TextField;

public class CustomTextField extends TextField
{
	public CustomTextField()
	{
		super();
	}
	
	public void setPosition(double x, double y)
	{
		setLayoutX(x);
		setLayoutY(y);
	}
}
