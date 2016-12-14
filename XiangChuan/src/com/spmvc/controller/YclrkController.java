package com.spmvc.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.jbarcode.encode.InvalidAtributeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.spmvc.model.DataGridResult;
import com.spmvc.service.TxmService;
import com.spmvc.service.YclrkService;
import com.spmvc.util.BarCodeUtil;


@RequestMapping("/yclrk")
@Controller
public class YclrkController {
	
	@Autowired
	private YclrkService yclrkService;
	@Autowired
	private TxmService txmService;
	/**
	 * 得到全部原材料,三表联查
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/getYclrk")
	@ResponseBody
	public DataGridResult getYclrk(@RequestParam(defaultValue="1")Integer page,@RequestParam(defaultValue="10")Integer rows){
		PageHelper.startPage(page,rows);
		List<Map<String, Object>> yclrk_list=yclrkService.getYclrk();
		PageInfo<Map<String, Object>> pageInfo=new PageInfo<>(yclrk_list);
		DataGridResult dataGridResult=new DataGridResult(pageInfo.getTotal(),yclrk_list);
		return dataGridResult;
	}
	/**
	 * 生成条形码
	 * @param yclrk_no
	 * @param request
	 * @return
	 */
	@RequestMapping("/createCode")
	@ResponseBody
	public int createCode(String yclrk_no,HttpServletRequest request){
		
		String path=request.getServletContext().getRealPath("/");//得到服务器路径
		path=path.replaceAll("\\\\","/");
		Map<String, Object> map_barcode=yclrkService.getYclrkBarcodeForMap(yclrk_no);//得到条形码需要的信息
		Integer yclrk_amount=new Integer(map_barcode.get("yclrk_amount").toString());//得到该原材料的总数
		StringBuilder sb=new StringBuilder();//条形码信息拼接
		sb.append(map_barcode.get("khmc_id"));
		sb.append(map_barcode.get("gcmc_id"));
		sb.append(yclrk_no);
		sb.append(map_barcode.get("yclrk_standard_height"));
		sb.append(map_barcode.get("yclrk_standard_width"));
		String txmPath="";
		try {
			for(int i=0;i<yclrk_amount;i++){
				String	codeName=UUID.randomUUID().toString().replaceAll("-","");//条形码图片名称
				txmPath+="/barcode/"+yclrk_no+"/"+codeName+".png"+",";//条形码保存的相对路径
				String txm_barcode=sb.toString()+i;//条形码信息
				//创建条形码
				BarCodeUtil.createBarCode(txm_barcode,path+"barcode"+"/"+yclrk_no,codeName);//创建条形码
				//保存条形码的信息到txm表
				txmService.addTxm(new Integer(map_barcode.get("yclrk_id").toString()),txm_barcode);
			}
			//更新原材料入库的是否创建条形码状态和条形码保存路径两个字段
			yclrkService.updateYckrkById(new Integer(map_barcode.get("yclrk_id").toString()),txmPath.substring(0, txmPath.length()-1));
		} catch (InvalidAtributeException | IOException e) {
			e.printStackTrace();
			return 0;
		}
		return  1;
	}
	/**
	 * 查看条形码
	 * @param yclrk_no
	 * @return
	 */
	@RequestMapping("getTxm")
	public ModelAndView getTxm(Integer yclrk_no){
		//得到条形码的地址
		String yclrk_barcode=yclrkService.getYclrkBarcode(yclrk_no);
		String[] yclrk_barcode_path=StringUtils.split(yclrk_barcode,",");
		ModelAndView mav=new ModelAndView();
		mav.setViewName("txm");
		mav.addObject("yclrk_barcode_path", yclrk_barcode_path);
		return mav;
	}
}
