package com.hope.Service;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.query.Param;

import com.hope.entities.SportField;

public interface SportFieldService extends CrudEnties<SportField> {
	public List<SportField> getAllSportFiledVaildByService(long id ,Date date ,float start,float end );
	public SportField getRandomSportFiled(List<SportField> list);
	public Integer countToltalSportFiledById(long id);
}
