package com.cora.gmall.product.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cora.gmall.model.product.BaseSaleAttr;
import com.cora.gmall.model.product.SpuInfo;

import java.util.List;

public interface SpuService {
    IPage<SpuInfo> index(Page pageParam, SpuInfo spuInfo);

    List<BaseSaleAttr> baseSaleAttrList();
    
}
