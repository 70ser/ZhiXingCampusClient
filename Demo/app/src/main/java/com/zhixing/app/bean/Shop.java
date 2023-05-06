package com.zhixing.app.bean;

import android.content.Intent;

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
      private Double shopPrice;

      //Property("商品描述")
      private String shopDescription;

      //Property("商品发布人")
      private Integer shopOwner;


      public Shop(String shopName, String shopDescription) {
    	  this.shopName = shopName;
    	  this.shopDescription = shopDescription;

      }
      public Shop(String shopName, String shopDescription, Double shopPrice,Integer shopOwner) {
    	  this.shopName = shopName;
    	  this.shopDescription = shopDescription;
    	  this.shopPrice = shopPrice;
          this.shopOwner = shopOwner;
      }

    public String getShopName() {
        return shopName;
    }

    public String getShopDescription() {
        return shopDescription;
    }

}
