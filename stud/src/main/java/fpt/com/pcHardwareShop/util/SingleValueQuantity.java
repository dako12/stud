package fpt.com.pcHardwareShop.util;

import com.thoughtworks.xstream.converters.SingleValueConverter;

import javafx.beans.property.SimpleIntegerProperty;

public class SingleValueQuantity implements SingleValueConverter {

	@SuppressWarnings("rawtypes")
	@Override
	public boolean canConvert( Class arg0) {
		return SimpleIntegerProperty.class.equals(arg0);
	
	}

	@Override
	public Object fromString(String arg0) {
		return (Object) new SimpleIntegerProperty(Integer.parseInt(arg0));
	}

	@Override
	public String toString(Object arg0) {
		return SimpleIntegerProperty.class.toString();
		}

}
