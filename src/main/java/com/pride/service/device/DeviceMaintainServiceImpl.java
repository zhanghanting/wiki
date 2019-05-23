package com.pride.service.device;

import com.pride.domain.DeviceMaintain;
import com.pride.domain.DeviceType;
import com.pride.domain.typecode.TypeCode;
import com.pride.mapper.DeviceMaintainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Service
public class DeviceMaintainServiceImpl implements DeviceMaintainService {

    @Autowired
    DeviceMaintainMapper deviceMaintainMapper;

    @Override
    public List<DeviceMaintain> queryAllDeviceMaintain() {
        List<DeviceMaintain> deviceMaintainList = deviceMaintainMapper.queryAllDeviceMaintain();
        return deviceMaintainList;
    }

    @ResponseBody
    @Override
    public TypeCode insertDeviceMaintain(DeviceMaintain deviceMaintain) {
        TypeCode typeCode = new TypeCode("200","OK");
        try {
            deviceMaintainMapper.insert(deviceMaintain);
        }catch (Exception e){
            typeCode.setMsg("ERROR");
        }
        return typeCode;
    }

    @Override
    public TypeCode deleteDeviceMaintainByIds(String[] ids) {
        TypeCode typeCode = new TypeCode("200","OK");
        try {
            for (String id : ids) {
                deviceMaintainMapper.deleteByPrimaryKey(id);
            }
        }catch (Exception e){
            typeCode.setMsg("ERROR");
        }
        return typeCode;
    }

    @Override
    public TypeCode updateDeviceMaintainById(DeviceMaintain deviceMaintain) {
        TypeCode typeCode = new TypeCode("200","OK");
        try {
            deviceMaintainMapper.updateByPrimaryKey(deviceMaintain);
        }catch (Exception e){
            typeCode.setMsg("ERROR");
        }
        return typeCode;
    }
}
