package Annotation;

/**
 * Created by root on 16-2-19.
 */
public class Testable {
    public void execute() {}

    @Test void testExecute() { execute(); }
}
