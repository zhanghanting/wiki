package com.pride.service.qualify;

import com.pride.domain.FinalCountCheck;
import com.pride.domain.FinalMeasuretCheck;
import com.pride.domain.vo.FinalCountCheckVO;
import com.pride.utils.JsonUtil;
import com.pride.utils.MyPageHelper;

import java.util.List;

public interface FinalCountCheckService
{
    List<FinalCountCheckVO> queryFinalCountCheckVO();
    MyPageHelper getList(int page,int rows);
    FinalCountCheck get(String id);

    JsonUtil insert(FinalCountCheck finalCountCheck);

    JsonUtil updateAll(FinalCountCheck finalCountCheck);

    JsonUtil deleteBatch(String[] ids);

    MyPageHelper searchFCountCheckByFCountCheckId(int page,int rows,String searchValue);

    MyPageHelper searchFCountCheckByOrderId(int page,int rows,String searchValue);

    JsonUtil updateNote(FinalCountCheck finalCountCheck);
}
