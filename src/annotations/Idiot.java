package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * author:oldmanw
 * create at:2018-04-24 17:02
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE, ElementType.FIELD, ElementType.LOCAL_VARIABLE})
public @interface Idiot {

    boolean severe() default false;

    int iq() default 80;

}
