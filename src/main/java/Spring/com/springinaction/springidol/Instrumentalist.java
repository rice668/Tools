package Spring.com.springinaction.springidol;

import Spring.com.springinaction.springidol.Interface.Car;
import Spring.com.springinaction.springidol.Interface.Instrument;
import Spring.com.springinaction.springidol.Interface.Performer;

public class Instrumentalist implements Performer {

  private String song; // 此属性的值会被注入进来

  private Instrument instrument; // 此属性的值也会被注入进来

  private Car car; // 此属性的值也会被注入进来

  public Instrumentalist() {
  }

  // 用哪种乐器演奏这首歌曲
  @Override
  public void perform() {
    System.out.print("Playing " + song + " : ");
    instrument.play();
    car.kind();
  }

  // 在依赖注入的时候，会被Spring注入值
  public void setSong(String song) {
    this.song = song;
  }

  public void setInstrument(Instrument instrument) {
    this.instrument = instrument;
    System.out.println(instrument.toString());
  }

  public void setCar(Car car) {
    this.car = car;
  }
}
