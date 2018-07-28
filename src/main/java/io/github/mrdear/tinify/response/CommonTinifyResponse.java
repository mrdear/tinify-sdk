package io.github.mrdear.tinify.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Quding Ding
 * @since 2018/7/28
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CommonTinifyResponse {

  private Integer size;

  private String type;

  private Integer width;

  private Integer height;

  private Float ratio;

  private String url;

  public Integer getSize() {
    return size;
  }

  public CommonTinifyResponse setSize(Integer size) {
    this.size = size;
    return this;
  }

  public String getType() {
    return type;
  }

  public CommonTinifyResponse setType(String type) {
    this.type = type;
    return this;
  }

  public Integer getWidth() {
    return width;
  }

  public CommonTinifyResponse setWidth(Integer width) {
    this.width = width;
    return this;
  }

  public Integer getHeight() {
    return height;
  }

  public CommonTinifyResponse setHeight(Integer height) {
    this.height = height;
    return this;
  }

  public Float getRatio() {
    return ratio;
  }

  public CommonTinifyResponse setRatio(Float ratio) {
    this.ratio = ratio;
    return this;
  }

  public String getUrl() {
    return url;
  }

  public CommonTinifyResponse setUrl(String url) {
    this.url = url;
    return this;
  }

  @Override
  public String toString() {
    return "CommonTinifyResponse{" +
        "size=" + size +
        ", type='" + type + '\'' +
        ", width=" + width +
        ", height=" + height +
        ", ratio=" + ratio +
        ", url='" + url + '\'' +
        '}';
  }
}
