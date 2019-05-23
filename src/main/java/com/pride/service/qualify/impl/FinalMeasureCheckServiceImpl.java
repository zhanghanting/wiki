package com.pride.service.qualify.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pride.domain.FinalMeasuretCheck;
import com.pride.domain.vo.FinalMeasureCheckVO;
import com.pride.mapper.FinalMeasuretCheckMapper;
import com.pride.service.qualify.FinalMeasureCheckService;
import com.pride.utils.JsonUtil;
import com.pride.utils.MyPageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FinalMeasureCheckServiceImpl implements FinalMeasureCheckService
{
    @Autowired
    FinalMeasuretCheckMapper finalMeasuretCheckMapper;
    @Override
    public List<FinalMeasureCheckVO> queryFinalMeasureCheckVO()
    {
        List<FinalMeasureCheckVO> finalMeasureCheckVOS = finalMeasuretCheckMapper.find();
        return finalMeasureCheckVOS;
    }

    @Override
    public MyPageHelper getList(int page,int rows)
    {
        PageHelper.startPage(page,rows);
        List<FinalMeasureCheckVO> finalMeasureCheckVOS = finalMeasuretCheckMapper.find();
        PageInfo<FinalMeasureCheckVO> finalMeasureCheckVOPageInfo = new PageInfo<>(finalMeasureCheckVOS);
        MyPageHelper myPageHelper = new MyPageHelper();
        myPageHelper.setRows(finalMeasureCheckVOS);
        myPageHelper.setTotal(finalMeasureCheckVOPageInfo.getTotal());
        return myPageHelper;
    }

    @Override
    public FinalMeasuretCheck get(String id)
    {
        return finalMeasuretCheckMapper.selectByPrimaryKey(id);
    }

    @Override
    public JsonUtil insert(FinalMeasuretCheck finalMeasuretCheck)
    {
        int insert = finalMeasuretCheckMapper.insert(finalMeasuretCheck);
        if(insert > 0)
            return JsonUtil.ok();
        else
            return JsonUtil.build(101,"插入失败");
    }

    @Override
    public JsonUtil updateAll(FinalMeasuretCheck finalMeasuretCheck)
    {
        int update = finalMeasuretCheckMapper.updateByPrimaryKey(finalMeasuretCheck);
        if(update > 0)
            return JsonUtil.ok();
        else
            return JsonUtil.build(101,"更新失败");
    }
    //批量删除
    @Override
    public JsonUtil deleteBatch(String[] ids)
    {
        int i = finalMeasuretCheckMapper.deleteBatch(ids);
        if(i > 0)
        {
            return JsonUtil.ok();
        }
        else
            return JsonUtil.build(101,"删除失败");
    }

    @Override
    public MyPageHelper searchFMeasureCheckByfMeasureCheckId(int page,int rows,String searchValue)
    {
        PageHelper.startPage(page,rows);
        List<FinalMeasureCheckVO> finalMeasureCheckVOS = finalMeasuretCheckMapper.searchFMeasureCheckByfMeasureCheckId(searchValue);
        PageInfo<FinalMeasureCheckVO> finalMeasureCheckVOPageInfo = new PageInfo<>(finalMeasureCheckVOS);
        MyPageHelper myPageHelper = new MyPageHelper();
        myPageHelper.setRows(finalMeasureCheckVOS);
        myPageHelper.setTotal(finalMeasureCheckVOPageInfo.getTotal());
        return myPageHelper;
    }

    @Override
    public MyPageHelper searchFMeasureCheckByOrderId(int page,int rows,String searchValue)
    {
        PageHelper.startPage(page,rows);
        List<FinalMeasureCheckVO> finalMeasureCheckVOS = finalMeasuretCheckMapper.searchFMeasureCheckByOrderId(searchValue);
        PageInfo<FinalMeasureCheckVO> finalMeasureCheckVOPageInfo = new PageInfo<>(finalMeasureCheckVOS);
        MyPageHelper myPageHelper = new MyPageHelper();
        myPageHelper.setRows(finalMeasureCheckVOS);
        myPageHelper.setTotal(finalMeasureCheckVOPageInfo.getTotal());
        return myPageHelper;
    }

    @Override
    public JsonUtil updateNote(FinalMeasuretCheck finalMeasuretCheck)
    {
        int update = finalMeasuretCheckMapper.updateNote(finalMeasuretCheck);
        if(update > 0)
            return JsonUtil.ok();
        else
            return JsonUtil.build(101,"更新失败");
    }
}
