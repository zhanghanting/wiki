package com.pride.controller.device;

import com.pride.domain.Device;
import com.pride.domain.DeviceFault;
import com.pride.domain.DeviceType;
import com.pride.domain.typecode.TypeCode;
import com.pride.service.device.DeviceFaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/erp")
public class DeviceFaultController {

    @Autowired
    DeviceFaultService deviceFaultService;

    @RequestMapping("/device/deviceFault")
    public String deviceFault(){
        return "deviceFault";
    }

    @RequestMapping("/deviceFault/list")
    @ResponseBody
    public List<DeviceFault> queryAllDeviceFault(){
        List<DeviceFault> rows = deviceFaultService.queryAllDeviceFault();
        return rows;
    }

    @RequestMapping("/deviceFault/add_judge")
    @ResponseBody
    public String addJudgeDeviceFault(){
        return null;
    }

    @RequestMapping("deviceFault/add")
    public String addDeviceFault(){
        return "deviceFault_add";
    }

    @RequestMapping("/deviceFault/insert")
    @ResponseBody
    public TypeCode insertDeviceFault(DeviceFault deviceFault){
        return deviceFaultService.insertDeviceFault(deviceFault);
    }

    @ResponseBody
    @RequestMapping("/deviceFault/delete_judge")
    public String deleteJudgeDeviceFault(){
        return null;
    }

    @ResponseBody
    @RequestMapping("/deviceFault/delete_batch")
    public TypeCode deleteBatchDeviceFault(String[] ids){
        return deviceFaultService.deleteDeviceFaultByIds(ids);
    }

    @ResponseBody
    @RequestMapping("/deviceFault/get_data")
    public List<DeviceFault> getdata(){
        return deviceFaultService.queryAllDeviceFault();
    }


    @ResponseBody
    @RequestMapping("/deviceFault/edit_judge")
    public String editJudgeDeviceFault(){
        return null;
    }

    @RequestMapping("/deviceFault/edit")
    public String editDeviceFault(){
        return "deviceFault_edit";
    }

    @ResponseBody
    @RequestMapping("/deviceFault/update")
    public TypeCode updateDeviceFault(DeviceFault deviceFault){
        return deviceFaultService.updateDeviceFaultById(deviceFault);
    }

}
