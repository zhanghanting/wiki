package com.pride.service.material;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pride.domain.Material;
import com.pride.domain.material.MaterialConsume;

import com.pride.domain.material.MaterialReceive;
import com.pride.mapper.MaterialConsumeMapper;

import com.pride.utils.JsonUtil;
import com.pride.utils.MyPageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;

@Service
public class MaterialConsumeServiceImpl implements MaterialConsumeService{

    @Autowired
    MaterialConsumeMapper materialConsumeMapper;
    @Override
    public List<MaterialConsume> queryMaterialConsumeList() {
        List<MaterialConsume> materialConsumes = materialConsumeMapper.queryMaterialConsumeList();
        return materialConsumes;
    }

    @Override
    public MyPageHelper queryMaterialConsumeList(Integer page, Integer rows){
        PageHelper.startPage(page, rows);
        List<MaterialConsume> materialConsumeList = materialConsumeMapper.queryMaterialConsumeList();
        PageInfo<Material> materialPageInfo = new PageInfo(materialConsumeList);
        MyPageHelper MyPageHelper = new MyPageHelper();
        MyPageHelper.setRows(materialConsumeList);
        MyPageHelper.setTotal(materialPageInfo.getTotal());
        return MyPageHelper;
    }

    @Override
    public MaterialConsume queryMaterialConsumeById(String id) {
        MaterialConsume materialConsume = materialConsumeMapper.selectByPrimaryKey(id);
        return materialConsume;
    }

    @Override
    public JsonUtil insertMaterialConsume(MaterialConsume materialConsume, BindingResult bindingResult) {
        JsonUtil result;
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return JsonUtil.build(100, fieldError.getDefaultMessage());
        }
        if(materialConsumeMapper.selectByPrimaryKey(materialConsume.getConsumeId())!= null){
            result = new JsonUtil(0, "该物料收入编号已经存在，请更换物料收入编号！", null);
        }else{
            int insert = materialConsumeMapper.insert(materialConsume);
            if(insert>0){
                return JsonUtil.ok();
            }else{
                return JsonUtil.build(101, "新增物料收入 信息失败");
            }
        }
        return result;
    }

    @Override
    public JsonUtil editMaterialConsume(MaterialConsume materialConsume, BindingResult bindingResult) {
        JsonUtil result;
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return JsonUtil.build(100, fieldError.getDefaultMessage());
        }
        if(materialConsumeMapper.selectByPrimaryKey(materialConsume.getConsumeId()) == null){
            result = new JsonUtil(0, "该物料收入 编号不存在，请更换物料收入编号！", null);
        }else{
            int insert = materialConsumeMapper.updateByPrimaryKeySelective(materialConsume);
            if(insert>0){
                return JsonUtil.ok();
            }else{
                return JsonUtil.build(101, "信息没出现更新");
            }
        }
        return result;
    }

    @Override
    public boolean deleteBatch(String[] ids) {
        for (String id:ids) {
            materialConsumeMapper.deleteByPrimaryKey(id);
        }
        return true;
    }
}
