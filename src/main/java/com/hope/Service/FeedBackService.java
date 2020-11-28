package com.hope.Service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.hope.entities.FeedBack;

public interface FeedBackService extends CrudEnties<FeedBack> {
	public Page<FeedBack> findAllByTypeAndCreatedAt(int type,java.util.Date date,Pageable page);
	public String getAVGRating(long id);
	public List<FeedBack> getTopFiveFeedBackByService(long id);
}
