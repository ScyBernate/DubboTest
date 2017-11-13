package com.cloud.CloudDemo.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="t_role")
public class Role implements Serializable {

	private static final long serialVersionUID = -1849207403196037531L;
	
	@Id
	@GeneratedValue
	private Long  id;
	
	@Column(name="name")
	private String name;
	
	@JsonIgnore
	@ManyToMany(mappedBy="roles",cascade=CascadeType.REFRESH,fetch = FetchType.LAZY)
	private Set<User> users = new HashSet<User>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Role(String name) {
		super();
		this.name = name;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Role() {
		super();
	}
	
	
	
}
