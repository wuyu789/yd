package com.fujitsu.ttf.yd.service;

import java.util.List;

public interface PDFService {
	
   public void PDFMerge(List<String> list,String targetAddress,String handbookName,String token,String compony,String customer);
   
   public void addMerge(String data,String fileOutPath,int id);
}
