package com.fujitsu.ttf.yd.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fujitsu.ttf.yd.entity.Collect;
import com.fujitsu.ttf.yd.entity.HistorySearch;
import com.fujitsu.ttf.yd.entity.SecondLevelDirectory;
import com.fujitsu.ttf.yd.entity.ThirdLevelDirectory;
import com.fujitsu.ttf.yd.entity.TypeOne;
import com.fujitsu.ttf.yd.entity.TypeTwo;
import com.fujitsu.ttf.yd.mapper.CollectMapper;
import com.fujitsu.ttf.yd.mapper.HistorySearchMapper;
import com.fujitsu.ttf.yd.mapper.ThirdLevelDirectoryMapper;
import com.fujitsu.ttf.yd.mapper.TypeOneMapper;
import com.fujitsu.ttf.yd.mapper.TypeTwoMapper;
import com.fujitsu.ttf.yd.service.SecondLevelDirectoryService;
import com.fujitsu.ttf.yd.service.ThirdLevelDirectoryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mysql.cj.util.StringUtils;

/**
 * @author wuyu
 *
 */
@Service
public class ThirdLevelDirectoryServiceImpl implements ThirdLevelDirectoryService {

	@Autowired
	private ThirdLevelDirectoryMapper thirdLevelDirectoryMapper;
	
	@Autowired
	private TypeOneMapper typeOneMapper;
	
	@Autowired
	private TypeTwoMapper typeTwoMapper;

	@Autowired
	private CollectMapper collectMapper;
	
	@Autowired
	private SecondLevelDirectoryService secondLevelDirectoryService;
	
	@Autowired
	private HistorySearchMapper historySearchMapper;
	
	
	@Override
	public Object getAllThirdLevelDirectoryBySecondId(Integer secondId,Integer page,Integer pageSize,String openid) {
		return getAllProductList(secondId,page,pageSize,openid);
	}
	
