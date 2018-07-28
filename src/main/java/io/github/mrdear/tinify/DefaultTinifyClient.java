package io.github.mrdear.tinify;

import io.github.mrdear.tinify.constant.HttpMethod;
import io.github.mrdear.tinify.internal.bean.TinifyWebWrapper;
import io.github.mrdear.tinify.internal.util.TinifyJsonUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

/**
 * 执行器
 *
 * @author Quding Ding
 * @since 2018/7/25
 */
public class DefaultTinifyClient implements TinifyClient {

  private static Logger logger = LoggerFactory.getLogger(DefaultTinifyClient.class);

  /**
   * 请求域名
   */
  private final String apiDomain = "https://api.tinify.com/";
  /**
   * 用户的api key
   */
  private final String apiKey;
  /**
   * 第三方请求库
   */
  private TinifyWebWrapper tinifyWebWrapper;


  public DefaultTinifyClient(String apiKey, TinifyWebClient webClient) {
    this.apiKey = apiKey;
    this.tinifyWebWrapper = new TinifyWebWrapper(webClient, this.apiKey);
  }


  /**
   * 执行一个请求命令
   *
   * @param request 请求命令
   * @param <T>     返回具体参数
   * @return 返回值
   */
  @Override
  public <T extends AbstractTinifyResponse> T execute(TinifyRequest<T> request) {
    byte[] body = request.getRequestBody();

    String response = null;
    if (request.httpMethod() == HttpMethod.POST) {
      response = tinifyWebWrapper.doPost(this.apiDomain + request.relativeUrl(), body);
    }

    T instance = TinifyJsonUtil.readValue(Optional.ofNullable(response).orElse("{}"), request.responseClazz());
    if (null != instance) {
      instance.setOriginBody(response);
    }

    return instance;
  }


}
