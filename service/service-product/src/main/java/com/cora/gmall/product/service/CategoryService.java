package com.cora.gmall.product.service;

import com.cora.gmall.model.product.BaseCategory1;
import com.cora.gmall.model.product.BaseCategory2;
import com.cora.gmall.model.product.BaseCategory3;

import java.util.List;

public interface CategoryService {
    List<BaseCategory1> getCategory1();

    List<BaseCategory2> getCategory2(String category1Id);

    List<BaseCategory3> getCategory3(String category2Id);
}
