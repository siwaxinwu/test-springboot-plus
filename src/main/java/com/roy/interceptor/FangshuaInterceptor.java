package com.roy.interceptor;

import com.alibaba.fastjson.JSON;
import com.roy.annotation.AccessLimit;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

/**
 * @author dingyawu
 * @version 1.0
 * @date created in 23:19 2021-02-03
 */
@Component
public class FangshuaInterceptor extends HandlerInterceptorAdapter {

  /*@Autowired private RedisService redisService;*/

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {

    // 判断请求是否属于方法的请求
    if (handler instanceof HandlerMethod) {

      HandlerMethod hm = (HandlerMethod) handler;

      // 获取方法中的注解,看是否有该注解
      AccessLimit accessLimit = hm.getMethodAnnotation(AccessLimit.class);
      if (accessLimit == null) {
        return true;
      }
      int seconds = accessLimit.seconds();
      int maxCount = accessLimit.maxCount();
      boolean login = accessLimit.needLogin();
      String key = request.getRequestURI();
      // 如果需要登录
      if (login) {
        // 获取登录的session进行判断
        // .....
        key += "" + "1"; // 这里假设用户是1,项目中是动态获取的userId
      }

      // 从redis中获取用户访问的次数
      /*AccessKey ak = AccessKey.withExpire(seconds);
      Integer count = redisService.get(ak, key, Integer.class);
      if (count == null) {
        // 第一次访问
        redisService.set(ak, key, 1);
      } else if (count < maxCount) {
        // 加1
        redisService.incr(ak, key);
      } else {
        // 超出访问次数
        render(response, CodeMsg.ACCESS_LIMIT_REACHED); // 这里的CodeMsg是一个返回参数
        return false;
      }*/
    }

    return true;
  }

  /*private void render(HttpServletResponse response, CodeMsg cm) throws Exception {
    response.setContentType("application/json;charset=UTF-8");
    OutputStream out = response.getOutputStream();
    String str = JSON.toJSONString(Result.error(cm));
    out.write(str.getBytes(StandardCharsets.UTF_8));
    out.flush();
    out.close();
  }*/
}
