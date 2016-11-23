package fpt.com.pcHardwareShop.util;

import com.thoughtworks.xstream.converters.SingleValueConverter;

import javafx.beans.property.SimpleDoubleProperty;

public class SingleValuePrice implements SingleValueConverter {

	@Override
	public boolean canConvert(Class arg0) {
		return SimpleDoubleProperty.class.equals(arg0);
	}

	@Override
	public Object fromString(String arg0) {
		return new SimpleDoubleProperty(Double.parseDouble(arg0));
	}

	@Override
	public String toString(Object arg0) {
		double number = ((SimpleDoubleProperty)arg0).getValue();
		
		String temp = String.format("%3.2f", number); //2 Nachkommasellen
		return temp;
	}

}
