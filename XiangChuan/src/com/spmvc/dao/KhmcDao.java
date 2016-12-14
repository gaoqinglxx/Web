package com.spmvc.dao;

import java.util.List;
import java.util.Map;

import com.spmvc.model.Khmc;

public interface KhmcDao {

	/**
	 * 返回客户信息的所有数据
	 * 注意: 
	 * 1.接口中名称和MyBatis的映射文件标签id名称一样
	 * 2.映射文件的namespace和接口的包名+类名一样
	 * @return
	 */
	public List<Khmc> getKhmc();

	public int addKhmc(String khmc_name);

	public int updateKhmc(Map<String, Object> map);

	public int deleteKhmc(int khmc_id);

}
