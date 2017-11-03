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

		String key = String.format("%s.%s", beanProp.getClass().getSimpleName(), beanProp.name());
		return Labels.getLabel(key, beanProp.name());
	}

	@Override
	public Enum<?> coerceToBean(String compAttr, Component component, BindContext ctx) {
		throw new UnsupportedOperationException("Not implemented");
	}

}
