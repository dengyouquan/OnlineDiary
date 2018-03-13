package com.iotek.entity;

public class CatalogBean {
	private int cataid;
	//子集目录
	private int d_t_cataid;
	private int authorid;
	private String cataname;
	private String catastate;
	private String catamemo;
	public int getCataid() {
		return cataid;
	}
	public void setCataid(int cataid) {
		this.cataid = cataid;
	}
	public int getD_t_cataid() {
		return d_t_cataid;
	}
	public void setD_t_cataid(int d_t_cataid) {
		this.d_t_cataid = d_t_cataid;
	}
	public int getAuthorid() {
		return authorid;
	}
	public void setAuthorid(int authorid) {
		this.authorid = authorid;
	}
	public String getCataname() {
		return cataname;
	}
	public void setCataname(String cataname) {
		this.cataname = cataname;
	}
	public String getCatastate() {
		return catastate;
	}
	public void setCatastate(String catastate) {
		this.catastate = catastate;
	}
	public String getCatamemo() {
		return catamemo;
	}
	public void setCatamemo(String catamemo) {
		this.catamemo = catamemo;
	}
	public CatalogBean() {
		super();
	}
	public CatalogBean(int cataid, int d_t_cataid, int authorid, String cataname, String catastate, String catamemo) {
		super();
		this.cataid = cataid;
		this.d_t_cataid = d_t_cataid;
		this.authorid = authorid;
		this.cataname = cataname;
		this.catastate = catastate;
		this.catamemo = catamemo;
	} 
	
}
