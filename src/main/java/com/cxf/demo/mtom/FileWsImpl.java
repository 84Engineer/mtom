package com.cxf.demo.mtom;

import org.apache.cxf.helpers.IOUtils;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author olysenko
 */
public class FileWsImpl implements FileWs {

   private static final String FILE_PATH;

   static {
      String fileSeparator = System.getProperty("file.separator");
      FILE_PATH =
            System.getProperty("user.dir") + fileSeparator + "storage" + fileSeparator + "test";
   }

   @Override
   public void upload(DataHandler dataHandler) {
      try (InputStream in = dataHandler.getInputStream();
            OutputStream out = new BufferedOutputStream(new FileOutputStream(FILE_PATH))) {
         IOUtils.copy(in, out);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   @Override
   public DataHandler download() {
      return new DataHandler(new FileDataSource(new File(FILE_PATH)));
   }

}
