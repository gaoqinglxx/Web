package com.spmvc.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spmvc.dao.GcmcDao;
import com.spmvc.dao.KhmcDao;
import com.spmvc.model.Khmc;
import com.spmvc.service.KhmcService;
@Service
public class KhmcServiceImpl implements KhmcService {
	@Autowired
	private KhmcDao khmcDao;
	@Autowired
	private GcmcDao gcmcDao;
	@Override
	public List<Khmc> getKhmc() {
		return khmcDao.getKhmc();
	}
	@Override
	public int addKhmc(String khmc_name) {
		
		return khmcDao.addKhmc(khmc_name);
	}
	@Override
	public int updateKhmc(Map<String, Object> map) {
		
		return khmcDao.updateKhmc(map);
	}
	@Override
	public int deleteKhmc(int khmc_id) {
		int i=gcmcDao.deleteGcmcById(khmc_id);
		int j=khmcDao.deleteKhmc(khmc_id);
		return i+j;
	}

}