	/**
	 * 初始化三级目录时候显示的数据
	 * @param secondId
	 * @return
	 */
	private Object getAllProductList(int secondId,Integer page,Integer pageSize,String openid) {
		if(page==null || pageSize==null) {
			page=1;
			pageSize=10;
		}
		List<ThirdLevelDirectory> list = thirdLevelDirectoryMapper
				.getAllThirdLevelDirectoryBySecondId(secondId);
		if(secondId==1 || secondId==2) {
			for (ThirdLevelDirectory thrid : list) {
				//  1:工程机械    2:轨道交通   3： 乘员舱 4: 车身 5: 转向架 6: 动力总成 7: 驾驶员工作区
				if (thrid.getSecondId() == 1) {
					thrid.setPdfName("/construction_machinery/industrial_rubber_hose/" + thrid.getPdfName());
					thrid.setThirdImg("/construction_machinery/hose_img/" + thrid.getThirdImg());
					thrid.setPdfImg("/construction_machinery/pdf_img/"+thrid.getPdfImg());
					TypeOne typeOne = typeOneMapper.selectTypeOneById(thrid.getTypeId());
					thrid.setTypeOne(typeOne);
					thrid.setProductName(typeOne.getProductName());
				} else if (thrid.getSecondId() == 2) {
					thrid.setPdfName("/construction_machinery/hydraulic_hose/" + thrid.getPdfName());
					thrid.setThirdImg("/construction_machinery/hose_img/" + thrid.getThirdImg());
					thrid.setPdfImg("/construction_machinery/pdf_img/"+thrid.getPdfImg());
					TypeTwo typeTwo = typeTwoMapper.selectTypeTwoById(thrid.getTypeId());
					thrid.setTypeTwo(typeTwo);
					thrid.setProductName(typeTwo.getProductName());
				}
			}
			// 去重以后的数据
			List<ThirdLevelDirectory> result = removeDupliByProductName(list);
			
			PageInfo<ThirdLevelDirectory> entityPage = new PageInfo<ThirdLevelDirectory>(result);
			
			if(entityPage.getPages()<page) {
				result=null;
			}
			entityPage.setList(result);
			return entityPage;
			
		}else {
			List<ThirdLevelDirectory> thirdLevelDirectoryList = new ArrayList<ThirdLevelDirectory>();
			for (int i = 0; i < list.size(); i++) {
				ThirdLevelDirectory directory = new ThirdLevelDirectory();
				int id = list.get(i).getId();
				directory.setId(id);
				directory.setTitle(list.get(i).getTitle());
				directory.setSecondId(list.get(i).getSecondId());
				directory.setThirdName(list.get(i).getThirdName());
				directory.setDescribe(list.get(i).getDescribe());
				directory.setTypeId(list.get(i).getTypeId());
				// 通过用户id获取收藏表中的记录
				List<Collect> collectList = collectMapper.selectCollectThirdId(openid);
				if(collectList.size()!=0) {
					for(Collect collect:collectList) {
						if(collect.getThirdId()==id) {
							directory.setIsCollect(1);
							break;
						}else {
							directory.setIsCollect(0);
						}
					}
				}else {
					directory.setIsCollect(0);
				}
				//  3： 乘员舱 4: 车身 5: 转向架 6: 动力总成 7: 驾驶员工作区   8 :空气弹簧
                
				directory.setPdfName("/rail_transit/pdf/" + list.get(i).getPdfName());
				directory.setThirdImg("/rail_transit/img/" + list.get(i).getThirdImg());
				directory.setPdfImg("/rail_transit/pdf_img/"+ list.get(i).getPdfImg());
				
				if(secondId==8) {
					String[] pdfNameArr = list.get(i).getPdfName().split(",");
					List<String> pdfNameList=new ArrayList<>();
					for(String pdfName:pdfNameArr) {
						pdfNameList.add("/air_suspension/pdf/"+pdfName);
					}
					directory.setPdfName(pdfNameList.toString().substring(1, pdfNameList.toString().length()-1));
					
					directory.setThirdImg("/air_suspension/img/" + list.get(i).getThirdImg());
					
					String[] pdfImgArr = list.get(i).getPdfImg().split(",");
					List<String> pdfImgList=new ArrayList<>();
					for(String pdfImg:pdfImgArr) {
						pdfImgList.add("/air_suspension/pdf_img/"+pdfImg);
					}
					directory.setPdfImg(pdfImgList.toString().substring(1, pdfImgList.toString().length()-1));
				}
				
				thirdLevelDirectoryList.add(directory);
			}
			PageInfo<ThirdLevelDirectory> entityPage = new PageInfo<ThirdLevelDirectory>(list);
			
			if(entityPage.getPages()<page) {
				thirdLevelDirectoryList=null;
			}
			entityPage.setList(thirdLevelDirectoryList);
			return entityPage;
		}
		
		
	}
	
	/**
	 * 去重
	 * @param list
	 * @return
	 */
	private List<ThirdLevelDirectory> removeDupliByProductName(List<ThirdLevelDirectory> list) {
		Set<ThirdLevelDirectory> personSet = new TreeSet<ThirdLevelDirectory>(
				(o1, o2) -> o1.getProductName().compareTo(o2.getProductName()));
		personSet.addAll(list);
		return new ArrayList<ThirdLevelDirectory>(personSet);
	}


