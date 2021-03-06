package com.rdb_backend.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name="item_event")
public class ItemEvent implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private Integer necessaryAmount;
	
	@Column
	private Integer quantityObtained;
	
	@ManyToOne
	@JoinColumn(name = "FK_ITEM")
	private Item item;
	
	@ManyToOne
	@JoinColumn(name = "FK_EVENT")
	private Event event;
	
	@CreatedDate
	@Column(name = "created_date")
	private LocalDateTime createdDate = LocalDateTime.now();

	@LastModifiedDate
	@Column(name = "last_modified_date")
	private LocalDateTime lastModifiedDate = LocalDateTime.now();
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNecessaryAmount() {
		return necessaryAmount;
	}

	public void setNecessaryAmount(Integer necessaryAmount) {
		this.necessaryAmount = necessaryAmount;
	}

	public Integer getQuantityObtained() {
		return quantityObtained;
	}

	public void setQuantityObtained(Integer quantityObtained) {
		this.quantityObtained = quantityObtained;
	}
		
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	
	
}
