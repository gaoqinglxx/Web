package com.spmvc.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.spmvc.dao.GcmcDao;
import com.spmvc.model.DataGridResult;
import com.spmvc.service.GcmcService;
@Service
public class GcmcServiceImpl implements GcmcService {
	@Autowired
	private GcmcDao gcmcDao;
	/**
	 * 根据客户ID来查询工程项目的信息
	 * 1.MyBatis+PageHelper来完成分页信息显示
	 * 2.PageHelper来设置页面和当前页显示的数据总数
	 * 3.一定要把查询的数据加载PageInfo对象里面, 因为这个对象会帮你去计算总记录数
	 */

	@Override
	public DataGridResult getGcmc(Integer khmc_id,Integer page,Integer rows) {
		PageHelper.startPage(page, rows);
		List<Map<String, Object>> list_gcmc=gcmcDao.getGcmc(khmc_id);//全部客户
		PageInfo<Map<String, Object>> pageInfo=new PageInfo<>(list_gcmc);
		DataGridResult dataGridResult=new DataGridResult(pageInfo.getTotal(),list_gcmc);
		return dataGridResult;
	}
	@Override
	public int delGcmcById(Integer gcmc_id) {
		
		return gcmcDao.delGcmcById(gcmc_id);
	}
	@Override
	public int delBatchGcmc(List<String> list) {
		
		return gcmcDao.delBatchGcmc(list);
	}
	@Override
	public int updateGcmc(Map<String, Object> map) {
		
		return gcmcDao.updateGcmc(map);
	}
	@Override
	public int addGcmc(Map<String, Object> map) {
		
		return gcmcDao.addGcmc(map);
	}
	

}
