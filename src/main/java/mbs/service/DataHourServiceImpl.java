package mbs.service;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DataHourServiceImpl implements DataHourService {

	@Override
	public Date getDataFromLocal(String idLocale) throws Exception {

		Date nowUtc = new Date();
		TimeZone timeZone = TimeZone.getTimeZone(idLocale);

		Calendar calendar = Calendar.getInstance(timeZone);
		calendar.setTime(nowUtc);
		return  calendar.getTime();		

	}

}
