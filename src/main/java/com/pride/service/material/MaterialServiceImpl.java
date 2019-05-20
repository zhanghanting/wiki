package com.pride.service.material;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pride.domain.Material;
import com.pride.mapper.MaterialMapper;
import com.pride.utils.JsonUtil;
import com.pride.utils.MyPageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import javax.validation.Valid;
import java.util.List;

@Service
public class MaterialServiceImpl implements MaterialService {

    @Autowired
    MaterialMapper materialMapper;
    @Override
    public boolean insertMaterial(Material material) {
        int insert = materialMapper.insert(material);
        return insert!=0;
    }
    @Override
    public List<Material> queryMaterialList() {
        List<Material> materials = materialMapper.queryMaterialList();
        return materials;
    }

    @Override
    public Material queryMaterialById(String id) {
        Material material = materialMapper.selectByPrimaryKey(id);
        return material;
    }
    //返回Material的PageList
    public MyPageHelper queryMaterialList(Integer page, Integer rows){
        PageHelper.startPage(page, rows);
        List<Material> materialList = materialMapper.queryMaterialList();
        PageInfo<Material> materialPageInfo = new PageInfo(materialList);
        MyPageHelper MyPageHelper = new MyPageHelper();
        MyPageHelper.setRows(materialList);
        MyPageHelper.setTotal(materialPageInfo.getTotal());
        return MyPageHelper;
    }

    //插入Material数据
    public JsonUtil insertMaterial(@Valid Material material, BindingResult bindingResult){
        JsonUtil result;
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return JsonUtil.build(100, fieldError.getDefaultMessage());
        }
        if(materialMapper.selectByPrimaryKey(material.getMaterialId())!= null){
            result = new JsonUtil(0, "该物料编号已经存在，请更换物料编号！", null);
        }else{
            int insert = materialMapper.insert(material);
            if(insert>0){
                return JsonUtil.ok();
            }else{
                return JsonUtil.build(101, "新增物料信息失败");
            }
        }
        return result;
    }

    @Override
    public JsonUtil editMaterial(@Valid Material material, BindingResult bindingResult) {
        JsonUtil result;
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return JsonUtil.build(100, fieldError.getDefaultMessage());
        }
        if(materialMapper.selectByPrimaryKey(material.getMaterialId()) == null){
            result = new JsonUtil(0, "该物料编号不存在，请更换物料编号！", null);
        }else{
            int insert = materialMapper.updateByPrimaryKeySelective(material);
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
            materialMapper.deleteByPrimaryKey(id);
        }
        return true;
    }


}
