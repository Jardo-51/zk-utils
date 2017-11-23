package com.jardoapps.zk.utils.converters;

import org.zkoss.bind.BindContext;
import org.zkoss.bind.Converter;
import org.zkoss.util.resource.Labels;
import org.zkoss.zk.ui.Component;

public class EnumLabelConverter implements Converter<String, Enum<?>, Component> {

	@Override
	public String coerceToUi(Enum<?> beanProp, Component component, BindContext ctx) {

		if (beanProp == null) {
			return null;
		}

		String key = getKey(beanProp, ctx);
		return Labels.getLabel(key, beanProp.name());
	}

	@Override
	public Enum<?> coerceToBean(String compAttr, Component component, BindContext ctx) {
		throw new UnsupportedOperationException("Not implemented");
	}

	private String getKey(Enum<?> beanProp, BindContext ctx) {

		String contextArg = (String) ctx.getConverterArg("context");

		if (contextArg != null) {
			return String.format("%s[%s].%s", beanProp.getClass().getSimpleName(), contextArg, beanProp.name());
		} else {
			return String.format("%s.%s", beanProp.getClass().getSimpleName(), beanProp.name());
		}
	}

}
