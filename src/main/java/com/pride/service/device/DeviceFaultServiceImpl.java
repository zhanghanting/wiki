package com.pride.service.device;

import com.pride.domain.DeviceCheck;
import com.pride.domain.DeviceFault;
import com.pride.domain.typecode.TypeCode;
import com.pride.mapper.DeviceFaultMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceFaultServiceImpl implements DeviceFaultService {

    @Autowired
    DeviceFaultMapper deviceFaultMapper;


    @Override
    public List<DeviceFault> queryAllDeviceFault() {
        List<DeviceFault> deviceFaults = deviceFaultMapper.queryAllDeviceFault();
        return deviceFaults;
    }

    @Override
    public TypeCode insertDeviceFault(DeviceFault deviceFault) {
        TypeCode typeCode = new TypeCode("200","OK");
        try {
            deviceFaultMapper.insert(deviceFault);
        }catch (Exception e){
            typeCode.setMsg("ERROR");
        }
        return typeCode;
    }

    @Override
    public TypeCode deleteDeviceFaultByIds(String[] ids) {
        TypeCode typeCode = new TypeCode("200","OK");
        try {
            for (String id : ids) {
                deviceFaultMapper.deleteByPrimaryKey(id);
            }
        }catch (Exception e){
            typeCode.setMsg("ERROR");
        }
        return typeCode;
    }

    @Override
    public TypeCode updateDeviceFaultById(DeviceFault deviceFault) {
        TypeCode typeCode = new TypeCode("200","OK");
        try {
            deviceFaultMapper.updateByPrimaryKey(deviceFault);
        }catch (Exception e){
            typeCode.setMsg("ERROR");
        }
        return typeCode;
    }

}
