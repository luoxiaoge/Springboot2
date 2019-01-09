/**
 * @author luoc
 * @date 2018/12/12 0012
 * @Time 13:53
 */

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(SwaggerApplication.class)
@Inherited
public @interface MySwagger {
}
