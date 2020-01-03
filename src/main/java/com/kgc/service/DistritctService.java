package com.kgc.service;

import com.github.pagehelper.PageInfo;
import com.kgc.po.District;
import com.kgc.util.PageUtil;

public interface DistritctService {
     /**
      * 查询区域带分页
      * @param pageUtil
      *   page属性接收页码，rows接收页大小
      * @return
      */
     public PageInfo<District> getDistrictByPage(PageUtil pageUtil);

     /**
      * 添加区域
      * @param district 区域实体信息
      * @return 影响行数
      */
     public int addDistrict(District district);

     public District findById(Integer id);

     public int updateDistrict(District district);

     public void deleteDistrict(Integer id);

}
