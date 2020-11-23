package com.hope.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hope.entities.Service;
@Repository
public interface ServiceRepo extends JpaRepository<Service, Long> , PagingAndSortingRepository<Service, Long> {
	@Query(value = "select * from  service  where service.id "
			+ "in (select distinct sport_filed.service_id from "
			+ "sport_filed where sport_filed.id not in "
			+ "(select payment.sport_field_id from payment "
			+ "where payment.date = :date and "
			+ "(payment._start >= :_start and payment._end <=:_end) and service.status = 1))",nativeQuery = true)
	public List<Service> getAllServiceFromDateAndTime(@Param("date") Date date , @Param("_start") float start , @Param("_end") float end  );
	@Query(value = "select * from  service,ward,districs where "
			+ "( service.ward_id = ward.id and ward.districs_id = districs.id and districs.name=:quan)"
			+ "   and service.id in (select distinct sport_filed.service_id from sport_filed where sport_filed.id "
			+ "not in (select payment.sport_field_id from payment where payment.date =:date"
			+ " and (payment._start >=:_start and payment._end <=:_end) and service.status = 1 ))",nativeQuery = true)
	public List<Service> getAllServiceByDateTimeAndDistric(@Param("quan") String quan, @Param("date") Date date , @Param("_start") float start,@Param("_end") float end);
	
	
	@Query(value = "select * from service where service.status = 0 and service.registedat = :date",nativeQuery = true)
	public List<Service> getAllRegistationServive(@Param("date") Date date);
	
	public Page<Service> findAllByregisteredAt(Pageable page,Date date);
	public List<Service> findAllByStatus(boolean status);
}
