package com.roy.configuration;

import org.apache.commons.lang.StringUtils;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author dingyawu
 * @version 1.0
 * @date created in 11:55 2021-02-28
 */
public class DateConverter implements Converter<String, Date> {

  private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy,MM,dd");

  @Override
  public Date convert(String source) {
    if (StringUtils.isEmpty(source)) {
      return null;
    }
    try {
      simpleDateFormat.parse(source);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return null;
  }
}
