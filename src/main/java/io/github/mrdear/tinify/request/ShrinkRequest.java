package io.github.mrdear.tinify.request;

import io.github.mrdear.tinify.TinifyRequest;
import io.github.mrdear.tinify.constant.HttpMethod;
import io.github.mrdear.tinify.internal.util.TinifyFileUtils;
import io.github.mrdear.tinify.internal.util.TinifyJsonUtil;
import io.github.mrdear.tinify.response.ShrinkResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * 图片压缩请求
 * @author Quding Ding
 * @since 2018/7/25
 */
public class ShrinkRequest implements TinifyRequest<ShrinkResponse> {

  private static Logger logger = LoggerFactory.getLogger(ShrinkRequest.class);

  /**
   * 上传压缩的文件,与下方url二选一
   */
  private InputStream fileData;

  /**
   * 需要压缩的图片地址,与上方本地文件二选一
   */
  private String sourceUrl;


  public ShrinkRequest setFileData(InputStream fileData) {
    this.fileData = fileData;
    this.sourceUrl = null;
    return this;
  }

  public ShrinkRequest setSourceUrl(String sourceUrl) {
    this.sourceUrl = sourceUrl;
    this.fileData = null;
    return this;
  }

  @Override
  public String relativeUrl() {
    return "shrink";
  }

  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.POST;
  }

  @Override
  public Class<ShrinkResponse> responseClazz() {
    return ShrinkResponse.class;
  }

  @Override
  public byte[] getRequestBody() {
    if (null != this.fileData) {
      return TinifyFileUtils.readAllBytes(fileData);
    }
    if (null != sourceUrl) {
      Map<String, String> url = new HashMap<>(1);
      url.put("url", this.sourceUrl);
      Map<String, Object> body = new HashMap<>(1);
      body.put("source", url);
      return TinifyJsonUtil.writeBytes(body);
    }
    throw new IllegalArgumentException("params not found");
  }
}
