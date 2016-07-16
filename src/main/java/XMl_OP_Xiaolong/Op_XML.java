package XMl_OP_Xiaolong;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class Op_XML {

  /**
   * Download XML from net and return it as an InputStream.
   *
   * @param filePathInternet
   * @return
   * @throws IOException
   */
  public static InputStream downloadXML(final String filePathInternet) throws IOException {
    InputStream inStream;
    URL url = new URL(filePathInternet);
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    conn.setConnectTimeout(5 * 1000);
    conn.setRequestMethod("GET");
    conn.connect();
    inStream = conn.getInputStream();
    return inStream;
  }

  /**
   * Turn an inputStream into a byte array.
   *
   * @param inputStream
   * @return
   * @throws IOException
   */
  public static byte[] readInputStream(InputStream inputStream) throws IOException {
    byte[] buffer = new byte[1024];
    int len;
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    while ((len = inputStream.read(buffer)) != -1) {
      bos.write(buffer, 0, len); // take these data to the output stream
    }
    bos.close();
    inputStream.close();
    return bos.toByteArray();
  }

  /**
   * Write data to the files
   *
   * @param fileName
   * @param appId
   * @param day
   * @param hour
   * @throws Exception
   */
  static void dealXml(String fileName, String appId, String day, String hour) throws Exception {
    System.out.println(fileName);
    int count = 1;
    SAXReader saxReader = new SAXReader();
    Document document = saxReader.read(new File(fileName));
    Element root = document.getRootElement();
    List<Element> elements = root.element("report").element("machine").element("type").elements("name");
    File file = new File("/root/Tools/src/main/java/XMl_OP_Xiaolong/appid/response_" + appId + ".txt");
    OutputStream out = new FileOutputStream(file, true);
    for (Element e : elements) {
      if (e.attributeValue("id").equalsIgnoreCase("all")) {
        List<Element> rangList = e.elements("range");
        for (Element e1 : rangList) {
          out.write((appId + " ").getBytes());
          out.write(("201606" + day + hour + " " + (count++) + " ").getBytes());
          out.write((e1.attributeValue("avg")).getBytes());
          out.write('\r');
        }
        out.close();
      }
    }
  }

  public static void main(String[] args) throws IOException {

    String[] days = {"11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21"
            , "22", "23", "24", "25", "26", "27", "28", "29", "30"};
    String[] hours = {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09",
            "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
            "21", "22", "23"};

    for (int k = 0; k < Data.appId.length; k++) {
      for (int j = 0; j < days.length; j++) {
        for (int i = 0; i < hours.length; i++) {
          try {
            Thread.sleep(700);
          } catch (Exception ex) {
            ex.getMessage();
          }
          String filePathInternet = "http://cat.ctripcorp.com/cat/r/t?op=graphs&domain=" + Data.appId[k] + "&date=" +
                  "201606" + days[j] + hours[i] +
                  "&ip=All&type=URL&forceDownload=xml";
          InputStream inputStream = downloadXML(filePathInternet);
          byte[] getData = readInputStream(inputStream);
          String savePath = "/root/Tools/src/main/java/XMl_OP_Xiaolong";
          String fileName = "response_";
          File saveDir = new File(savePath);
          if (!saveDir.exists()) {
            saveDir.mkdir();
          }
          /**
           * XML file must write to the disk since the dealXML read the disk file.
           */
          File file = new File
                  (saveDir + File.separator + fileName + Data.appId[k] + "_" + "201606" + days[j] + hours[i] + ".xml");
          FileOutputStream fos = new FileOutputStream(file);
          fos.write(getData);
          if (fos != null) {
            fos.close();
          }
          if (inputStream != null) {
            inputStream.close();
          }
          try {
            dealXml(savePath + "/" + fileName + Data.appId[k] + "_" + "201606" + days[j] + hours[i] + ".xml", Data.appId[k], days[j], hours[i]);
          } catch (Exception e) {
            e.getMessage();
          }
        }
      }
    }
  }
}
