package com.spmvc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spmvc.dao.YclrkDao;
import com.spmvc.service.YclrkService;
@Service
public class YclrkServiceImpl implements YclrkService {
	
	@Autowired
	private YclrkDao yclrkDao;
	
	@Override
	public List<Map<String, Object>> getYclrk() {
		
		return yclrkDao.getYclrk();
	}

	@Override
	public Map<String, Object> getYclrkBarcodeForMap(String yclrk_no) {
		
		return yclrkDao.getYclrkBarcodeForMap(yclrk_no);
	}

	@Override
	public void updateYckrkById(int yclrk_id, String yclrk_barcode) {
		Map<String, Object> map=new HashMap<>();
		map.put("yclrk_id", yclrk_id);
		map.put("yclrk_barcode", yclrk_barcode);
		map.put("yclrk_barcode_iscreate", "是");
		yclrkDao.updateYclrkById(map);
	}

	@Override
	public String getYclrkBarcode(Integer yclrk_no) {
		
		return yclrkDao.getYclrkBarcode(yclrk_no);
	}

}
