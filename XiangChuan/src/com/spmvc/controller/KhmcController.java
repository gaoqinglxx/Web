package com.spmvc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spmvc.easyui.result.TreeNodeResult;
import com.spmvc.model.Khmc;
import com.spmvc.service.KhmcService;

@Controller
@RequestMapping("/khmc")
public class KhmcController {
	
	@Autowired
	private KhmcService khmcService;
	/**
	 * 查询全部客户
	 * @return
	 */
	@RequestMapping("/getKhmc")
	@ResponseBody
	public List<TreeNodeResult> getKhmc() {
		List<TreeNodeResult> list=new ArrayList<>();
		TreeNodeResult root=new TreeNodeResult(0,"客户名称","open",null);
		list.add(root);
		List<Khmc> list_khmc=khmcService.getKhmc();
		for(Khmc khmc:list_khmc){
			TreeNodeResult node=new TreeNodeResult(khmc.getKhmc_id(),khmc.getKhmc_name(),"closed",0);
			list.add(node);
		}
		return list;
	}
	/**
	 * 添加客户
	 * @param khmc_name
	 * @return
	 */
	@RequestMapping("/addKhmc")
	@ResponseBody
	public int addKhmc(String khmc_name){
		List<Khmc> list_khmc=khmcService.getKhmc();
		for(Khmc khmc:list_khmc){
			if(StringUtils.trim(khmc_name).equals("") || khmc.getKhmc_name().equals(khmc_name)){
				return 0;
			}
		}
		return khmcService.addKhmc(khmc_name);
	}
	/**
	 * 更新客户
	 * @param khmc_id
	 * @param khmc_name
	 * @return
	 */
	@RequestMapping("/updateKhmc")
	@ResponseBody
	public int updateKhmc(int khmc_id,String khmc_name){
		
		Map<String, Object> map=new HashMap<>();
		map.put("khmc_id",khmc_id);
		map.put("khmc_name",khmc_name);
		
		List<Khmc> list_khmc=khmcService.getKhmc();
		for(Khmc khmc:list_khmc){    
			if(StringUtils.trim(khmc_name).equals("") || khmc_id!=khmc.getKhmc_id() && khmc.getKhmc_name().equals(khmc_name)){
				return 0;//客户名称为空,或者更改的客户名不能与其他已存在的客户同名
			}
		}
		return khmcService.updateKhmc(map);
	}
	/**
	 * 删除客户
	 * @param khmc_id
	 * @return
	 */
	@RequestMapping("/deleteKhmc")
	@ResponseBody
	public int deleteKhmc(int khmc_id){
		
		return khmcService.deleteKhmc(khmc_id);
	}
}
