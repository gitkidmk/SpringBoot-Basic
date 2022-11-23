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

/*
ex)
@ComponentScan(
        basePackages = "hello.core.member"
        excludeFilters = @ComponentScan.Filter(type= FilterType.ANNOTATION, classes = Configuration.class)
)

basePackage를 지정하면 해당 패키지 하위의 패키지 모두를 탐색한다.
basePackage는 여러개를 지정할수도 있다.
지정하지 않으면 default로 (Auto)AppConfig 클래스가 있는 hello.core에서 시작한다.

관례를 따라 가장 최상단(hello.core)에 AppConfig를 두자

참고로 스프링부트로 프로젝트를 만들게되면 자동으로 생성되는 클래스(여기서는 CoreApplicaion)가 존재함
해당 클래스에는 @SpringBootApplication이 붙는데, 여기에도 @ComponentScan이 내장되어있다.

@ComponentScan이 스캔하는 대상
    @Component
    @Controller
    @Service
    @Repository
    @Configuration

p.s. @Component를 제외한 어노테이션을 보면 모두 @Component가 내장되어있음
p.s. Annotation은 Java에서 지원하는 기능이 아닌 Spring에서 지원하는 기능이다
 */

@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type= FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

}
