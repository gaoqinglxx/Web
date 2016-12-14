package com.spmvc.test;

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
import org.jbarcode.paint.WidthCodedPainter;
import org.jbarcode.util.ImageUtil;
import org.junit.Test;



/**
 * 条形码测试
 * @author mabaoyun
 *
 */
public class CodeTest {
	@Test
	public void f1() throws InvalidAtributeException, IOException{
		/**
		 * BarcodeEncoder arg0, 生成条形码规则(EAN13, 欧洲商品条形)
		 * BarcodePainter arg1, 绘制条形码的对象
		 * TextPainter arg2, 绘制条形码的文本对象（条形码图片下方的文字）
		 */

		JBarcode jBarcode=new JBarcode(EAN13Encoder.getInstance(), WidthCodedPainter.getInstance(), EAN13TextPainter.getInstance());
		jBarcode.setEncoder(Code39Encoder.getInstance());//生成条形码的类别
		jBarcode.setPainter(WidthCodedPainter.getInstance());////输出条形码图像对象
		jBarcode.setTextPainter(BaseLineTextPainter.getInstance());//输出绘制文本的格式
		jBarcode.setShowCheckDigit(false);//条形码的校验方式不用检查
		
		/**
		 * Java中BufferedImage来存储图像,为了最后把图片对象写入到本地磁盘中
		 */
		String code="18398602102";
		BufferedImage bufferedImage=jBarcode.createBarcode(code);
		
		
		/**
		 * 设置图片的后缀名, png, jpeg...
		 */
		saveToPNG(bufferedImage, ""+System.currentTimeMillis(), "code", "D:/"); // D:/code/xxx.png

		
	}
	
	private void saveToPNG(BufferedImage bufferedImage,String fileName,String dirName,String path) throws IOException{
		saveToFile(bufferedImage,fileName,"png",path+dirName);
	}

	private void saveToFile(BufferedImage bufferedImage, String fileName, String suffix, String path) throws IOException {
		File file=new File(path);
		if(!file.exists()){
			file.mkdirs();
		}
		FileOutputStream fileOutputStream=new FileOutputStream(path+"/"+fileName+"."+suffix);
		ImageUtil.encodeAndWrite(bufferedImage, suffix, fileOutputStream);
		fileOutputStream.close();
		
	}
}
