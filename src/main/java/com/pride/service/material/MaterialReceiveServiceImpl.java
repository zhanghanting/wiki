package com.pride.service.material;




import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pride.domain.Material;
import com.pride.mapper.MaterialReceiveMapper;
import com.pride.utils.JsonUtil;
import com.pride.utils.MyPageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pride.domain.material.MaterialReceive;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import javax.validation.Valid;
import java.util.List;

@Service
public class MaterialReceiveServiceImpl implements MaterialReceiveService{

    @Autowired
    MaterialReceiveMapper materialReceiveMapper;
    @Override
    public List<MaterialReceive> queryMaterialReceiveList() {
        List<MaterialReceive> materialReceive = materialReceiveMapper.queryMaterialReceiveList();
        return materialReceive;
    }

    public MyPageHelper queryMaterialReceiveList(Integer page, Integer rows){
        PageHelper.startPage(page, rows);
        List<MaterialReceive> materialReceiveList = materialReceiveMapper.queryMaterialReceiveList();
        PageInfo<Material> materialPageInfo = new PageInfo(materialReceiveList);
        MyPageHelper MyPageHelper = new MyPageHelper();
        MyPageHelper.setRows(materialReceiveList);
        MyPageHelper.setTotal(materialPageInfo.getTotal());
        return MyPageHelper;
    }

    @Override
    public MaterialReceive queryMaterialReceiveById(String id) {
        MaterialReceive materialReceive = materialReceiveMapper.selectByPrimaryKey(id);
        return materialReceive;
    }


    //插入Material数据
    @Override
    public JsonUtil insertMaterialReceive(@Valid MaterialReceive materialReceive, BindingResult bindingResult){
        JsonUtil result;
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return JsonUtil.build(100, fieldError.getDefaultMessage());
        }
        if(materialReceiveMapper.selectByPrimaryKey(materialReceive.getReceiveId())!= null){
            result = new JsonUtil(0, "该物料收入编号已经存在，请更换物料收入编号！", null);
        }else{
            int insert = materialReceiveMapper.insert(materialReceive);
            if(insert>0){
                return JsonUtil.ok();
            }else{
                return JsonUtil.build(101, "新增物料收入 信息失败");
            }
        }
        return result;
    }

    @Override
    public JsonUtil editMaterialReceive(@Valid MaterialReceive materialReceive, BindingResult bindingResult) {
        JsonUtil result;
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return JsonUtil.build(100, fieldError.getDefaultMessage());
        }
        if(materialReceiveMapper.selectByPrimaryKey(materialReceive.getReceiveId()) == null){
            result = new JsonUtil(0, "该物料收入 编号不存在，请更换物料收入编号！", null);
        }else{
            int insert = materialReceiveMapper.updateByPrimaryKeySelective(materialReceive);
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
            materialReceiveMapper.deleteByPrimaryKey(id);
        }
        return true;
    }
}
