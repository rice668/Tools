package BasicJava;

class Two {
  Byte x;
}

// 此处为Byte是byte的包装类型，初始化为null而不是0
public class PassByRefer {
  public static void main(String[] args){
    PassByRefer p=new PassByRefer();
    p.start();
  }
  void start() {
    Two t = new Two();
    System.out.print(t.x+"");
    Two t2 = fix(t);
    System.out.print(t.x+"" +t2.x);
  }

  Two fix(Two tt) {
    tt.x=42;
    return tt;
  }
}
