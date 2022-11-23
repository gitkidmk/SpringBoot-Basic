package hello.core.scan.filter;

import java.lang.annotation.*;

/*
ComponentFilter를 위해 Custom Annotaion을 생성해본다
아래 Annotaion은 @Componnent에서 참고했다
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyExcludeComponent {
}
