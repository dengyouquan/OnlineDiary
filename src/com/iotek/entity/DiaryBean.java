package com.iotek.entity;

import java.util.Date;

public class DiaryBean {
	private int diaryid;
	private int authorid;
	private int cataid;
	private String dtitle;
	private String dtype;
	private String dcontent;
	private String ispublish;
	private Date createdate;
	private Date lastdate;
	private String domain;
	public int getDiaryid() {
		return diaryid;
	}
	public DiaryBean(int diaryid, int authorid, int cataid, String dtitle, String dtype, String dcontent,
			String ispublish, Date createdate, Date lastdate, String domain) {
		super();
		this.diaryid = diaryid;
		this.authorid = authorid;
		this.cataid = cataid;
		this.dtitle = dtitle;
		this.dtype = dtype;
		this.dcontent = dcontent;
		this.ispublish = ispublish;
		this.createdate = createdate;
		this.lastdate = lastdate;
		this.domain = domain;
	}
	public DiaryBean() {
		super();
	}
	public void setDiaryid(int diaryid) {
		this.diaryid = diaryid;
	}
	public int getAuthorid() {
		return authorid;
	}
	public void setAuthorid(int authorid) {
		this.authorid = authorid;
	}
	public int getCataid() {
		return cataid;
	}
	public void setCataid(int cataid) {
		this.cataid = cataid;
	}
	public String getDtitle() {
		return dtitle;
	}
	public void setDtitle(String dtitle) {
		this.dtitle = dtitle;
	}
	public String getDtype() {
		return dtype;
	}
	public void setDtype(String dtype) {
		this.dtype = dtype;
	}
	public String getDcontent() {
		return dcontent;
	}
	public void setDcontent(String dcontent) {
		this.dcontent = dcontent;
	}
	public String getIspublish() {
		return ispublish;
	}
	public void setIspublish(String ispublish) {
		this.ispublish = ispublish;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public Date getLastdate() {
		return lastdate;
	}
	public void setLastdate(Date lastdate) {
		this.lastdate = lastdate;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
}
