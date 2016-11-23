package fpt.com.pcHardwareShop.util;

import com.thoughtworks.xstream.converters.SingleValueConverter;

import javafx.beans.property.SimpleLongProperty;

public class SingleValueID implements SingleValueConverter {

	@Override
	public boolean canConvert(Class arg0) {
		return SimpleLongProperty.class.equals(arg0);
	}

	@Override
	public Object fromString(String arg0) {
		return (Object) new Long(arg0);
	}

	@Override
	public String toString(Object arg0) {
		return SimpleLongProperty.class.toString();
	}

}
