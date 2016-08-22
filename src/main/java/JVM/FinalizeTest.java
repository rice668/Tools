package JVM;

class TestFinalize_ {
  @Override
  protected void finalize() throws Throwable {
    super.finalize();
    System.out.println("finalized");
  }
}

public class FinalizeTest {
  public static void main(String[] args) {
    // TestFinalize tf = new TestFinalize();
    TestFinalize_ testFinalize_ = new TestFinalize_();
    System.gc();
  }
}