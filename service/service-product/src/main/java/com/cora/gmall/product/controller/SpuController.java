package com.cora.gmall.product.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cora.gmall.common.result.Result;
import com.cora.gmall.model.product.BaseSaleAttr;
import com.cora.gmall.model.product.SpuInfo;
import com.cora.gmall.product.service.SpuService;
import com.sun.org.apache.regexp.internal.RE;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.QueryAnnotation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("admin/product")
@CrossOrigin

public class SpuController {
    @Autowired
    SpuService spuService;
    
    
    @GetMapping("{page}/{size}")
    public Result<IPage<SpuInfo>> index(@ApiParam(name = "page", value = "当前页码", required = true) @PathVariable Long page,
                                        @ApiParam(name = "size", value = "每页记录数", required = true) @PathVariable Long size,
                                        @ApiParam(name = "spuInfo", value = "查询对象", required = false) SpuInfo spuInfo) {

        Page pageParam = new Page(page ,size);

        IPage<SpuInfo> infoIPage = spuService.index(pageParam,spuInfo);

        return Result.ok(infoIPage);
    }

    @RequestMapping("baseSaleAttrList")
    public Result baseSaleAttrList() {
        List<BaseSaleAttr> baseSaleAttrs = spuService.baseSaleAttrList();
        return Result.ok(baseSaleAttrs);
         
    }
}
