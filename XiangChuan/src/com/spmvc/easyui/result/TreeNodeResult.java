package com.spmvc.easyui.result;
/**
 * 封装数节点信息
 * @author mabaoyun
 *
 */
public class TreeNodeResult {

	private Integer id;
	private String text;
	private String state;
	private Integer parentId;
	
	public TreeNodeResult(Integer id, String text, String state, Integer parentId) {
		this.id = id;
		this.text = text;
		this.state = state;
		this.parentId = parentId;
	}
	public TreeNodeResult() {}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	
	
	
}
