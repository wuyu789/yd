package com.fujitsu.ttf.yd.test;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

public class PDFCreaet {
	
	public static void creatPdf(Map<String, Object> map,String filePath) {
        try {
            FileOutputStream out = new FileOutputStream(filePath);// 输出流
            PdfReader reader = new PdfReader("C:\\Users\\Administrator\\Desktop\\cover_end.pdf");// 读取pdf模板
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            PdfStamper stamper = new PdfStamper(reader, bos);
            stamper.setFormFlattening(true);
            AcroFields form = stamper.getAcroFields();
            // 文字类的内容处理
            Map<String, String> datemap = (Map<String, String>) map.get("datemap");
            // 设置字体风格
            for (String key : datemap.keySet()) {
                if(key.equals("title")) {
                	BaseFont bfComic = BaseFont.createFont("c://windows//fonts//SIMHEI.TTF", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
                	form.setFieldProperty("title","textfont",bfComic,null);
                	form.setFieldProperty("title","textcolor",new BaseColor(255,165,0),null);
                	form.setFieldProperty("title","textsize",(float)17,null);
                	form.setFieldProperty("title","bgcolor",new BaseColor(0,0,0),null);
                	form.setFieldProperty("title","bordercolor",new BaseColor(0,0,0),null);
                	
                }else if(key.equals("compony")){
                	BaseFont bf= BaseFont.createFont("STSong-Light", "UniGB-UCS2-H",BaseFont.EMBEDDED);
                	form.setFieldProperty("compony","textcolor",new BaseColor(255,255,255),null);
                	form.setFieldProperty("compony","textfont",bf,null);
                	form.setFieldProperty("compony","bgcolor",new BaseColor(0,0,0),null);
                	form.setFieldProperty("compony","bordercolor",new BaseColor(0,0,0),null);
                }
                else if(key.equals("customer")){
                	BaseFont bf= BaseFont.createFont("STSong-Light", "UniGB-UCS2-H",BaseFont.EMBEDDED);
                	form.setFieldProperty("customer","textcolor",new BaseColor(255,255,255),null);
                	form.setFieldProperty("customer","textfont",bf,null);
                	form.setFieldProperty("customer","bgcolor",new BaseColor(0,0,0),null);
                	form.setFieldProperty("customer","bordercolor",new BaseColor(0,0,0),null);
                }
                String value = datemap.get(key);
                form.setField(key, value);
            }
            // 图片类的内容处理
            Map<String, String> imgmap = (Map<String, String>) map.get("imgmap");
            for (String key : imgmap.keySet()) {
                String value = imgmap.get(key);
                String imgpath = value;
                int pageNo = form.getFieldPositions(key).get(0).page;
                Rectangle signRect = form.getFieldPositions(key).get(0).position;
                float x = signRect.getLeft();
                float y = signRect.getBottom();
                // 根据路径读取图片
                Image image = Image.getInstance(imgpath);
                // 获取图片页面
                PdfContentByte under = stamper.getOverContent(pageNo);
                // 图片大小自适应
                image.scaleToFit(signRect.getWidth(), signRect.getHeight());
                // 添加图片
                image.setAbsolutePosition(x, y);
                under.addImage(image);
            }
            stamper.setFormFlattening(true);// 如果为false，生成的PDF文件可以编辑，如果为true，生成的PDF文件不可以编辑
            stamper.close();
            Document doc = new Document();
            PdfCopy copy = new PdfCopy(doc, out);
            doc.open();
            int pageNum = reader.getNumberOfPages();
             for(int i = 1;i <= pageNum;i++){
                 PdfImportedPage importPage = copy.getImportedPage(new PdfReader(bos.toByteArray()), i);
                 copy.addPage(importPage);
             }
            doc.close();
        } catch (IOException e) {
            System.out.println(e);
        } catch (DocumentException e) {
            System.out.println(e);
        }

    }
	
	public static void main(String[] args) throws IOException, DocumentException {
		//文字类
		Map<String, String> dataMap = new HashMap<String, String>();
		dataMap.put("title", "这是一个标题");
		dataMap.put("compony", "这是一个公司名称");
		dataMap.put("customer", "这是一个客户名称");

		//图片
		String knowImgPath = "C:\\Users\\Administrator\\Desktop\\1.png";
		Map<String, String> imgMap = new HashMap<String, String>();
		imgMap.put("img", knowImgPath);


		Map<String, Object> o = new HashMap<String, Object>();
		o.put("datemap", dataMap);
		o.put("imgmap", imgMap);

		creatPdf(o,"E:\\pdf\\cover.pdf");
    }
}
