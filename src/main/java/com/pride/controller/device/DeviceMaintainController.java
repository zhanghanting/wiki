package com.pride.controller.device;

import com.pride.domain.DeviceCheck;
import com.pride.domain.DeviceFault;
import com.pride.domain.DeviceMaintain;
import com.pride.domain.typecode.TypeCode;
import com.pride.service.device.DeviceMaintainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/erp")
public class DeviceMaintainController {

    @Autowired
    DeviceMaintainService deviceMaintainService;

    @RequestMapping("/device/deviceMaintain")
    public String deviceMaintain(){
        return "deviceMaintain";
    }

    @RequestMapping("/deviceMaintain/list")
    @ResponseBody
    public List<DeviceMaintain> querryAllDeviceMaintain(){
        List<DeviceMaintain> rows = deviceMaintainService.queryAllDeviceMaintain();
        return rows;
    }

    @RequestMapping("/deviceMaintain/add")
    public String addDeviceMaintain(){
        return "deviceMaintain_add";
    }

    @RequestMapping("/deviceMaintain/add_judge")
    @ResponseBody
    public String addJudgeDeviceMaintain(){
        return null;
    }

    @RequestMapping("/deviceMaintain/insert")
    @ResponseBody
    public TypeCode insertDeviceMaintain(DeviceMaintain deviceMaintain){
        return deviceMaintainService.insertDeviceMaintain(deviceMaintain);
    }

    @ResponseBody
    @RequestMapping("/deviceMaintain/delete_judge")
    public String deleteJudgeDeviceMaintain(){
        return null;
    }

    @ResponseBody
    @RequestMapping("/deviceMaintain/delete_batch")
    public TypeCode deleteBatchDeviceMaintain(String[] ids){
        return deviceMaintainService.deleteDeviceMaintainByIds(ids);
    }

    @ResponseBody
    @RequestMapping("/deviceMaintain/edit_judge")
    public String editJudgeDeviceMaintain(){
        return null;
    }

    @RequestMapping("/deviceMaintain/edit")
    public String editDeviceMaintain(){
        return "deviceMaintain_edit";
    }

    @ResponseBody
    @RequestMapping("/deviceMaintain/update")
    public TypeCode updateDeviceMaintain(DeviceMaintain deviceMaintain){
        return deviceMaintainService.updateDeviceMaintainById(deviceMaintain);
    }

}
