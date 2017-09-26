package com.patchingscheduler.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="black_dates")
public class DateBean {
	
	@Id
	@Column(name="b_dates")
	private Date  b_dates;	
	
	@Transient
	private String black_dates;
	
	public String getBlack_dates() {
		return black_dates;
	}

	public void setBlack_dates(String black_dates) {
		this.black_dates = black_dates;
	}

	public Date getB_dates() {
		return b_dates;
	}

	public void setB_dates(Date b_dates) {
		this.b_dates = b_dates;
	}

	

}
