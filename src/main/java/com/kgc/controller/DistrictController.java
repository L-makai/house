package com.kgc.controller;

import com.github.pagehelper.Dialect;
import com.github.pagehelper.PageInfo;
import com.kgc.po.District;
import com.kgc.service.DistritctService;
import com.kgc.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.beans.Transient;
import java.util.HashMap;
import java.util.Map;

@RestController // @Controller+ @ResponseBody
@RequestMapping("/admin/")  //指定请求前缀
public class DistrictController {

    @Autowired
    private DistritctService distritctService;

    @RequestMapping("getDistrictData")   //page ,rows
    public Map<String,Object> getDistrictData(PageUtil pageUtil){
        //调用业务区域数据
        PageInfo<District> pageInfo=distritctService.getDistrictByPage(pageUtil);

        //封装返回数据
        Map<String,Object> map=new HashMap<>();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }

    //添加
    @RequestMapping("addDistrict")
    public String addDistrict(District district){
        try {
            //调用业务
            int result=distritctService.addDistrict(district);
            //封装返回数据
            // Map<String,Object> map=new HashMap<>();   //自动转json
            // map.put("result",result);
            return "{\"result\":"+result+"}";   //拼接的json
        }catch (Exception e){
            return "{\"result\":-1}";
        }
    }

    @RequestMapping("getDistrict")
    public District getDistrict(Integer id){
        try {
            District district = distritctService.findById(id);
            return district;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("updateDistrict")
    public String updateDistrict(District district){
        try {
            int result = distritctService.updateDistrict(district);
            return "{\"result\":"+result+"}";
        }catch (Exception e){
            e.printStackTrace();
            return "{\"result\":-1}";
        }
    }

    @RequestMapping("delDistrict")
    public String delDistrict(Integer id){
        try {
            distritctService.deleteDistrict(id);
            return "{\"result\":1}";
        }catch (Exception e){
            e.printStackTrace();
            return "{\"result\":-1}";
        }
    }
}
