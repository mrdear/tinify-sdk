package io.github.mrdear.tinify.internal.bean;

import io.github.mrdear.tinify.TinifyWebClient;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Quding Ding
 * @since 2018/7/28
 */
public class TinifyWebWrapper {

  private final TinifyWebClient tinifyWebClient;

  private final String httpAuthorization;

  public TinifyWebWrapper(TinifyWebClient tinifyWebClient, String apiKey) {
    this.tinifyWebClient = tinifyWebClient;
    httpAuthorization = "Basic " + Base64.getEncoder().encodeToString(String.format("api:%s", apiKey).getBytes());
  }

  /**
   * 发送post请求
   * @param url 请求地址
   * @param body 请求体
   * @return body
   */
  public String doPost(String url, byte[] body) {
    Map<String, String> headers = new HashMap<>(2);
    headers.put("Authorization", httpAuthorization);
    if (null != body && body.length > 0 && body[0] == '{') {
      headers.put("Content-Type", "application/json; charset=utf-8");
    }
    return tinifyWebClient.doPost(url, headers, body);
  }

}
