package com.zhixing.app.bean;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author WGM
 * @since 2023-04-13
 */
@Getter
@Setter
  //(value = "Help对象", description = "")
public class Help implements Serializable {

    private static final long serialVersionUID = 1L;

      //Property("求助id号")
        private Integer id;

      //Property("求助发起时间")
      private LocalDateTime starttime;

      //Property("求助时效（即求助发布多长时间后失效）")
      private Integer time;

      //Property("求助的内容")
      private String doing;

      //Property("完成求助的酬劳")
      private Integer pay;

      //Property("求助发布人")
      private Integer people;


}
