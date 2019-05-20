package com.pride.controller.material;


import com.pride.domain.Material;
import com.pride.domain.material.MaterialConsume;
import com.pride.domain.material.MaterialReceive;
import com.pride.service.material.MaterialConsumeService;
import com.pride.service.material.MaterialReceiveService;
import com.pride.service.material.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/erp")
public class MaterialController {

    @Autowired
    MaterialService materialService;

    @Autowired
    MaterialReceiveService materialReceiveService;

    @Autowired
    MaterialConsumeService materialConsumeService;

    //转到物料清单信息表并显示
    @RequestMapping("/material/find")
    public String showMaterHome(){
        return "material_list";
    }
    @RequestMapping("/material/list")
    @ResponseBody
    public List<Material> queryMaterialList(){
        List<Material> materialList = materialService.queryMaterialList();
        return materialList;
    }

    //插入物料信息
    @RequestMapping("/material/insert")
    public String insetMaterial(HttpServletRequest request) {
        Material material = multiplyCode(request);
        boolean b = materialService.insertMaterial(material);
        return "material_list";
    }


    //转到物料收入信息表并显示
    @RequestMapping("/materialReceive/find")
    public String materialReceive(){
        return "materialReceive_list";
    }
    @RequestMapping("/materialReceive/list")
    @ResponseBody
    public List<MaterialReceive> queryMaterialReceiveList(){
        List<MaterialReceive> materialReceives = materialReceiveService.queryMaterialReceiveList();
        return materialReceives;
    }
/*"rows": [{
		"receiveId": "7777",
		"material": {
			"materialId": "ser43",
			"workId": null,
			"materialType": null,
			"status": null,
			"remaining": null,
			"note": "???"
		},
		"amount": null,
		"receiveDate": 1558152000000,
		"sender": "44453",
		"receiver": "653",
		"note": "???"
	},*/


    //打开物料消耗信息表
    @RequestMapping("/materialConsume/find")
    public String materialConsume(){
        return "materialConsume_list";
    }
    @RequestMapping("/materialConsume/list")
    @ResponseBody
    public List<MaterialConsume> queryMaterialConsumeList(){
        List<MaterialConsume> materialConsumes = materialConsumeService.queryMaterialConsumeList();
        return materialConsumes;
    }




    //获得物料信息
    public Material multiplyCode(HttpServletRequest request){
        Material material = new Material();
        //获得物料ID
        String materialId = request.getParameter("materialId");
        material.setMaterialId(materialId);
        //获得物料类型
        String materialType = request.getParameter("materialType");
        material.setMaterialType(materialType);
        //获得物料状态
        String status = request.getParameter("status");
        material.setStatus(status);
        //获得物料剩余
        String remaining = request.getParameter("remaining");
        material.setRemaining(Integer.parseInt(remaining));
        //获得物料信息
        String note = request.getParameter("note");
        material.setNote(note);
        return material;
    }
}
 /*public MyPageHelper<Material> query(Integer page, Integer rows){
        PageHelper.startPage(page, rows);
        List<Material> materialList = materialService.queryMaterialList();
        PageInfo<Material> materialPageInfo = new PageInfo(materialList);
        MyPageHelper MyPageHelper = new MyPageHelper();
        MyPageHelper.setRows(materialList);
        MyPageHelper.setTotal(materialPageInfo.getTotal());
        return MyPageHelper;
    }*/