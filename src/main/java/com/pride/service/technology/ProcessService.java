package com.pride.service.technology;

import com.pride.domain.Process;
import com.pride.utils.JsonUtil;
import com.pride.utils.MyPageHelper;

import java.util.List;

/**
 * @Author: LifeTruth
 * @Date: 2019/5/19 17:57
 */

public interface ProcessService {

    MyPageHelper getList(Integer page, Integer rows, Process process);

    List<Process> find();

    Process get(String processId);

    JsonUtil insert(Process process);

    JsonUtil deleteBatch(String[] ids);

    MyPageHelper searchProcessByProcessId(Integer page, Integer rows, String searchValue);

    MyPageHelper searchProcessByTechnologyPlanId(Integer page, Integer rows, String searchValue);

    JsonUtil updateAll(Process process);
}
