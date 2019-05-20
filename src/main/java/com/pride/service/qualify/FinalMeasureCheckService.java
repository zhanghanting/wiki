package com.pride.service.qualify;

import com.pride.domain.FinalMeasuretCheck;
import com.pride.domain.vo.FinalMeasureCheckVO;
import com.pride.utils.JsonUtil;
import com.pride.utils.MyPageHelper;

import java.util.List;

public interface FinalMeasureCheckService
{
    List<FinalMeasureCheckVO> queryFinalMeasureCheckVO();

    MyPageHelper getList(int page,int rows);
    FinalMeasuretCheck get(String id);

    JsonUtil insert(FinalMeasuretCheck finalMeasuretCheck);

    JsonUtil updateAll(FinalMeasuretCheck finalMeasuretCheck);

    JsonUtil deleteBatch(String[] ids);

    MyPageHelper searchFMeasureCheckByfMeasureCheckId(int page,int rows,String searchValue);

    MyPageHelper searchFMeasureCheckByOrderId(int page,int rows,String searchValue);

    JsonUtil updateNote(FinalMeasuretCheck finalMeasuretCheck);
}
