package com.hope.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hope.entities.SportField;
@Repository
public interface SportFieldRepo extends JpaRepository<SportField, Long>  {
	@Query(value = "select *  from  sportfiled ,"
			+ " service where service.id=sportfiled.service_id and service.id =:service"
			+ "and sportfiled.id  not in"
			+ " (select payment.sportfield_id from payment where payment.date =:date"
			+ " and (payment._start >=:_start and payment._end <=:_end))  ",nativeQuery = true) 
	public List<SportField> getAllSportFiledVaildByService(@Param("service") long id , @Param("date") Date date ,@Param("_start") float start,@Param("_end") float end );
	
	
}
