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
			+ "(payment._start >= :_start and payment._end <=:_end) and service.status = 2))",nativeQuery = true)
	public List<Service> getAllServiceFromDateAndTime(@Param("date") Date date , @Param("_start") float start , @Param("_end") float end  );
	@Query(value = "select * from  service,ward,districs where "
			+ "( service.ward_id = ward.id and ward.districs_id = districs.id and districs.name=:quan)"
			+ "   and service.id in (select distinct sport_filed.service_id from sport_filed where sport_filed.id "
			+ "not in (select payment.sport_field_id from payment where payment.date =:date"
			+ " and (payment._start >=:_start and payment._end <=:_end) and service.status = 2 ))",nativeQuery = true)
	public List<Service> getAllServiceByDateTimeAndDistric(@Param("quan") String quan, @Param("date") Date date , @Param("_start") float start,@Param("_end") float end);
	
	
	@Query(value = "select * from service where service.status = 0 and service.registedat = :date",nativeQuery = true)
	public List<Service> getAllRegistationServive(@Param("date") Date date);
	
	public Page<Service> findAllByRegisteredAtAndStatus(Pageable page,Date date,int status);
	@Query(value = "select * from service where service.status = 1 or service.status = 2",nativeQuery = true)
	public List<Service> findAllServiceAceptandActive(); 
	@Query(value = "select * from service where service.status = 1 or service.status = 2 and service.id =:id",nativeQuery = true)
	public List<Service> findAllServiceAceptandActive(@Param("id") long id); 
	public List<Service> findAllByStatus(int status);
	public List<Service> findAllByMailAndStatus(String mail,int status);
	public List<Service> findAllByStatusAndId(int status, long id);
	@Query(value = "select COUNT(*) from payment  inner join sport_filed on payment.sport_field_id = sport_filed.id inner join service on sport_filed.service_id = service.id where service.id =:id ",nativeQuery  = true)
	public Integer getTotalBook(@Param("id") long id);
	@Query(value = "select COALESCE(sum(payment.amount),0) from payment  inner join sport_filed on payment.sport_field_id = sport_filed.id inner join service on sport_filed.service_id = service.id where service.id =:id",nativeQuery = true)
	public Float getTotalAmount(@Param("id") long id);
	@Query(value = "select COUNT(*) from service where account_id = :accountId",nativeQuery = true)
	public Integer getToltalService(@Param("accountId")long accountId);
	@Query(value = "select AVG(service_settings.amount) from service_settings where service_settings.service_id = :id",nativeQuery = true)
	public Float getAVGFee(@Param("id") long id);
	@Query(value = "select  service.* from service inner join service_settings on service.id = service_settings.service_id where service.id = :id",nativeQuery = true)
	public Service getService(@Param("id") long id);
	@Query(value = "select count(*) from service where service.status = 0 and service.registered_at = :date",nativeQuery = true)
	public Integer countRegisterForm(@Param("date") Date date);
	@Query(value = "select * from service where service.service_fee_id = :id and service.status =3",nativeQuery = true)
	List<Service> getAllServiceByType(@Param("id") long id);
	@Query(value = "SELECT TOP 6 service.* FROM service where service.service_fee_id =:id ORDER BY NEWID()",nativeQuery = true)
	public List<Service> getRandomService(@Param("id") long id);
	
}
