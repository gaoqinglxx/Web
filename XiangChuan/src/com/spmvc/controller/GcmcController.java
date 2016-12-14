package com.spmvc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spmvc.model.DataGridResult;
import com.spmvc.service.GcmcService;
@Controller
@RequestMapping("/gcmc")
public class GcmcController {
	@Autowired
	private GcmcService gcmcService;
	/**
	 * 根据客户名称的id获取工程的数据
	 * @param khmc_id
	 * @return
	 */
	@RequestMapping("/getGcmc/{khmc_id}")
	@ResponseBody
	public DataGridResult getGcmc(@PathVariable("khmc_id") Integer khmc_id,@RequestParam(defaultValue="1") Integer page,@RequestParam(defaultValue="10") Integer rows){
		
		return gcmcService.getGcmc(khmc_id,page,rows);
	}
	/**
	 * 通过工程id删除工程
	 * @param gcmc_id
	 * @return
	 */
	@RequestMapping("/delGcmcById/{gcmc_id}")
	@ResponseBody
	public int delGcmcById(@PathVariable Integer gcmc_id){
		return gcmcService.delGcmcById(gcmc_id);
	}
	/**
	 * 通过工程id实现批量删除工程数据
	 */
	@RequestMapping("/delBatchGcmc/{gcmc_ids}")
	@ResponseBody
	public int delBatchGcmc(@PathVariable String gcmc_ids){
		String[] ids=StringUtils.split(gcmc_ids, "_");//分割
		List<String> list_ids=new ArrayList<>();
		for(String id:ids){
			list_ids.add(id);//把id封装到list
		}
		if(list_ids.size()==0){
			return 0;//没有值则返回0
		}else if(gcmcService.delBatchGcmc(list_ids)!=list_ids.size()){//如果删除成功的数据不等于要删除的个数
			return 0;
		}
		return 1;
	}
	/**
	 * 更新工程数据操作
	 * @param gcmc_id
	 * @param gcmc_name
	 * @return
	 */
	@RequestMapping("/updateGcmc")
	@ResponseBody
	public int updateGcmc(Integer gcmc_id,String gcmc_name){
		Map<String, Object> map=new HashMap<>();
		map.put("gcmc_id", gcmc_id);
		map.put("gcmc_name", gcmc_name);
		return gcmcService.updateGcmc(map);
	}
	/**
	 * 添加工程操作
	 * @param khmc_id
	 * @param gcmc_name
	 * @return
	 */
	@RequestMapping("/addGcmc")
	@ResponseBody
	public int addGcmc(Integer khmc_id,String gcmc_name){
		Map<String, Object> map=new HashMap<>();
		map.put("khmc_id", khmc_id);
		map.put("gcmc_name", gcmc_name);
		return gcmcService.addGcmc(map);
	}
	
}
