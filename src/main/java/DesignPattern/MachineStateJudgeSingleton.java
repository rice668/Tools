package DesignPattern;

/**
 * Created by root on 16-7-13.
 */

public class MachineStateJudgeSingleton {

  private MachineStateJudgeSingleton() {
  }

  private static MachineStateJudgeSingleton singleton = null;

  public static MachineStateJudgeSingleton getInstance() {

    if (null == singleton) {
      synchronized (MachineStateJudgeSingleton.class) {
        if (null == singleton) {
          singleton = new MachineStateJudgeSingleton();
        }
      }
    }
    return singleton;


  }
}
