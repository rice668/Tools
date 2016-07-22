package DesignPattern.Dynamic_Proxy.ThirdSample;

/**
 * 目标对象
 * @author zyb
 * @since 2012-8-9
 *
 */
public class UserServiceImpl implements UserService {
  public void add() {
    System.out.println("--------------------add---------------");
  }
}