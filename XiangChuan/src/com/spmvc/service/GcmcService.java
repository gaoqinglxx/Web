package com.spmvc.service;

import java.util.List;
import java.util.Map;

import com.spmvc.model.DataGridResult;

public interface GcmcService {
	
	public DataGridResult getGcmc(Integer khmc_id,Integer page,Integer rows);

	public int delGcmcById(Integer gcmc_id);

	public int delBatchGcmc(List<String> list);

	public int updateGcmc(Map<String, Object> map);

	public int addGcmc(Map<String, Object> map);

	

	

}
