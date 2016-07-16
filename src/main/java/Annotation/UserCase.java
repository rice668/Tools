package Annotation;

/**
 * Created by root on 16-2-19.
 */
public @interface UserCase {
    int id() default -1;
    String description() default "no description";
}

