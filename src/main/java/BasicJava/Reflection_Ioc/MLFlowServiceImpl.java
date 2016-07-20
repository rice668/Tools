package BasicJava.Reflection_Ioc;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by root on 16-7-20.
 */
@Service
public class MLFlowServiceImpl {
  @Resource
  private MLFlowRepository flowRepository; // This is called Ioc as interface.
  @Resource
  private ElementRepository elementRepository;

  /**
   * That use java reflection to do the crud operation.
   * @param flowId
   */
  public void performCurd(Long flowId) {
    flowRepository.findOne(flowId);
    flowRepository.delete(flowId);
    flowRepository.save(123);
  }



}