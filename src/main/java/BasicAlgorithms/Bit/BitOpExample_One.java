package BasicAlgorithms.Bit;

/**
 * Created by mingleizhang on 2016/8/24.
 */
public class BitOpExample_One {

  private boolean feature1Enabled;
  private boolean feature2Enabled;
  private boolean feature3Enabled;

  void enableFeatures(boolean enableFeature1, boolean enableFeature2, boolean enableFeature3) {
    this.feature1Enabled = enableFeature1;
    this.feature2Enabled = enableFeature2;
    this.feature3Enabled = enableFeature3;
  }

  boolean isFeature1Enabled() {
    return this.feature1Enabled;
  }

  boolean isFeature2Enabled() {
    return this.feature2Enabled;
  }

  boolean isFeature3Enabled() {
    return this.feature2Enabled;
  }

  void toggleFeature1() {
    this.feature1Enabled = !this.feature1Enabled;
  }

  void toggleFeature2() {
    this.feature2Enabled = !this.feature2Enabled;
  }

  void toggleFeature3() {
    this.feature3Enabled = !this.feature3Enabled;
  }
}
