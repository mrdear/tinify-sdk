package io.github.mrdear.tinify;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import okhttp3.CipherSuite;
import okhttp3.ConnectionSpec;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.TlsVersion;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 用于测试的Http实现
 * @author Quding Ding
 * @since 2018/7/26
 */
public class OkHttpWebUtils implements TinifyWebClient  {

  private static Logger logger = LoggerFactory.getLogger(OkHttpWebUtils.class);

  private final OkHttpClient client;

  public OkHttpWebUtils() {

    ConnectionSpec spec = new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS)
        .tlsVersions(TlsVersion.TLS_1_2)
        .cipherSuites(
            CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256,
            CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256,
            CipherSuite.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256)
        .build();

    client = new OkHttpClient.Builder()
        .connectionSpecs(Collections.singletonList(spec))
        .connectTimeout(5L, TimeUnit.SECONDS)
        .build();
  }

  @Override
  public String doPost(String url, Map<String, String> headers, byte[] body) {
    if (null == body) {
      body = new byte[0];
    }
    Request.Builder requestBuilder = new Request.Builder();
    headers.forEach(requestBuilder::header);
    requestBuilder.url(url)
        .post(RequestBody.create(null, body));
    Response response;
    try {
      response = client.newCall(requestBuilder.build()).execute();
    } catch (IOException e) {
      logger.error("doPost fail, url is {}", url, e);
      return null;
    }
    try {
      return response.body().string();
    } catch (IOException e) {
      logger.error("doPost fail, url is {}", url, e);
      return null;
    }
  }


}
