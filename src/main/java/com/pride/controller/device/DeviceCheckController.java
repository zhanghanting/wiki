package com.pride.controller.device;

import com.pride.domain.DeviceCheck;
import com.pride.domain.DeviceType;
import com.pride.domain.typecode.TypeCode;
import com.pride.service.device.DeviceCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/erp")
public class DeviceCheckController {

    @Autowired
    DeviceCheckService deviceCheckService;

    @RequestMapping("/device/deviceCheck")
    public String deviceCheck(){
        return "deviceCheck";
    }

    @RequestMapping("/deviceCheck/list")
    @ResponseBody
    public List<DeviceCheck> querryAllDeviceCheck(){
        List<DeviceCheck> rows = deviceCheckService.queryAllDeviceCheck();
        return rows;
    }

    @RequestMapping("/deviceCheck/add")
    public String addDeviceCheck(){
        return "deviceCheck_add";
    }

    @RequestMapping("/deviceCheck/add_judge")
    @ResponseBody
    public String addJudgeDeviceCheck(){
        return null;
    }

    @RequestMapping("/deviceCheck/insert")
    @ResponseBody
    public TypeCode insertDeviceCheck(DeviceCheck deviceCheck){
        return deviceCheckService.insertDeviceCheck(deviceCheck);
    }

    @ResponseBody
    @RequestMapping("/deviceCheck/delete_judge")
    public String deleteJudgeDeviceCheck(){
        return null;
    }

    @ResponseBody
    @RequestMapping("/deviceCheck/delete_batch")
    public TypeCode deleteBatchDeviceCheck(String[] ids){
        return deviceCheckService.deleteDeviceCheckByIds(ids);
    }

    @ResponseBody
    @RequestMapping("/deviceCheck/edit_judge")
    public String editJudgeDeviceCheck(){
        return null;
    }

    @RequestMapping("/deviceCheck/edit")
    public String editDeviceCheck(){
        return "deviceCheck_edit";
    }

    @ResponseBody
    @RequestMapping("/deviceCheck/update")
    public TypeCode updateDeviceCheck(DeviceCheck deviceCheck){
        return deviceCheckService.updateDeviceCheckById(deviceCheck);
    }


}
