package com.cora.gmall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cora.gmall.common.result.Result;
import com.cora.gmall.model.product.BaseAttrInfo;
import com.cora.gmall.product.mapper.BaseAttrInfoMapper;
import com.cora.gmall.product.mapper.BaseAttrValueMapper;
import com.cora.gmall.product.service.AttrInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AttrInfoServiceImpl implements AttrInfoService {

    @Autowired
    BaseAttrInfoMapper baseAttrInfoMapper;

    @Autowired
    BaseAttrValueMapper baseAttrValueMapper;

    @Override
    public List<BaseAttrInfo> attrInfoList(String category1Id, String category2Id, String category3Id) {

        QueryWrapper<BaseAttrInfo> baseAttrInfoQueryWrapper = new QueryWrapper<>();
        baseAttrInfoQueryWrapper.eq("category_level", 3);
        baseAttrInfoQueryWrapper.eq("category_id", category3Id);
        List<BaseAttrInfo> baseAttrInfos = baseAttrInfoMapper.selectList(baseAttrInfoQueryWrapper);
        return baseAttrInfos;
    }
}