	@Override
	public Object selectThirdLevelDirectoryByThirdName(String thirdName,Integer page,Integer pageSize,String openid) {
		HistorySearch HistorySearch=new HistorySearch();
		HistorySearch.setHistorySearchName(thirdName);
		HistorySearch.setOpenId(openid);
		// 历史搜索记录的增加
		historySearchMapper.insertData(HistorySearch);
		if(page==null || pageSize==null) {
			page=1;
			pageSize=10;
		}
		List<ThirdLevelDirectory> list=null;
		if(StringUtils.isNullOrEmpty(thirdName)) {
			PageHelper.startPage(page, pageSize);
			list = thirdLevelDirectoryMapper.selectThirdLevelDirectory();
		}else {
			List<TypeOne> typeOneList = typeOneMapper.getDataByProductName(thirdName);
			if(typeOneList.size()!=0 && typeOneList!=null) {
				PageHelper.startPage(page, pageSize);
				list=thirdLevelDirectoryMapper.getDataType1(thirdName);
			}else {
				List<TypeTwo> typeTwoList = typeTwoMapper.getDataByProductName(thirdName);
				if(typeTwoList.size()!=0 && typeTwoList!=null) {
					PageHelper.startPage(page, pageSize);
					list=thirdLevelDirectoryMapper.getDataType2(thirdName);
				}else {
					PageHelper.startPage(page, pageSize);
					list = thirdLevelDirectoryMapper.selectThirdLevelDirectoryByThirdName(thirdName);	
				}
			}
		}
		
		List<ThirdLevelDirectory> thirdLevelDirectoryList = new ArrayList<ThirdLevelDirectory>();
		for (int i = 0; i < list.size(); i++) {
			ThirdLevelDirectory directory = new ThirdLevelDirectory();
			int id = list.get(i).getId();
			directory.setId(id);
			directory.setSecondId(list.get(i).getSecondId());
			directory.setThirdName(list.get(i).getThirdName());
			directory.setDescribe(list.get(i).getDescribe());
			directory.setTypeId(list.get(i).getTypeId());
			directory.setTitle(list.get(i).getTitle());
			// 通过用户id获取收藏表中的记录
			List<Collect> collectList = collectMapper.selectCollectThirdId(openid);
			if(collectList.size()!=0) {
				for(Collect collect:collectList) {
					if(collect.getThirdId()==id) {
						directory.setIsCollect(1);
						break;
					}else {
						directory.setIsCollect(0);
					}
				}
			}else {
				directory.setIsCollect(0);
			}
			// 1: 工业胶管 2：液压胶管 3： 乘员舱 4: 车身 5: 转向架 6: 动力总成 7: 驾驶员工作区
			if (list.get(i).getSecondId() == 1) {
				directory.setPdfName("/construction_machinery/industrial_rubber_hose/" + list.get(i).getPdfName());
				directory.setThirdImg("/construction_machinery/hose_img/" + list.get(i).getThirdImg());
				directory.setPdfImg("/construction_machinery/pdf_img/"+list.get(i).getPdfImg());
			} else if (list.get(i).getSecondId() == 2) {
				directory.setPdfName("/construction_machinery/hydraulic_hose/" + list.get(i).getPdfName());
				directory.setThirdImg("/construction_machinery/hose_img/" + list.get(i).getThirdImg());
				directory.setPdfImg("/construction_machinery/pdf_img/"+list.get(i).getPdfImg());
			} else{
				directory.setPdfName("/rail_transit/pdf/" + list.get(i).getPdfName());
				directory.setThirdImg("/rail_transit/img/" + list.get(i).getThirdImg());
				directory.setPdfImg("/rail_transit/pdf_img/"+list.get(i).getPdfImg());
			}
			thirdLevelDirectoryList.add(directory);
		}
		PageInfo<ThirdLevelDirectory> entityPage = new PageInfo<ThirdLevelDirectory>(list);
		
		if(entityPage.getPages()<page) {
			thirdLevelDirectoryList=null;
		}
		if(thirdLevelDirectoryList!=null) {
			for(ThirdLevelDirectory directory:thirdLevelDirectoryList) {
				if(directory.getSecondId()==1) {
					TypeOne typeOne = typeOneMapper.selectTypeOneById(directory.getTypeId());
					directory.setTypeOne(typeOne);
				}else if(directory.getSecondId()==2) {
					TypeTwo typeTwo = typeTwoMapper.selectTypeTwoById(directory.getTypeId());
					directory.setTypeTwo(typeTwo);
				}
			}
		}
		entityPage.setList(thirdLevelDirectoryList);
		return entityPage;
	}

	@Override
	public ThirdLevelDirectory selectDataByThirdName(String thirdName) {
		
		return thirdLevelDirectoryMapper.selectDataByThirdName(thirdName);
	}

