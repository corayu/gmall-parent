package com.cora.gmall.product.service;

import com.cora.gmall.model.product.BaseAttrInfo;

import java.util.List;

public interface AttrInfoService {
    List<BaseAttrInfo> attrInfoList(String category1Id, String category2Id, String category3Id);
}
