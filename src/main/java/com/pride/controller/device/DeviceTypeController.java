package com.pride.controller.device;


import com.pride.domain.DeviceType;
import com.pride.domain.typecode.TypeCode;
import com.pride.service.device.DeviceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/erp")
public class DeviceTypeController {

    @Autowired
    DeviceTypeService deviceTypeService;

    @RequestMapping("/device/deviceType")
    public String deviceType(){
        return "deviceType";
    }

    @ResponseBody
    @RequestMapping("/deviceType/list")
    public List<DeviceType> queryAllDeviceType(){
        List<DeviceType> rows = deviceTypeService.queryAllDeviceType();
        return rows;
    }

    @RequestMapping("/deviceType/add")
    public String addDeviceType(){
        return "deviceType_add";
    }

    @RequestMapping("deviceType/add_judge")
    @ResponseBody
    public String addJudgeDeviceType(){
        return null;
    }

    @RequestMapping("deviceType/insert")
    @ResponseBody
    public TypeCode insertDeviceType(DeviceType deviceType){
        return deviceTypeService.insertDeviceType(deviceType);
    }


    @ResponseBody
    @RequestMapping("deviceType/delete_judge")
    public String deleteJudgeDeviceType(){
        return null;
    }

    @ResponseBody
    @RequestMapping("deviceType/delete_batch")
    public TypeCode deleteBatchDeviceType(String[] ids){
        return deviceTypeService.deleteDeviceTypeByIds(ids);
    }

    @ResponseBody
    @RequestMapping("get_data")
    public List<DeviceType> getdata(){
        return deviceTypeService.queryAllDeviceType();
    }

}
