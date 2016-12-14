package com.spmvc.dao;

import java.util.List;
import java.util.Map;

import com.spmvc.model.Gcmc;

public interface GcmcDao {

	public List<Map<String, Object>> getGcmc(Integer khmc_id);

	public int delGcmcById(Integer gcmc_id);

	public int delBatchGcmc(List<String> list);

	public int updateGcmc(Map<String, Object> map);

	public int addGcmc(Map<String, Object> map);

	public int deleteGcmcById(int khmc_id);

}
