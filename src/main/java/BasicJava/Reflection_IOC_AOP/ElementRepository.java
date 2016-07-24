package BasicJava.Reflection_IOC_AOP;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by root on 16-7-20.
 */
public interface ElementRepository
        extends JpaRepository<Object, Long>, JpaSpecificationExecutor<Object> {
}
