package com.hope.ServiceImpl;

import java.time.LocalDate;
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

}
