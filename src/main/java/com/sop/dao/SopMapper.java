package com.sop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sop.pojo.Sop;

public interface SopMapper {
			int insert(@Param("fileName")String fileName,@Param("buMen")String buMen,@Param("xiTong")String xiTong);

			List<Sop> selectByXiTongAndBuMen(@Param("buMen")String buMen, @Param("xiTong")String xiTong);
}
