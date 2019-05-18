package com.pride.service.wrok;

import com.pride.domain.work.WorkPageType;
import com.pride.utils.MyPageHelper;

import java.util.List;

public interface WorkService {

    MyPageHelper<WorkPageType> viewPageWorks(Integer page, Integer rows);
}
