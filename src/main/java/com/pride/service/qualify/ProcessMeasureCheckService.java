package com.pride.service.qualify;


import com.pride.domain.ProcessMeasureCheck;
import com.pride.domain.vo.ProcessMeasureCheckVO;
import com.pride.utils.JsonUtil;
import com.pride.utils.MyPageHelper;

import java.util.List;

public interface ProcessMeasureCheckService
{
    List<ProcessMeasureCheckVO> queryProcessMeasureCheckVO();

    MyPageHelper getList(int page,int rows);

    ProcessMeasureCheck get(String id);

    JsonUtil insert(ProcessMeasureCheck processMeasureCheck);

    JsonUtil updateAll(ProcessMeasureCheck processMeasureCheck);

    JsonUtil deleteBatch(String[] ids);

    MyPageHelper searchPMeasureCheckByPMeasureCheckId(int page,int rows,String searchValue);

    JsonUtil updateNote(ProcessMeasureCheck  processMeasureCheck );
}
