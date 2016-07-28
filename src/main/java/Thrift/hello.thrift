namespace java Thrift

// http://www.ibm.com/developerworks/cn/java/j-lo-apachethrift/ 实例程序有错误
// thrift --gen java hello.thrift

service Hello {
      string helloString(1:string para)
      i32 helloInt(1:i32 para)
      bool helloBoolean(1:bool para)
      void helloVoid()
      string helloNull()
}
