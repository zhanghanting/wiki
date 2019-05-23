package com.pride.service.device;

import com.pride.domain.DeviceFault;
import com.pride.domain.typecode.TypeCode;

import java.util.List;

public interface DeviceFaultService {
    List<DeviceFault> queryAllDeviceFault();

    TypeCode insertDeviceFault(DeviceFault deviceFault);

    TypeCode deleteDeviceFaultByIds(String[] ids);

    TypeCode updateDeviceFaultById(DeviceFault deviceFault);
}
