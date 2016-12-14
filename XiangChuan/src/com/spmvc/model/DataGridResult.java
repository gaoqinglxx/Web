package com.spmvc.model;

import java.util.List;

public class DataGridResult {

	private Long total;//总数
	private List<?> rows;//数据集
	
	
	public DataGridResult() {}
	public DataGridResult(Long total, List<?> rows) {
		this.total = total;
		this.rows = rows;
	}
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public List<?> getRows() {
		return rows;
	}
	public void setRows(List<?> rows) {
		this.rows = rows;
	}
	
	
}
