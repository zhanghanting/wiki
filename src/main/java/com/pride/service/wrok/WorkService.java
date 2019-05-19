package com.pride.service.wrok;

import com.pride.domain.Work;
import com.pride.domain.typecode.TypeCode;
import com.pride.domain.work.WorkPageType;
import com.pride.utils.MyPageHelper;

import java.util.List;

public interface WorkService {

    MyPageHelper<WorkPageType> viewPageWorks(Integer page, Integer rows);

    TypeCode insertWord(Work work);

    TypeCode deleteWorksByIds(String[] ids);

    TypeCode updateByModel(Work work);

    List<Work> viewAllWorks();

}
