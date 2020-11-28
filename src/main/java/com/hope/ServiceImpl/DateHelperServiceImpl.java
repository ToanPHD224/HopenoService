package com.hope.ServiceImpl;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.hope.Service.DateHelperService;
@Service
public class DateHelperServiceImpl implements DateHelperService {

	@Override
	public Date convetDatetoSql(String date) {
		int[] dates = Stream.of(date.split("-"))
				  .mapToInt(Integer::parseInt)
				  .toArray();
		Date date1 = java.sql.Date.valueOf(LocalDate.of(dates[0], dates[1], dates[2]));
		
		return date1;
	}
	public String getMinutes(Date date)
	{
		Date d1 = new Date();
		long seconds = (d1.getTime()-date.getTime())/1000;
		if(seconds<=60)
		{
			return "1 Phút Trước";
		}
		else if (seconds >60 && seconds <=3600)
		{
			return "1 Tiếng Trước";
		}
		else if (seconds > 3600 && seconds <= 24*3600)
		{
			return "1 Ngày Trước";
		}
		else if (seconds > 24*3600 && seconds <= 24*3600* 7)
		{
			return "1 Tuần Trước";
		}
		else if (seconds > 24*3600* 7 && seconds <= 24*3600*30 )
		{
			return "1 Tháng Trước";
		}
		else
		{
			return "1 Năm Trước ";
		}	
		
	}
	@Override
	public String getLastDateByMonth(int month) {
		Calendar c = Calendar.getInstance();
		
		if(month == 1)
		{
			return "31";
		}
		if(month ==2)
		{
			if(c.get(Calendar.YEAR)%4 == 0 || c.get(Calendar.YEAR)%100 == 0)
			{
				return "28";
			}
			else
			{
				return "29";
			}	
		}
		
		if(month==3)
		{
			return "31";	
		}
			
		
		if(month==4)
		{
			return "30";
		}
		if(month==5)
		{
			return "31";
		}
		if(month==6)
		{
			return "30";
		}
		if(month==7)
		{
			return "31";
		}
		if(month==8)
		{
			return "31";
		}
		if(month==9)
		{
			return "30";
		}
		if(month==10)
		{
			return "31";
		}
		if(month==11)
		{
			return "30";
		}
		if(month==12)
		{
			return "31";
		}

		
		return "30";
}
}
