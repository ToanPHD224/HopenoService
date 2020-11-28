package com.hope.Service;

import java.util.Date;

public interface DateHelperService {
	
	public Date convetDatetoSql(String date);
	public String getMinutes(Date date);
	public String getLastDateByMonth(int month);
}