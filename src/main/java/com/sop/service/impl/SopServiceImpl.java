package com.sop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sop.common.ServerResponse;
import com.sop.dao.SopMapper;
import com.sop.pojo.Sop;
import com.sop.service.ISopService;

@Service("iSopService")
public class SopServiceImpl implements ISopService{
		@Autowired
		private SopMapper sopMapper;
		
public ServerResponse saveFile(String fileName,String buMen,String xiTong){
	int rowCount = sopMapper.insert(fileName,buMen,xiTong);
	if(rowCount > 0){
		return ServerResponse.createBySuccessMessage("上传成功！");
	}else{
		return ServerResponse.createBySuccessMessage("上传失败！");
	}
}
public ServerResponse<List<Sop>> search(String buMen,String xiTong){
	List<Sop> sop=sopMapper.selectByXiTongAndBuMen(buMen,xiTong);
	if(sop == null){
		return ServerResponse.createByErrorMessage("没有符合该条件的Sop!");
	}
	return ServerResponse.createBySuccess(sop);
}
}
