package BasicJava.Reflection_IOC_AOP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MysqlTest {

  public static void main(String[] args) throws Exception {
//    ClassLoader loader = Thread.currentThread().getContextClassLoader();
//    Class clazz = loader.loadClass("com.mysql.jdbc.Driver");
    Class.forName("com.mysql.jdbc.Driver"); // 加载类，并且执行类初始化, 并不一定要有这个
    String url = "jdbc:mysql://localhost:3306/test?user=root&password=660202";
    Connection con = DriverManager.getConnection(url);
    Statement statement = con.createStatement();
    String sql = "select * from t_element";
    ResultSet rs = statement.executeQuery(sql);
    while (rs.next()) {
      System.out.println(rs.getObject(1) + "  " +
              rs.getObject(2));
    }
  }
}
