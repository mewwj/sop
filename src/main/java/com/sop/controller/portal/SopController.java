package com.sop.controller.portal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sop.common.ServerResponse;
import com.sop.pojo.Sop;
import com.sop.service.ISopService;

@Controller
@RequestMapping("/portal/")
public class SopController<T>{
	@Autowired
	ISopService iSopService;
	
@RequestMapping("search.do")
@ResponseBody
public  ServerResponse<List<Sop>> search(@RequestParam(value="buMen") String buMen,@RequestParam(value="xiTong")String xiTong){
		System.out.println(buMen  +"---"+ xiTong);
		if(buMen.equals("所有")||xiTong.equals("所有")){
			buMen="";
			xiTong="";
			return iSopService.search(buMen, xiTong);
		}
		return iSopService.search(buMen, xiTong);
	}

	
	
	
}
