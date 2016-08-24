package BasicAlgorithms.Bit;

/**
 * Created by mingleizhang on 2016/8/24. zhihu
 */
public class BitOpExample_Two {

  private int featureFlags;
  public final static int FEATURE_FLAG_1 = 1 << 0;
  public final static int FEATURE_FLAG_2 = 1 << 1;
  public final static int FEATURE_FLAG_3 = 1 << 2;

  boolean isFeatureEnabled(int featureFlag) {
    return (this.featureFlags & featureFlag) > 0;
  }

  void enableFeatures(int featureFlags) {
    this.featureFlags |= featureFlags;
  }

  void disableFeatures(int featureFlags) {
    this.featureFlags &= ~featureFlags;
  }

  void toggleFeatures(int featureFlags) {
    this.featureFlags ^= featureFlags;
  }

}
