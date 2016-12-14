package com.spmvc.service;

import java.util.List;
import java.util.Map;

import com.spmvc.model.Khmc;

public interface KhmcService {

	public List<Khmc> getKhmc();

	public int addKhmc(String khmc_name);

	public int updateKhmc(Map<String, Object> map);

	public int deleteKhmc(int khmc_id);
}
