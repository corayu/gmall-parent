package com.cora.gmall.product;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Cora
 */
@SpringBootApplication
@MapperScan("com.cora.gmall.product.mapper")
@Component("com.cora.gmall")
@EnableSwagger2
public class ProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);

        System.out.println("==================seperator======================");


    }

}
