package com.cloud.CloudDemo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "t_user")
public class User {
	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "password")
	private String password;

	@Column(name = "username")
	private String username;

	@Column(name = "division_id")
	private Integer divisionId;

	@Column(name = "sex")
	private String sex;

	@Column(name = "email")
	private String email;

	@Column(name = "mobilephone")
	private String mobilephone;

	@Column(name = "telephone")
	private String telephone;

	@Column(name = "user_type")
	private Integer userType;

	@Column(name = "create_by")
	private String createBy;

	@Column(name = "create_time")
	private Date createTime;

	@Column(name = "update_by")
	private String updateBy;

	@Column(name = "update_time")
	private Date updateTime;

	@Column(name = "disabled")
	private Integer disabled;

	@Column(name = "theme")
	private String theme;

	@Column(name = "is_ldap")
	private Integer isLdap;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonIgnore
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getDivisionId() {
		return divisionId;
	}

	public void setDivisionId(Integer divisionId) {
		this.divisionId = divisionId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobilephone() {
		return mobilephone;
	}

	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getDisabled() {
		return disabled;
	}

	public void setDisabled(Integer disabled) {
		this.disabled = disabled;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public Integer getIsLdap() {
		return isLdap;
	}

	public void setIsLdap(Integer isLdap) {
		this.isLdap = isLdap;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public User() {
	}

	public User(String name, String password, String username, Integer divisionId, String sex, String email,
			String mobilephone, String telephone, Integer userType, String createBy, Date createTime, String updateBy,
			Date updateTime, Integer disabled, String theme, Integer isLdap) {
		super();
		this.name = name;
		this.password = password;
		this.username = username;
		this.divisionId = divisionId;
		this.sex = sex;
		this.email = email;
		this.mobilephone = mobilephone;
		this.telephone = telephone;
		this.userType = userType;
		this.createBy = createBy;
		this.createTime = createTime;
		this.updateBy = updateBy;
		this.updateTime = updateTime;
		this.disabled = disabled;
		this.theme = theme;
		this.isLdap = isLdap;
	}

}