package com.pride.service.device;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pride.domain.Device;
import com.pride.domain.DeviceCheck;
import com.pride.domain.order.OrderPageType;
import com.pride.domain.typecode.TypeCode;
import com.pride.domain.vo.DeviceVO;
import com.pride.mapper.DeviceMapper;
import com.pride.utils.MyPageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    DeviceMapper deviceMapper;

    @Override
    public List<DeviceVO> queryAllDevice() {
        List<DeviceVO> devices = deviceMapper.queryAllDevice();
        return devices;
    }

    @Override
    public TypeCode insertDevice(Device device) {
        TypeCode typeCode = new TypeCode("200","OK");
        try {
            deviceMapper.insert(device);
        }catch (Exception e){
            typeCode.setMsg("ERROR");
        }
        return typeCode;
    }

    @Override
    public TypeCode deleteDeviceByIds(String[] ids) {
        TypeCode typeCode = new TypeCode("200","OK");
        try {
            for (String id : ids) {
                deviceMapper.deleteByPrimaryKey(id);
            }
        }catch (Exception e){
            typeCode.setMsg("ERROR");
        }
        return typeCode;
    }

    @Override
    public TypeCode updateDeviceById(Device device) {
        TypeCode typeCode = new TypeCode("200","OK");
        try {
            deviceMapper.updateByPrimaryKey(device);
        }catch (Exception e){
            typeCode.setMsg("ERROR");
        }
        return typeCode;
    }

    @Override
    public MyPageHelper<DeviceVO> viewAllDevice(Integer page, Integer rows) {
        PageHelper.startPage(page,rows);
        List<DeviceVO> deviceVOS = deviceMapper.queryAllDevice();
        PageInfo<DeviceVO> pageInfo = new PageInfo<>(deviceVOS);
        MyPageHelper pageHelper = new MyPageHelper();
        pageHelper.setRows(deviceVOS);
        pageHelper.setTotal(pageInfo.getTotal());
        return pageHelper;
    }
}
