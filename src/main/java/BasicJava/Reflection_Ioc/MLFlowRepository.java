package BasicJava.Reflection_Ioc;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by root on 16-7-20.
 */
public interface MLFlowRepository extends
        JpaRepository<Object, Long>, JpaSpecificationExecutor<Object> {
}