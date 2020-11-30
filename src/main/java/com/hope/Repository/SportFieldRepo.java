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
	@Query(value = "select *  from  sport_filed ,"
			+ " service where service.id=sport_filed.service_id and service.id =:service"
			+ "and sport_filed.id  not in"
			+ " (select payment.sport_field_id from payment where payment.date =:date"
			+ " and (payment._start >=:_start and payment._end <=:_end))  ",nativeQuery = true) 
	public List<SportField> getAllSportFiledVaildByService(@Param("service") long id , @Param("date") Date date ,@Param("_start") float start,@Param("_end") float end );
	@Query(value = "select count(*) from sport_filed where sport_filed.service_id = :id",nativeQuery = true)
	public Integer countToltalSportFiledById(@Param("id") long id);
	
}
