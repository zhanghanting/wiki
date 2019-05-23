package com.pride.service.qualify.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pride.domain.ProcessMeasureCheck;
import com.pride.domain.vo.FinalMeasureCheckVO;
import com.pride.domain.vo.ProcessMeasureCheckVO;
import com.pride.mapper.ProcessMeasureCheckMapper;
import com.pride.service.qualify.ProcessMeasureCheckService;
import com.pride.utils.JsonUtil;
import com.pride.utils.MyPageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProcessMeasureCheckServiceImpl implements ProcessMeasureCheckService
{
    @Autowired
    ProcessMeasureCheckMapper processMeasureCheckMapper;
    @Override
    public List<ProcessMeasureCheckVO> queryProcessMeasureCheckVO()
    {
        List<ProcessMeasureCheckVO> processMeasureCheckVOS = processMeasureCheckMapper.find();
        return processMeasureCheckVOS;
    }

    @Override
    public MyPageHelper getList(int page,int rows)
    {
        PageHelper.startPage(page,rows);
        List<ProcessMeasureCheckVO> ProcessMeasureCheckVOS = processMeasureCheckMapper.find();
        PageInfo<ProcessMeasureCheckVO> processMeasureCheckVOPageInfo = new PageInfo<>(ProcessMeasureCheckVOS );
        MyPageHelper myPageHelper = new MyPageHelper();
        myPageHelper.setRows(ProcessMeasureCheckVOS );
        myPageHelper.setTotal(processMeasureCheckVOPageInfo.getTotal());
        return myPageHelper;
    }

    @Override
    public ProcessMeasureCheck get(String id)
    {
        return processMeasureCheckMapper.selectByPrimaryKey(id);
    }

    @Override
    public JsonUtil insert(ProcessMeasureCheck processMeasureCheck)
    {
        int insert = processMeasureCheckMapper.insert(processMeasureCheck);
        if(insert > 0)
            return JsonUtil.ok();
        else
            return JsonUtil.build(101,"插入失败");
    }

    @Override
    public JsonUtil updateAll(ProcessMeasureCheck processMeasureCheck)
    {
        int update = processMeasureCheckMapper.updateByPrimaryKey(processMeasureCheck);
        if(update > 0)
            return JsonUtil.ok();
        else
            return JsonUtil.build(101,"更新失败");
    }

    @Override
    public JsonUtil deleteBatch(String[] ids)
    {
        int i = processMeasureCheckMapper.deleteBatch(ids);
        if(i > 0)
        {
            return JsonUtil.ok();
        }
        else
            return JsonUtil.build(101,"删除失败");
    }

    @Override
    public MyPageHelper searchPMeasureCheckByPMeasureCheckId(int page,int rows,String searchValue)
    {
        PageHelper.startPage(page,rows);
        List<ProcessMeasureCheckVO> processMeasureCheckVOS = processMeasureCheckMapper.searchPMeasureCheckByPMeasureCheckId(searchValue);
        PageInfo<ProcessMeasureCheckVO> processMeasureCheckVOPageInfo = new PageInfo<>(processMeasureCheckVOS);
        MyPageHelper myPageHelper = new MyPageHelper();
        myPageHelper.setRows(processMeasureCheckVOS);
        myPageHelper.setTotal(processMeasureCheckVOPageInfo .getTotal());
        return myPageHelper;
    }

    @Override
    public JsonUtil updateNote(ProcessMeasureCheck processMeasureCheck)
    {
        int update = processMeasureCheckMapper.updateNote(processMeasureCheck);
        if(update > 0)
            return JsonUtil.ok();
        else
            return JsonUtil.build(101,"更新失败");
    }
}
