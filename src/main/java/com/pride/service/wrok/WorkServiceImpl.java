package com.pride.service.wrok;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pride.domain.Work;
import com.pride.domain.WorkExample;
import com.pride.domain.typecode.TypeCode;
import com.pride.domain.work.WorkPageType;
import com.pride.mapper.WorkMapper;
import com.pride.utils.MyPageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Service
public class WorkServiceImpl implements WorkService{
    @Autowired
    WorkMapper workMapper;

    @ResponseBody
    @Override
    public MyPageHelper<WorkPageType> viewPageWorks(Integer page,Integer rows) {
        PageHelper.startPage(page,rows);
        List<WorkPageType> workPageTypes = workMapper.viewAllWorks();
        PageInfo<WorkPageType> pageInfo = new PageInfo<>(workPageTypes);
        MyPageHelper<WorkPageType> pageHelper = new MyPageHelper<>();
        pageHelper.setTotal(pageInfo.getTotal());
        pageHelper.setRows(workPageTypes);
        return pageHelper;
    }

    @Override
    public TypeCode insertWord(Work work) {
        TypeCode typeCode = new TypeCode("200","OK");
        try {
            workMapper.insert(work);
        }catch (Exception e){
            typeCode.setMsg("ERROR");
            typeCode.setStatus("500");
        }
        return typeCode;
    }

    @Override
    public TypeCode deleteWorksByIds(String[] ids) {
        TypeCode typeCode = new TypeCode("200","OK");
        try {
            for (String id : ids) {
                workMapper.deleteByPrimaryKey(id);
            }
        }catch (Exception e){
            typeCode.setMsg("ERROR");
            typeCode.setStatus("500");
        }
        return typeCode;
    }

    @Override
    public TypeCode updateByModel(Work work) {
        TypeCode typeCode = new TypeCode("200","OK");
        try {
            workMapper.updateByPrimaryKey(work);
        }catch (Exception e){
            typeCode.setMsg("ERROR");
            typeCode.setStatus("500");
        }
        return typeCode;
    }

    @Override
    public List<Work> viewAllWorks() {
        return workMapper.selectByExample(new WorkExample());
    }
}
