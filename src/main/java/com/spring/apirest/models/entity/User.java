package com.spring.apirest.models.entity;

import java.io.Serializable;
import java.util.List;







public class User implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int page;
	private int per_page;
	private int total;
	private int total_pages;


	private List<UserDatos> data;
	
	
	


	
	
	
	public User(int page, int per_page, int total, int total_pages, List<UserDatos> data) {
		super();
		this.page = page;
		this.per_page = per_page;
		this.total = total;
		this.total_pages = total_pages;
		this.data = data;
	}



	public List<UserDatos> getData() {
		return data;
	}



	public void setData(List<UserDatos> data) {
		this.data = data;
	}







	public User() {
		super();
	}

	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPer_page() {
		return per_page;
	}
	public void setPer_page(int per_page) {
		this.per_page = per_page;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getTotal_pages() {
		return total_pages;
	}
	public void setTotal_pages(int total_pages) {
		this.total_pages = total_pages;
	}
	
	
	
	
	

}
