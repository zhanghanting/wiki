package com.pride.controller.device;

import com.pride.domain.DeviceMaintain;
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

    @RequestMapping("deviceMaintain/list")
    @ResponseBody
    public List<DeviceMaintain> querryAllDeviceMaintain(){
        List<DeviceMaintain> rows = deviceMaintainService.queryAllDeviceMaintain();
        return rows;
    }

}
