package fpt.com.pcHardwareShop.util;

import com.thoughtworks.xstream.converters.SingleValueConverter;

import javafx.beans.property.SimpleStringProperty;

public class SingleValueName implements SingleValueConverter {

	@Override
	public boolean canConvert(Class arg0) {
		return SimpleStringProperty.class.equals(arg0);
	}

	@Override
	public Object fromString(String arg0) {
		return (Object) new SimpleStringProperty().getValue();	
	}

	@Override
	public String toString(Object arg0) {
		return SimpleStringProperty.class.toString();
	}

}
