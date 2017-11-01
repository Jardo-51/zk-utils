package com.jardoapps.zk.utils.converters;

import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

import org.zkoss.bind.BindContext;
import org.zkoss.bind.Converter;
import org.zkoss.zk.ui.Component;

public class DateTimeStringConverter implements Converter<String, TemporalAccessor, Component> {

	private DateTimeFormatter getFormatter(BindContext ctx) {
		String format = (String) ctx.getConverterArg("format");

		if (format == null || format.isEmpty()) {
			throw new IllegalStateException("Property 'format' is not defined.");
		}

		return DateTimeFormatter.ofPattern(format);
	}

	@Override
	public String coerceToUi(TemporalAccessor beanProp, Component component, BindContext ctx) {

		if (beanProp == null) {
			return null;
		}

		DateTimeFormatter formatter = getFormatter(ctx);

		return formatter.format(beanProp);
	}

	@Override
	public TemporalAccessor coerceToBean(String compAttr, Component component, BindContext ctx) {
		throw new UnsupportedOperationException("Conversion from String is not supported.");
	}

}
