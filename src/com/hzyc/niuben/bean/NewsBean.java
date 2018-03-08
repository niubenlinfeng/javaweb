package com.hzyc.niuben.bean;

public class NewsBean {
	private int newsId;
	private String newsFirst;
	private String newsDate;
	private String newsTiaozhuan;
	
	public String getNewsDate() {
		return newsDate;
	}
	public void setNewsDate(String newsDate) {
		this.newsDate = newsDate;
	}
	public String getNewsTiaozhuan() {
		return newsTiaozhuan;
	}
	public void setNewsTiaozhuan(String newsTiaozhuan) {
		this.newsTiaozhuan = newsTiaozhuan;
	}
	public int getNewsId() {
		return newsId;
	}
	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}
	public String getNewsFirst() {
		return newsFirst;
	}
	public void setNewsFirst(String newsFirst) {
		this.newsFirst = newsFirst;
	}
	public String getNewsSecond() {
		return newsSecond;
	}
	public void setNewsSecond(String newsSecond) {
		this.newsSecond = newsSecond;
	}
	public String getNewsAll() {
		return newsAll;
	}
	public void setNewsAll(String newsAll) {
		this.newsAll = newsAll;
	}
	public String getNewsImage() {
		return newsImage;
	}
	public void setNewsImage(String newsImage) {
		this.newsImage = newsImage;
	}
	private String newsSecond;
	private String newsAll;
	private String newsImage;
}
