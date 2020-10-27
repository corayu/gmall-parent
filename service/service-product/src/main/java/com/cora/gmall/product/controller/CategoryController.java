package com.cora.gmall.product.controller;

import com.cora.gmall.model.product.BaseCategory1;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Cora
 */

/*@RestController注解相当于@ResponseBody ＋ @Controller合在一起的作用
* 
* 
* 
* 
* */
@RestController
public class CategoryController {
    @RequestMapping
    public String getBaseCategory1() {
        return "hello";
    }
}
