package com.pride.service.device;

import com.pride.domain.DeviceType;
import com.pride.domain.typecode.TypeCode;
import com.pride.mapper.DeviceTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Service
public class DeviceTypeServiceImpl implements DeviceTypeService {

    @Autowired
    DeviceTypeMapper deviceTypeMapper;

    @Override
    public List<DeviceType> queryAllDeviceType() {
        List<DeviceType> deviceTypes = deviceTypeMapper.queryAllDeviceType();
        return deviceTypes;
    }

    @ResponseBody
    @Override
    public TypeCode insertDeviceType(DeviceType deviceType) {
            TypeCode typeCode = new TypeCode("200","OK");
            try {
                deviceTypeMapper.insert(deviceType);
            }catch (Exception e){
                typeCode.setMsg("ERROR");
            }
            return typeCode;
    }

    @Override
    public TypeCode deleteDeviceTypeByIds(String[] ids) {
        TypeCode typeCode = new TypeCode("200","OK");
        try {
            for (String id : ids) {
                deviceTypeMapper.deleteByPrimaryKey(id);
            }
        }catch (Exception e){
            typeCode.setMsg("ERROR");
        }
        return typeCode;
    }

    @Override
    public TypeCode updateDeviceTypeById(DeviceType deviceType) {
        TypeCode typeCode = new TypeCode("200","OK");
        try {
            deviceTypeMapper.updateByPrimaryKey(deviceType);
        }catch (Exception e){
            typeCode.setMsg("ERROR");
        }
        return typeCode;
    }

    @Override
    public DeviceType getDeviceTypeByPrimaryKey(String deviceTypeId) {
        DeviceType deviceType = deviceTypeMapper.selectByPrimaryKey(deviceTypeId);
        return deviceType;
    }


}
