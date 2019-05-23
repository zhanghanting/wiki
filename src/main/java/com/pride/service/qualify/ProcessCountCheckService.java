package com.pride.service.qualify;

import com.pride.domain.ProcessCountCheck;
import com.pride.domain.vo.ProcessCountCheckVO;
import com.pride.utils.JsonUtil;
import com.pride.utils.MyPageHelper;

import java.util.List;

public interface ProcessCountCheckService
{
    List<ProcessCountCheckVO> queryProcessCountCheckVO();
    MyPageHelper getList(int page,int rows);

    ProcessCountCheck get(String id);

    JsonUtil insert(ProcessCountCheck processCountCheck);

    JsonUtil updateAll(ProcessCountCheck processMeasureCheck);

    JsonUtil deleteBatch(String[] ids);

    MyPageHelper searchpCountCheckBypCountCheckId(int page,int rows,String searchValue);

    JsonUtil updateNote(ProcessCountCheck  processMeasureCheck );
}
