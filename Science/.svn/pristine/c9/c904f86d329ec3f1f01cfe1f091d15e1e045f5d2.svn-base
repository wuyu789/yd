///**
// * 
// */
//package com.fujitsu.ttf.yd.test;
//import java.awt.Color;
//import java.awt.Font;
//import java.awt.Graphics2D;
//import java.awt.Image;
//import java.awt.image.BufferedImage;
//import java.io.FileOutputStream;
//import javax.swing.ImageIcon;
//import com.sun.image.codec.jpeg.JPEGCodec;
//import com.sun.image.codec.jpeg.JPEGEncodeParam;
//import com.sun.image.codec.jpeg.JPEGImageEncoder;
//
///**
// * @author wuyu
// *
// */
//public class ImageEdit {
//    public static void main(String[] args) {
//    	ImageEdit.createStringMark("C:\\Users\\wuyu\\Desktop\\img\\1.jpg", "测试文字","C:\\Users\\wuyu\\Desktop\\A.jpg");
//	}
//    
//    public static boolean createStringMark(String filePath,String markContent,String outPath) 
//	{ 
//	ImageIcon imgIcon=new ImageIcon(filePath); 
//	Image theImg =imgIcon.getImage(); 
//	int width=theImg.getWidth(null)==-1?200:theImg.getWidth(null); 
//	int height= theImg.getHeight(null)==-1?200:theImg.getHeight(null); 
//	System.out.println(width);
//	System.out.println(height);
//	System.out.println(theImg);
//	BufferedImage bimage = new BufferedImage(width,height, BufferedImage.TYPE_INT_BGR); 
//	Graphics2D g=bimage.createGraphics(); 
//	
//	Color mycolor = Color.black; 
//    g.setColor(mycolor); 
//	g.setBackground(Color.black); 
//	g.drawImage(theImg, 0, 0, null ); 
//	g.setFont(new Font("宋体",Font.PLAIN,30)); //字体、字型、字号 
//	g.drawString(markContent,width/3,height-50); //画文字 
//	g.dispose(); 
//	try 
//	{ 
//	FileOutputStream out=new FileOutputStream(outPath); //先用一个特定的输出文件名 
//	JPEGImageEncoder encoder =JPEGCodec.createJPEGEncoder(out); 
//	JPEGEncodeParam param = encoder.getDefaultJPEGEncodeParam(bimage); 
//	param.setQuality(100, true);  //
//	encoder.encode(bimage, param); 
//	out.close(); 
//	} 
//	catch(Exception e) 
//	{ return false; } 
//	return true; 
//	} 
//}
