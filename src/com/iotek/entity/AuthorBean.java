package com.iotek.entity;

import java.util.Date;

public class AuthorBean {
	@Override
	public String toString() {
		return "AuthorBean [authorid=" + authorid + ", anthorname=" + anthorname + ", roletype=" + roletype
				+ ", loginname=" + loginname + ", passwords=" + passwords + ", email=" + email + ", registdate="
				+ registdate + ", authorstatus=" + authorstatus + ", memo=" + memo + "]";
	}
	private int authorid;
	private String anthorname;
	private String roletype;
	private String loginname;
	private String passwords;
	private String email;
	private Date registdate;
	private String authorstatus;
	private String memo;
	public int getAuthorid() {
		return authorid;
	}
	public void setAuthorid(int authorid) {
		this.authorid = authorid;
	}
	public String getAnthorname() {
		return anthorname;
	}
	public void setAnthorname(String anthorname) {
		this.anthorname = anthorname;
	}
	public String getRoletype() {
		return roletype;
	}
	public void setRoletype(String roletype) {
		this.roletype = roletype;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getPasswords() {
		return passwords;
	}
	public void setPasswords(String passwords) {
		this.passwords = passwords;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getRegistdate() {
		return registdate;
	}
	public void setRegistdate(Date registdate) {
		this.registdate = registdate;
	}
	public String getAuthorstatus() {
		return authorstatus;
	}
	public void setAuthorstatus(String authorstatus) {
		this.authorstatus = authorstatus;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public AuthorBean(int authorid, String anthorname, String roletype, String loginname, String passwords,
			String email, Date registdate, String authorstatus, String memo) {
		super();
		this.authorid = authorid;
		this.anthorname = anthorname;
		this.roletype = roletype;
		this.loginname = loginname;
		this.passwords = passwords;
		this.email = email;
		this.registdate = registdate;
		this.authorstatus = authorstatus;
		this.memo = memo;
	}
	public AuthorBean() {
		super();
	}
	
}
