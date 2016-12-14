package com.spmvc.dao;

import java.util.List;
import java.util.Map;

public interface YclrkDao {

	public List<Map<String, Object>> getYclrk();
	
	public Map<String, Object> getYclrkBarcodeForMap(String yclrk_no);

	public void updateYclrkById(Map<String, Object> map);

	public String getYclrkBarcode(Integer yclrk_no);
}
