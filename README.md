# TinyPNG Java SDK

TinyPNG的Java SDK封装,官方提供的都是静态方法来请求,自己用起来不是很习惯,因此封装了一个,该SDK是按照命令模式设计,因此使用是相当简单.


## 初始化Client

Client是使用方所关心的执行器,其需要提供APIKey以及HTTP的实现类(由于大多数场景都是需要定制Http请求,因此这里是直接让使用方实现).

```java
  TinifyClient client = new DefaultTinifyClient("api key", HTTP实现类);
```

## Shrink

图片瘦身,使用方式创建对应的请求命令`XXRequest`,然后使用`Client`执行即可.

```java
  @Test
  public void testShrink() {
    ShrinkRequest request = new ShrinkRequest();
    request.setSourceUrl("http://oobu4m7ko.bkt.clouddn.com/blog-netty.png");
    
    ShrinkResponse response = client.execute(request);
    Assert.assertNotNull(response);
  }
```

## 待开发

其他功能暂时自己没怎么用到,用到再完善...