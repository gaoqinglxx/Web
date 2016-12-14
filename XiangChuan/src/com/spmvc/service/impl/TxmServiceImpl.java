package com.spmvc.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spmvc.dao.TxmDao;
import com.spmvc.service.TxmService;
@Service
public class TxmServiceImpl implements TxmService {
	
	@Autowired
	private TxmDao txmDao;
	
	@Override
	public void addTxm(int yclrk_id, String txm_barcode) {
		Map<String,Object> map=new HashMap<>();
		map.put("yclrk_id", yclrk_id);
		map.put("txm_barcode",txm_barcode);
		txmDao.addTxm(map);
	}

}
