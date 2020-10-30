package com.cora.gmall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cora.gmall.common.result.Result;
import com.cora.gmall.model.product.BaseAttrInfo;
import com.cora.gmall.model.product.BaseAttrValue;
import com.cora.gmall.product.mapper.BaseAttrInfoMapper;
import com.cora.gmall.product.mapper.BaseAttrValueMapper;
import com.cora.gmall.product.service.AttrInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.StyledEditorKit;
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

    @Override
    @Transactional
    public void saveAttrInfo(BaseAttrInfo baseAttrInfo) {
        Long attrId = baseAttrInfo.getId();

        if (null!=attrId && attrId > 0) {
            baseAttrInfoMapper.updateById(baseAttrInfo);
            QueryWrapper<BaseAttrValue> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("attr_id", attrId);
            baseAttrValueMapper.delete(queryWrapper);
        } else {
            baseAttrInfoMapper.insert(baseAttrInfo);
            attrId = baseAttrInfo.getId();
        }
        List<BaseAttrValue> attrValueList = baseAttrInfo.getAttrValueList();
        if (null!=attrValueList && attrValueList.size() > 0) {
            for (BaseAttrValue baseAttrValue : attrValueList) {
                baseAttrValue.setAttrId(attrId);
                baseAttrValueMapper.insert(baseAttrValue);
            }
        }
    }


}
