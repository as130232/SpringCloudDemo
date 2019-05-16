package com.example.consulproducer.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "USER")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID",columnDefinition = "用戶ID")
	private Integer userId;
	@Column(name = "USERNAME",columnDefinition = "用戶名稱")
	private String username;
	@Column(name = "ADDRESS",columnDefinition = "住址")
	private String address;
	@Column(name = "VALID_FLAG",columnDefinition = "是否為有效資料")
	private Integer validFlag;
	@CreationTimestamp
	@Column(name = "CREATEDATE", updatable = false)
	private Date createdate;
	@Column(name = "UPDATEID",columnDefinition = "''")
	private String updateid;
	@UpdateTimestamp
	@Column(name = "UPDATEDATE", insertable = false)
	private Date updatedate;
}
