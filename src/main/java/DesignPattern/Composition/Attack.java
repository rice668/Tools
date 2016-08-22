package DesignPattern.Composition;

/**
 * Created by root on 16-7-29.
 * 把一些动作抽象出来形成接口，这样减少耦合度
 */
public interface Attack {
  public void move();
  public void attack();
}
