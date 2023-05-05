package com.zhixing.app.bean;

import java.io.Serializable;
import java.time.LocalTime;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author WGM
 * @since 2023-04-11
 */
@Getter
@Setter
  //(value = "Time对象", description = "")
public class Time implements Serializable {

    private static final long serialVersionUID = 1L;

      //Property("自习id号")
      private Integer id;

      //Property("用户id号")
      private Integer userid;

      //Property("自习开始时间")
      private LocalTime timestart;

      //Property("自习结束时间")
      private LocalTime timeover;

      //Property("自习地址")
      private String address;

      //Property("自习科目")
      private String subject;
}
