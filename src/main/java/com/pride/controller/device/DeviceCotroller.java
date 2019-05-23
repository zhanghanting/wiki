package com.pride.controller.device;

import com.pride.domain.Device;
import com.pride.domain.DeviceCheck;
import com.pride.domain.DeviceType;
import com.pride.domain.order.OrderPageType;
import com.pride.domain.typecode.TypeCode;
import com.pride.domain.vo.DeviceVO;
import com.pride.service.device.DeviceService;
import com.pride.service.device.DeviceServiceImpl;
import com.pride.utils.MyPageHelper;
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
    public MyPageHelper<DeviceVO> list(Integer page, Integer rows) {
        return deviceService.viewAllDevice(page,rows);
    }

    @RequestMapping("/deviceList/add")
    public String deviceAdd(){
        return "deviceList_add";
    }

    @RequestMapping("/deviceList/add_judge")
    @ResponseBody
    public String deviceAddJudge(){
        return null;
    }

    @RequestMapping("/deviceList/insert")
    @ResponseBody
    public TypeCode insertDevice(Device device){
        return deviceService.insertDevice(device);
    }

    @ResponseBody
    @RequestMapping("/deviceList/delete_judge")
    public String deleteJudgeDevice(){
        return null;
    }

    @ResponseBody
    @RequestMapping("/deviceList/delete_batch")
    public TypeCode deleteBatchDevice(String[] ids){
        return deviceService.deleteDeviceByIds(ids);
    }

    @ResponseBody
    @RequestMapping("/deviceList/get_data")
    public List<DeviceVO> getdata(){
        return deviceService.queryAllDevice();
    }

    @ResponseBody
    @RequestMapping("/deviceList/edit_judge")
    public String editJudgeDevice(){
        return null;
    }

    @RequestMapping("/deviceList/edit")
    public String editDevice(){
        return "deviceList_edit";
    }

    @ResponseBody
    @RequestMapping("/deviceList/update")
    public TypeCode updateDevice(Device device){
        return deviceService.updateDeviceById(device);
    }




}
