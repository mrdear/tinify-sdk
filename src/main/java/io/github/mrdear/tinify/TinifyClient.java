package io.github.mrdear.tinify;

/**
 * 执行器定义
 * @author Quding Ding
 * @since 2018/7/28
 */
public interface TinifyClient {

  /**
   * 执行一个请求
   * @param request 请求参数
   * @param <T> 返回类型
   * @return 返回值,可能为null
   */
  <T extends AbstractTinifyResponse> T execute(TinifyRequest<T> request);

}
