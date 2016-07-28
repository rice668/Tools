package JVM;

import java.lang.ref.WeakReference;

/**
 * Created by root on 16-7-26.
 */

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
    new TestFinalize_();
    System.gc();
  }
}