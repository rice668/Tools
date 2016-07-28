package Thrift;

import org.apache.thrift.TException;

/**
 * Created by root on 16-7-27.
 */
public class HelloServiceImpl implements Hello.Iface {
  @Override
  public String helloString(String para) throws TException {
    return para;
  }

  @Override
  public int helloInt(int para) throws TException {
    try {
      Thread.sleep(20000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return para;
  }

  @Override
  public boolean helloBoolean(boolean para) throws TException {
    return para;
  }

  @Override
  public void helloVoid() throws TException {
    System.out.println("Hello World");
  }

  @Override
  public String helloNull() throws TException {
    return null;
  }
}
