package com.hope.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hope.entities.Service;
@Repository
public interface ServiceRepo extends JpaRepository<Service, Long> {
	@Query(value = "select * from  service  where service.id "
			+ "in (select distinct sportfiled.service_id from "
			+ "sportfiled where sportfiled.id not in "
			+ "(select payment.sportfield_id from payment "
			+ "where payment.date = :date and "
			+ "(payment._start >= :_start and payment._end <=:_end)))",nativeQuery = true)
	public List<Service> getAllServiceFromDateAndTime(@Param("date") Date date , @Param("_start") float start , @Param("_end") float end  );
	@Query(value = "select * from  service,ward,districs where "
			+ "( service.ward_id = ward.id and ward.districs_id = districs.id and districs.name=:quan)"
			+ "   and service.id in (select distinct sportfiled.service_id from sportfiled where sportfiled.id "
			+ "not in (select payment.sportfield_id from payment where payment.date =:date"
			+ " and (payment._start >=:_start and payment._end <=:_end)))",nativeQuery = true)
	public List<Service> getAllServiceByDateTimeAndDistric(@Param("quan") String quan, @Param("date") Date date , @Param("_start") float start,@Param("_end") float end);
	
}
