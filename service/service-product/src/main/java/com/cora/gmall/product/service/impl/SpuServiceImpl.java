package com.cora.gmall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cora.gmall.model.product.*;
import com.cora.gmall.product.mapper.SpuImageMapper;
import com.cora.gmall.product.mapper.SpuInfoMapper;
import com.cora.gmall.product.mapper.SpuSaleAttrMapper;
import com.cora.gmall.product.mapper.SpuSaleAttrValueMapper;
import com.cora.gmall.product.service.SpuService;
import feign.QueryMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpuServiceImpl implements SpuService {
    @Autowired
    SpuInfoMapper spuInfoMapper;
    @Autowired
    SpuImageMapper spuImageMapper;
    @Autowired
    SpuSaleAttrMapper spuSaleAttrMapper;
    @Autowired
    SpuSaleAttrValueMapper spuSaleAttrValueMapper;

    @Override
    public IPage<SpuInfo> index(Page pageParam, SpuInfo spuInfo) {
        QueryWrapper<SpuInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("category3_id", spuInfo.getCategory3Id());
        IPage<SpuInfo> infoIPage = spuInfoMapper.selectPage(pageParam, queryWrapper);
        return infoIPage;
    }
}
