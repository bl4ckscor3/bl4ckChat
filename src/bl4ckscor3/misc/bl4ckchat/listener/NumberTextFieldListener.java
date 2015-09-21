package bl4ckscor3.misc.bl4ckchat.listener;

import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class NumberTextFieldListener implements ChangeListener<String>
{
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
