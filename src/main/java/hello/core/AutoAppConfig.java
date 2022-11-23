package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/*
기존의 AppConfig와 동일하게 @Configuration이 등장
추가로 @ComponentScan이 등장하는데 이는 @Component가 붙은 클래스를 모두 Bean으로 등록해준다.

excludeFilters는 기존에 수동생성한 AppConfig와의 충돌을 방지하기 위한 코드

해당 AutoAppConfig가 완성되면 내가 사용하고자 하는 클래스에 @Component를 붙여준다.
또한 의존관계를 자동 주입하기 위해 @Autowired도 붙여준다

cf : shift 두 번 누르면 class 찾을 수 있다.
 */

@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type= FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

}
