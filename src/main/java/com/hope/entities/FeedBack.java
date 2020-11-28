package com.hope.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "feedback")
public class FeedBack implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Lob
	@Column(name = "content",columnDefinition = "nvarchar(250)",length = 250)
	private String content;
	@Column(name = "rating")
	private float rating;
	@Column(name = "type")
	private int type;
	@Column(name = "created_at")
	private Date createdAt;
	@ManyToOne
	@JoinColumn(name = "account_id")
	private Account account;
	@ManyToOne
	@JoinColumn(name = "service_id")
	private Service service;
	@ManyToOne
	@JoinColumn(name = "detalis_feedback_id")
	private DetailsFeedBack detailsfeedback;
	public FeedBack() {
		// TODO Auto-generated constructor stub
	}
	
}	
