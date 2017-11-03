package com.jardoapps.zk.utils.converters;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.zkoss.bind.BindContext;
import org.zkoss.bind.Converter;
import org.zkoss.zk.ui.Component;

public class LocalDateTimeConverter implements Converter<Date, LocalDateTime, Component> {

	@Override
	public Date coerceToUi(LocalDateTime beanProp, Component component, BindContext ctx) {

		if (beanProp == null) {
			return null;
		}

		return Date.from(beanProp.atZone(ZoneId.systemDefault()).toInstant());
	}

	@Override
	public LocalDateTime coerceToBean(Date compAttr, Component component, BindContext ctx) {

		if (compAttr == null) {
			return null;
		}

		return Instant.ofEpochMilli(compAttr.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
	}

}
