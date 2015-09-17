package net.nsimpler.application.controllers.auth;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class LoginCommand {

	@NotEmpty
	@Email
	private String email;
	
	@NotEmpty
	@Email
	private String password;
	
	@NotNull
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date from;
	
	private String loginType;
	
	private String jobCode;
	
	//private Code favoriteOs;
	private int[] favoriteOs;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Date getFrom() {
		return from;
	}

	public void setFrom(Date from) {
		this.from = from;
	}

	public String getLoginType() {
		return loginType;
	}

	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}
	
	public boolean hasPassword() {
		return password != null && password.trim().length() > 0;
	}
	
	public boolean isSamePasswordConfirmPassword() {
		if (password == null)
			return false;
		return password.equals(password);
	}

	public String getJobCode() {
		return jobCode;
	}

	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}
/*
	public String[] getFavoriteOs() {
		return favoriteOs;
	}

	public void setFavoriteOs(String[] favoriteOs) {
		this.favoriteOs = favoriteOs;
	}
*/

	public int[] getFavoriteOs() {
		return favoriteOs;
	}

	public void setFavoriteOs(int[] favoriteOs) {
		this.favoriteOs = favoriteOs;
	}






}
