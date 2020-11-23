package com.hope.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hope.entities.ServiceSettings;
@Repository
public interface ServiceSettingRepo extends JpaRepository<ServiceSettings, Long>  {
	@Query(value = "Select sum(service_settings.amount) from service_settings where service_settings.time  >= :start and service_settings.time < :end",nativeQuery = true)
	public float getAmountByTime(@Param("start")float start, @Param("end") float end);
}
