package com.pride.service.device;

import com.pride.domain.DeviceCheck;
import com.pride.domain.typecode.TypeCode;
import com.pride.mapper.DeviceCheckMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceCheckServiceImpl implements DeviceCheckService {

    @Autowired
    DeviceCheckMapper deviceCheckMapper;

    @Override
    public List<DeviceCheck> queryAllDeviceCheck() {
        List<DeviceCheck> deviceChecks = deviceCheckMapper.queryAllDeviceCheck();

        return deviceChecks;
    }

    @Override
    public TypeCode insertDeviceCheck(DeviceCheck deviceCheck) {
        TypeCode typeCode = new TypeCode("200","OK");
        try {
            deviceCheckMapper.insert(deviceCheck);
        }catch (Exception e){
            typeCode.setMsg("ERROR");
        }
        return typeCode;
    }

    @Override
    public TypeCode deleteDeviceCheckByIds(String[] ids) {
        TypeCode typeCode = new TypeCode("200","OK");
        try {
            for (String id : ids) {
                deviceCheckMapper.deleteByPrimaryKey(id);
            }
        }catch (Exception e){
            typeCode.setMsg("ERROR");
        }
        return typeCode;
    }

    @Override
    public TypeCode updateDeviceCheckById(DeviceCheck deviceCheck) {
        TypeCode typeCode = new TypeCode("200","OK");
        try {
            deviceCheckMapper.updateByPrimaryKey(deviceCheck);
        }catch (Exception e){
            typeCode.setMsg("ERROR");
        }
        return typeCode;
    }


}
