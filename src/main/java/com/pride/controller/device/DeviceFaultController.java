package com.pride.controller.device;

import com.pride.domain.DeviceFault;
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
    DeviceFaultService deviceFaultSerice;

    @RequestMapping("/device/deviceFault")
    public String deviceFault(){
        return "deviceFault";
    }

    @RequestMapping("/deviceFault/list")
    @ResponseBody
    public List<DeviceFault> queryAllDeviceFault(){
        List<DeviceFault> rows = deviceFaultSerice.queryAllDeviceFault();
        return rows;
    }


}
