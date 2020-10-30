package com.cora.gmall.product.controller;

import com.cora.gmall.common.result.Result;
import com.cora.gmall.model.product.BaseAttrInfo;
import com.cora.gmall.product.service.AttrInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

/**
 * @author Cora
 */
@RestController
@RequestMapping("admin/product")
@CrossOrigin
@EnableSwagger2
public class AttrInfoController {
    @Autowired
    AttrInfoService attrInfoService;


    @RequestMapping("attrInfoList/{category1Id}/{category2Id}/{category3Id}")
    public Result attrInfoList(@PathVariable("category1Id") String category1Id, @PathVariable("category2Id") String category2Id, @PathVariable("category3Id") String category3Id) {

        List<BaseAttrInfo> baseAttrInfos = attrInfoService.attrInfoList(category1Id, category2Id, category3Id);
        return Result.ok(baseAttrInfos);
    }

    @RequestMapping("saveAttrInfo")
    public Result saveAttrInfo(@RequestBody BaseAttrInfo baseAttrInfo) {
        attrInfoService.saveAttrInfo(baseAttrInfo);
        return Result.ok();
    }
}
