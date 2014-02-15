package com.allanshoulders.vsoutjection.sample.dao;

import java.util.List;

public class JsonTable<T> {

	private List<T> gridModel;
	private Integer records;
	private Integer rows;
	private Integer page;
	private Integer total;
	private String searchField;
	private String searchString;
	private String searchOper;
	private String sidx;
	private String sord;
	
	public JsonTable () {
		this(null);
	}
	
	public JsonTable(List<T> gridModel) {
		this.gridModel = gridModel;
		rows = 0;
		page = 0;
		total = 0;
		records = 0;
	}

	public List<T> getGridModel() {
		return gridModel;
	}

	public void setGridModel(List<T> gridModel) {
		this.gridModel = gridModel;
	}

	public Integer getRecords() {
		return records;
	}

	public void setRecords(Integer records) {
		this.records = records;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public String getSearchField() {
		return searchField;
	}

	public void setSearchField(String searchField) {
		this.searchField = searchField;
	}

	public String getSearchString() {
		return searchString;
	}

	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}

	public String getSearchOper() {
		return searchOper;
	}

	public void setSearchOper(String searchOper) {
		this.searchOper = searchOper;
	}

	public String getSidx() {
		return sidx;
	}

	public void setSidx(String sidx) {
		this.sidx = sidx;
	}

	public String getSord() {
		return sord;
	}

	public void setSord(String sord) {
		this.sord = sord;
	}
	
	
}
