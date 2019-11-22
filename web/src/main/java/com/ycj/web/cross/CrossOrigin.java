package com.ycj.web.cross;

import org.springframework.core.annotation.AliasFor;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.annotation.*;

/**
 * @author: Frank
 * @email 1320259466@qq.com
 * @date: 2019/11/22
 * @time: 12:47
 * @fuction: about the role of class.
 */

@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CrossOrigin {

    String[] DEFAULT_ORIGINS = { "*" };

    String[] DEFAULT_ALLOWED_HEADERS = { "*" };

    boolean DEFAULT_ALLOW_CREDENTIALS = true;

    long DEFAULT_MAX_AGE = 1800;

    /**

     * 同origins属性一样

     */

    @AliasFor("origins")

    String[] value() default {};

    /**

     * 所有支持域的集合。

     * "*"代表所有域的请求都支持

     * 默认所有请求的域都支持

     */

    @AliasFor("value")

    String[] origins() default {};

    /**

     * 允许请求头中跨域的header，默认不设置的话都支持

     */

    String[] allowedHeaders() default {};

    /**

     * 允许响应头跨域的header，默认为空

     */

    String[] exposedHeaders() default {};

    /**

     * 跨域请求支持的方法，例如"{RequestMethod.GET, RequestMethod.POST}"}。

     * 默认支持RequestMapping中设置的方法

     */

    RequestMethod[] methods() default {};

    /**

     * 是否允许cookie随请求发送，使用时必须指定具体的域

     */

    String allowCredentials() default "";

    /**

     * 预请求的结果的有效期，默认是30分钟

     */

    long maxAge() default -1;

}
