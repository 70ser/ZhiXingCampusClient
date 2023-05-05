package com.zhixing.app.bean;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author ZC
 * @since 2023-04-10
 */
@Getter
@Setter
  //(value = "Shop对象", description = "")
public class Shop implements Serializable {

    private static final long serialVersionUID = 1L;

      //Property("商品id")
      private Integer id;

      //Property("商品名")
      private String shopName;

      //Property("商品价格")
      private Object shopPrice;

      //Property("商品描述")
      private String shopDescription;

      //Property("商品发布人")
      private String shopOwner;


}
