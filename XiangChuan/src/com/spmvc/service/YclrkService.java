package com.spmvc.service;

import java.util.List;
import java.util.Map;

public interface YclrkService {

	public List<Map<String, Object>> getYclrk();

	public void updateYckrkById(int yclrk_id,String yclrk_barcode);
	
	public Map<String, Object> getYclrkBarcodeForMap(String yclrk_no);

	public String getYclrkBarcode(Integer yclrk_no);
}
