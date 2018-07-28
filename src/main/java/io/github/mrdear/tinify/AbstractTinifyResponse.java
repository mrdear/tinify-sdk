package io.github.mrdear.tinify;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.github.mrdear.tinify.response.CommonTinifyResponse;

/**
 * @author Quding Ding
 * @since 2018/7/25
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class AbstractTinifyResponse {

  private String originBody;

  private CommonTinifyResponse input;

  private CommonTinifyResponse output;


  public String getOriginBody() {
    return originBody;
  }

  public AbstractTinifyResponse setOriginBody(String originBody) {
    this.originBody = originBody;
    return this;
  }

  public CommonTinifyResponse getInput() {
    return input;
  }

  public AbstractTinifyResponse setInput(CommonTinifyResponse input) {
    this.input = input;
    return this;
  }

  public CommonTinifyResponse getOutput() {
    return output;
  }

  public AbstractTinifyResponse setOutput(CommonTinifyResponse output) {
    this.output = output;
    return this;
  }

  @Override
  public String toString() {
    return "AbstractTinifyResponse{" +
        "originBody='" + originBody + '\'' +
        ", input=" + input +
        ", output=" + output +
        '}';
  }
}
