package io.github.mrdear.tinify.internal.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author Quding Ding
 * @since 2018/7/28
 */
public class TinifyFileUtils {

  private static Logger logger = LoggerFactory.getLogger(TinifyFileUtils.class);

  /**
   * 读取指定文件的全部内容
   * @param path 指定文件路径
   * @return 读取结果
   */
  public static byte[] readAllBytes(String path) {
    try {
      return Files.readAllBytes(Paths.get(path));
    } catch (IOException e) {
      logger.error("read file bytes fail, file path is {}", path, e);
    }
    return new byte[0];
  }

  public static byte[] readAllBytes(InputStream stream) {
    try {
      byte[] data = new byte[stream.available()];
      int read = stream.read(data);
      return data;
    } catch (IOException e) {
      logger.error("read file bytes fail", e);
    }
    return new byte[0];
  }

}
