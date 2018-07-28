package io.github.mrdear.tinify;

import io.github.mrdear.tinify.constant.HttpMethod;

/**
 * @author Quding Ding
 * @since 2018/7/25
 */
public interface TinifyRequest<T extends AbstractTinifyResponse> {

  /**
   * 返回请求地址
   * @return 请求地址
   */
  String relativeUrl();

  /**
   * 返回http方式
   * @return http方式
   */
  HttpMethod httpMethod();

  /**
   * 返回类型
   * @return 返回类型
   */
  Class<T> responseClazz();

  /**
   * 得到请求体
   * @return 请求体
   */
  byte[] getRequestBody();
}
