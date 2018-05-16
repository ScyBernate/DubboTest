package com.cloud.CloudDemo.config.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cloud.CloudDemo.constants.Constant;
import com.cloud.CloudDemo.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
  * @ClassName: SecUser
  * @Description: TODO
  * @author scy
  * @date 2017年11月13日 上午9:55:33
  *
 */
public class SecUser implements UserDetails {

	private static final long serialVersionUID = -332610665358366452L;
	
	private final Long  id;
	
	private final String username;
	
	private final String password;
	
	private final Integer status;
	
	private final Date lastPasswordResetDate;
	
	private Collection<? extends GrantedAuthority> roles;
	
	public SecUser(User user){
		this.id = user.getId();
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.status = user.getStatus();
		List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
		user.getRoles().forEach(role -> roles.add(new SimpleGrantedAuthority(role.getName())));
		this.roles = roles;
		this.lastPasswordResetDate = user.getLastPasswordResetDate();
	}
	
	@JsonIgnore
	public Long getId(){
		return id;
	}
	
	public Date getLastPasswordResetDate(){
		return lastPasswordResetDate;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles;
	}

	@JsonIgnore
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return Constant.ACCOUNT_EABLED==status?true:false;
	}

}
