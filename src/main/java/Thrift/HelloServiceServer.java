package Thrift;

/**
 * Created by root on 16-7-27.
 */
import org.apache.thrift.TException;

import org.apache.thrift.TProcessor;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;

public class HelloServiceServer {
  /**
   * 启动 Thrift 服务器
   * @param args
   */
  public static void main(String[] args) {
    try {
      TServerSocket serverTransport = new TServerSocket(7911);
      TProcessor processor = new Hello.Processor(new HelloServiceImpl());
      TServer server = new TSimpleServer
              (new TThreadPoolServer.Args(serverTransport).processor(processor));
      System.out.println("Starting the simple server...");
      server.serve();
    } catch (TTransportException e) {
      e.printStackTrace();
    }
  }
}