package com.cora.gmall.product.controller;

import com.cora.gmall.common.result.Result;
import com.cora.gmall.model.product.BaseAttrInfo;
import com.cora.gmall.product.service.AttrInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Cora
 */
@RestController
@RequestMapping("admin/product")
@CrossOrigin
public class AttrInfoController {
    @Autowired
    AttrInfoService attrInfoService;


    @RequestMapping("attrInfoList/{category1Id}/{category2Id}/{category3Id}")
    public Result attrInfoList(@PathVariable("category1Id") String category1Id, @PathVariable("category2Id") String category2Id, @PathVariable("category3Id") String category3Id) {

        List<BaseAttrInfo> baseAttrInfos = attrInfoService.attrInfoList(category1Id, category2Id, category3Id);
        return Result.ok(baseAttrInfos);
    }

}
