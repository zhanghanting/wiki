package com.pride.controller.device;

import com.pride.domain.DeviceCheck;
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
}
