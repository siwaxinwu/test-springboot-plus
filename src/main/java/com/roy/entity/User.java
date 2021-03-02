package com.roy.entity;

import lombok.*;

import java.util.Date;

/** description： author：dingyawu date：created in 23:34 2020/11/21 history: */
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

  private String id;

  private String name;

  private Integer age;

  // @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date birthday;
}
