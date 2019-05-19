package com.pride.controller.device;

import com.pride.domain.Device;
import com.pride.domain.DeviceType;
import com.pride.domain.typecode.TypeCode;
import com.pride.service.device.DeviceService;
import com.pride.service.device.DeviceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/erp")
public class DeviceCotroller {

    @Autowired
    DeviceService deviceService = new DeviceServiceImpl();

    @RequestMapping("/device/deviceList")
    public String deviceList(){
        return "deviceList";
    }

    @ResponseBody
    @RequestMapping("/deviceList/list")
    public List<Device> queryAllDevice(){
        List<Device> rows = deviceService.queryAllDevice();
        return rows;
    }

    @RequestMapping("/deviceList/add")
    public String deviceListAdd(){
        return "deviceList_add";
    }

    @RequestMapping("/deviceList/add_judge")
    @ResponseBody
    public String deviceListAddJudge(){
        return null;
    }



}
