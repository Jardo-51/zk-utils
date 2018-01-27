package com.jardoapps.zk.utils.converters;

import org.zkoss.bind.BindContext;
import org.zkoss.bind.Converter;
import org.zkoss.util.resource.Labels;
import org.zkoss.zk.ui.Component;

public class EnumLabelConverter implements Converter<String, Enum<?>, Component> {

	public static String toString(Enum<?> value) {
		return toString(value, null);
	}

	public static String toString(Enum<?> value, String context) {

		if (value == null) {
			return null;
		}

		String key = getKey(value, context);
		return Labels.getLabel(key, value.name());
	}

	@Override
	public String coerceToUi(Enum<?> beanProp, Component component, BindContext ctx) {
		String contextArg = (String) ctx.getConverterArg("context");
		return toString(beanProp, contextArg);
	}

	@Override
	public Enum<?> coerceToBean(String compAttr, Component component, BindContext ctx) {
		throw new UnsupportedOperationException("Not implemented");
	}

	private static String getKey(Enum<?> beanProp, String contextArg) {

		if (contextArg != null) {
			return String.format("%s[%s].%s", beanProp.getClass().getSimpleName(), contextArg, beanProp.name());
		} else {
			return String.format("%s.%s", beanProp.getClass().getSimpleName(), beanProp.name());
		}
	}

}
