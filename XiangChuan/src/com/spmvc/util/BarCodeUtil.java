package com.spmvc.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.jbarcode.JBarcode;
import org.jbarcode.encode.Code39Encoder;
import org.jbarcode.encode.EAN13Encoder;
import org.jbarcode.encode.InvalidAtributeException;
import org.jbarcode.paint.BaseLineTextPainter;
import org.jbarcode.paint.EAN13TextPainter;
import org.jbarcode.paint.WideRatioCodedPainter;
import org.jbarcode.paint.WidthCodedPainter;
import org.jbarcode.util.ImageUtil;


/**
 * 生成条形码工具类
 * @author mabaoyun
 *
 */
public class BarCodeUtil {
	/**
	 * 生成条形码的方法
	 * @param code
	 * @param path
	 * @throws InvalidAtributeException 
	 * @throws IOException 
	 */
	public static void createBarCode(String code, String path,String CodeName) throws InvalidAtributeException, IOException {
		/**
		 * JBarCode生成条形码的流程
		 * 1.创建JBarCode对象
		 * 2.设置条形码的类别,绘制条形码图片的对象,绘制条形码的文本对象
		 * 3.设置条形码的图片格式
		 * 4.执行条形码的生成过程（本地磁盘 or 服务器）
		 */
		/**
		 * BarcodeEncoder arg0, 生成条形码规则(EAN13, 欧洲商品条形)
		 * BarcodePainter arg1, 绘制条形码的对象
		 * TextPainter arg2, 绘制条形码的文本对象（条形码图片下方的文字）
		 */
		JBarcode jBarcode = new JBarcode(EAN13Encoder.getInstance(), WidthCodedPainter.getInstance(), EAN13TextPainter.getInstance());
		jBarcode.setEncoder(Code39Encoder.getInstance());
		jBarcode.setPainter(WideRatioCodedPainter.getInstance());
		jBarcode.setTextPainter(BaseLineTextPainter.getInstance());
		jBarcode.setShowCheckDigit(false); //不会显示条形码的最后一位校验码
		/**
		 * Java中BufferedImage来存储图像,为了最后把图片对象写入到本地磁盘中
		 */
		BufferedImage bufferedImage = jBarcode.createBarcode(code);
		saveToPNG(bufferedImage, CodeName, path);
	}
	
	/**
	 * 设置条形码的图片格式
	 * @param bufferedImage
	 * @param fileName
	 * @param path
	 * @throws IOException 
	 */
	private static void saveToPNG(BufferedImage bufferedImage, String fileName, String path) throws IOException {
		saveToFile(bufferedImage, fileName, "png", path);
	}
	
	/**
	 * 制作条形码保存到服务器上
	 * @param bufferedImage
	 * @param fileName
	 * @param suffix
	 * @param path
	 * @throws IOException 
	 */
	private static void saveToFile(BufferedImage bufferedImage, String fileName, String suffix, String path) throws IOException {
		File file = new File(path);
		if (!file.exists()) {
			file.mkdirs();
		}
		FileOutputStream fileOutputStream = new FileOutputStream(path + "/" + fileName + "." + suffix);
		ImageUtil.encodeAndWrite(bufferedImage, suffix, fileOutputStream);
		fileOutputStream.close();
	}
	

}