	@Override
	public Object selectCollectDirectory(String openid,Integer page,Integer pageSize) {
		if(page==null || pageSize==null) {
			page=1;
			pageSize=10;
		}
		PageHelper.startPage(page, pageSize);
		List<ThirdLevelDirectory> list = thirdLevelDirectoryMapper.selectCollectDirectory(openid);
		if(list!=null) {
			for(ThirdLevelDirectory directory:list) {
				// 0:没有被收藏   1:被收藏
				directory.setIsCollect(1);
				// 1.工具胶管   2.液压胶管   
				if (directory.getSecondId() == 1) {
					directory.setPdfName("/construction_machinery/industrial_rubber_hose/" + directory.getPdfName());
					directory.setThirdImg("/construction_machinery/hose_img/" + directory.getThirdImg());
					directory.setPdfImg("/construction_machinery/pdf_img/"+directory.getPdfImg());
					TypeOne typeOne = typeOneMapper.selectTypeOneById(directory.getTypeId());
					directory.setTypeOne(typeOne);
				} else if (directory.getSecondId() == 2) {
					directory.setPdfName("/construction_machinery/hydraulic_hose/" + directory.getPdfName());
					directory.setThirdImg("/construction_machinery/hose_img/" + directory.getThirdImg());
					directory.setPdfImg("/construction_machinery/pdf_img/"+directory.getPdfImg());
					TypeTwo typeTwo = typeTwoMapper.selectTypeTwoById(directory.getTypeId());
					directory.setTypeTwo(typeTwo);
				} else{
					directory.setPdfName("/rail_transit/pdf/" + directory.getPdfName());
					directory.setThirdImg("/rail_transit/img/" + directory.getThirdImg());
					directory.setPdfImg("/rail_transit/pdf_img/"+directory.getPdfImg());
				}
			}
		}
		PageInfo<ThirdLevelDirectory> entityPage = new PageInfo<ThirdLevelDirectory>(list);
		if(entityPage.getPages()<page) {
			list=null;
		}
		if(list!=null) {
			for(ThirdLevelDirectory directory:list) {
				if(directory.getSecondId()==1) {
					TypeOne typeOne = typeOneMapper.selectTypeOneById(directory.getTypeId());
					directory.setTypeOne(typeOne);
				}else if(directory.getSecondId()==2) {
					TypeTwo typeTwo = typeTwoMapper.selectTypeTwoById(directory.getTypeId());
					directory.setTypeTwo(typeTwo);
				}
			}
		}
		entityPage.setList(list);
		return entityPage;
	}

	@Override
	public void insertCollect(String openid, Integer thirdId) {
		
		thirdLevelDirectoryMapper.insertCollect(openid, thirdId);
	}

	@Override
	public void deleteCollect(String openid, Integer thirdId) {
		
		thirdLevelDirectoryMapper.deleteCollect(openid, thirdId);
	}

	@Override
	public ThirdLevelDirectory selectThirdLevelDirectoryById(Integer thirdId) {
		return thirdLevelDirectoryMapper.selectThirdLevelDirectoryById(thirdId);
	}

	@Override
	public void updateData(Integer thirdId, Integer collectCount) {
		thirdLevelDirectoryMapper.updateData(thirdId, collectCount);
		
	}

	@Override
	public void addClickNum(String thirdName) {
		// 通过三级目录的名称获取该条记录
		ThirdLevelDirectory directory = thirdLevelDirectoryMapper.getDataByThirdName(thirdName);
		Integer clickNum = directory.getClickNum();
		if(clickNum==null) {
			clickNum=0;
		}
		clickNum++;
		thirdLevelDirectoryMapper.addClickNum(thirdName,clickNum);
	}

	@Override
	public void addDownloadNum(String thirdName) {
		if(!thirdName.equals("")) {
			String[] thirdNameArr = thirdName.split(",");
			for(String name:thirdNameArr) {
				ThirdLevelDirectory directory = thirdLevelDirectoryMapper.getDataByThirdName(name);
				Integer downloadNum = directory.getDownloadNum();
				if(downloadNum==null) {
					downloadNum=0;
				}
				downloadNum++;
				thirdLevelDirectoryMapper.addDownloadNum(name,downloadNum);
			}
			
		}
		
	}

