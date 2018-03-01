package com.sop.service;

import java.util.List;

import com.sop.common.ServerResponse;
import com.sop.pojo.Sop;

public interface ISopService {
		ServerResponse saveFile(String fileName,String buMen,String xiTong);
		
		ServerResponse<List<Sop>> search(String buMen,String xiTong);
}
