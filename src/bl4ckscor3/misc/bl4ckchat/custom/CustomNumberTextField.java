package bl4ckscor3.misc.bl4ckchat.custom;

import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class CustomNumberTextField extends CustomTextField implements ChangeListener<String>
{
	public CustomNumberTextField()
	{
		super();
		
		textProperty().addListener(this);
	}	
	
	@Override
	public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue)
	{
		if(newValue.equals(""))
			return;
		
		try
		{
			Integer.valueOf(newValue);
		}
		catch(Exception e)
		{
			((StringProperty)observable).setValue(oldValue);
		}
	}
}
