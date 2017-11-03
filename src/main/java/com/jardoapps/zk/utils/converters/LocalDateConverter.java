package com.jardoapps.zk.utils.converters;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.zkoss.bind.BindContext;
import org.zkoss.bind.Converter;
import org.zkoss.zk.ui.Component;

public class LocalDateConverter implements Converter<Date, LocalDate, Component> {

	@Override
	public Date coerceToUi(LocalDate beanProp, Component component, BindContext ctx) {

		if (beanProp == null) {
			return null;
		}

		return Date.from(beanProp.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
	}

	@Override
	public LocalDate coerceToBean(Date compAttr, Component component, BindContext ctx) {

		if (compAttr == null) {
			return null;
		}

		return Instant.ofEpochMilli(compAttr.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
	}

}
