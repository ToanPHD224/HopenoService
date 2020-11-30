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

import com.hope.entities.FeedBack;
@Repository
public interface FeedBackRepo extends JpaRepository<FeedBack, Long> ,  PagingAndSortingRepository<FeedBack, Long>{
		public Page<FeedBack> findAllByTypeAndCreatedAt(int type,Date createdat,Pageable page);
		@Query(value = "select AVG(feedback.rating) from feedback where service_id = :service",nativeQuery = true)
		public Integer getAVGRating(@Param("service") long id);
		@Query(value = "select top 5  *  from feedback  where feedback.service_id = :id order by feedback.created_at ",nativeQuery = true)
		public List<FeedBack> getTopFiveFeedBackByService(@Param("id") long id);
		
 }
