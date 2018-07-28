package io.github.mrdear.tinify;

import java.util.Map;

/**
 * 对外给第三方适配http的接口,实现不需要考虑权限等问题,只需要发送请求拿到返回值即可
 * @author Quding Ding
 * @since 2018/7/28
 */
public interface TinifyWebClient {

  /**
   * 发送post请求
   * @param url 请求地址
   * @param headers 请求头
   * @param body 请求体
   * @return 请求结果
   */
  String doPost(String url, Map<String, String> headers, byte[] body);
}