	@Override
	public Object selectDownloadNumAndClickNum(Integer firstDirectoryId,Integer secondDirectoryId,Integer page,Integer pageSize) {
		if(page==null || pageSize==null) {
			page=1;
			pageSize=10;
		}
		String secondArray="";
		List<ThirdLevelDirectory> list=null;
		if(firstDirectoryId!=null) {
			List<SecondLevelDirectory> directoryList = secondLevelDirectoryService.getAllSecondDirectoryByFirstId(firstDirectoryId);
			List<Integer> secondList=new ArrayList<>();
			for(SecondLevelDirectory directory:directoryList) {
				Integer id = directory.getId();
				secondList.add(id);
			}
			secondArray=convertStr(secondList);
			if(secondDirectoryId!=null) {
				if(secondArray.contains(Integer.toString(secondDirectoryId))) {
					PageHelper.startPage(page, pageSize);
					// 获取三级目录表中的数据
					list = thirdLevelDirectoryMapper.selectDownloadNumAndClickNum(Integer.toString(secondDirectoryId));
				}
			}else {
				PageHelper.startPage(page, pageSize);
				// 获取三级目录表中的数据
				list = thirdLevelDirectoryMapper.selectDownloadNumAndClickNum(secondArray);
			}
		}else {
			if(secondDirectoryId!=null) {
				PageHelper.startPage(page, pageSize);
				// 获取三级目录表中的数据
				list = thirdLevelDirectoryMapper.selectDownloadNumAndClickNum(Integer.toString(secondDirectoryId));
			}else {
				PageHelper.startPage(page, pageSize);
				// 获取三级目录表中的数据
				list = thirdLevelDirectoryMapper.selectDownloadNumAndClickNum(secondArray);
			}
		}
		if(list!=null) {
			for(ThirdLevelDirectory thirdLevelDirectory:list) {
				Integer clickNum = thirdLevelDirectory.getClickNum();
				Integer downloadNum = thirdLevelDirectory.getDownloadNum();
				Integer secondId = thirdLevelDirectory.getSecondId();
				Integer id = thirdLevelDirectory.getTypeId();
				if(clickNum==null) {
					clickNum=0;
				}
				if(downloadNum==null) {
					downloadNum=0;
				}
				// 工业胶管
				if(secondId.equals(1)) {
					ThirdLevelDirectory directory = thirdLevelDirectoryMapper.selectThirdLevelDirectoryAndTypeOne(id);
					thirdLevelDirectory.setThirdName(directory.getProductName());
					thirdLevelDirectory.setHoseId(directory.getHoseId());
					thirdLevelDirectory.setHoseOd(directory.getHoseOd());
					thirdLevelDirectory.setWpPsi(directory.getWpPsi());
					thirdLevelDirectory.setLowestTemperature(directory.getLowestTemperature());
					thirdLevelDirectory.setHighestTemperature(directory.getHighestTemperature());
					thirdLevelDirectory.setClassification(directory.getClassification());
					thirdLevelDirectory.setMedium(directory.getMedium());
				}else if(secondId.equals(2)) {
					//液压胶管
					ThirdLevelDirectory directory = thirdLevelDirectoryMapper.selectThirdLevelDirectoryAndTypeTwo(id);
					thirdLevelDirectory.setThirdName(directory.getProductName());
					thirdLevelDirectory.setPartNumber(directory.getPartNumber());
					thirdLevelDirectory.setHoseId(directory.getHoseId());
					thirdLevelDirectory.setWpMpa(directory.getWpMpa());
					thirdLevelDirectory.setSpiralOrBraid(directory.getSpiralOrBraid());
					thirdLevelDirectory.setLowestTemperature(directory.getLowestTemperature());
					thirdLevelDirectory.setHighestTemperature(directory.getHighestTemperature());
				}else {
					thirdLevelDirectory.setThirdName(thirdLevelDirectory.getTitle());
				}
			}
		}
		
		PageInfo<ThirdLevelDirectory> entityPage = new PageInfo<ThirdLevelDirectory>(list);
		return entityPage;
	}
	
	/**
	 * @Description 将set 转成 string （1，2，3）
	 * @param idSet set 集合
	 * @return 字符串
	 */
	private String convertStr(List<Integer> idSet) {

		String idStr = "";
		for (Integer loopId : idSet) {
			idStr += loopId + ",";
		}

		return idStr.substring(0, idStr.length() - 1);
	}

}
