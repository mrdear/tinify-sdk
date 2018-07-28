package io.github.mrdear.tinify.request;

import io.github.mrdear.tinify.DefaultTinifyClient;
import io.github.mrdear.tinify.OkHttpWebUtils;
import io.github.mrdear.tinify.TinifyClient;
import io.github.mrdear.tinify.response.ShrinkResponse;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class ShrinkRequestTest {

  private TinifyClient client = new DefaultTinifyClient("JKwWUnDJK2TsriXiBXzoKzziSnKHk3lh", new OkHttpWebUtils());

  @Test
  public void testShrink() {
    ShrinkRequest request = new ShrinkRequest();
    request.setSourceUrl("http://oobu4m7ko.bkt.clouddn.com/blog-netty.png");
    ShrinkResponse response = client.execute(request);
    Assert.assertNotNull(response);
  }

}