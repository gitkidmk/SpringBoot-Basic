package singleton;

import hello.core.AppConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest {
    @Test
    void ConfigurationDeep(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);
        System.out.println("bean.getClass() = " + bean.getClass());
        /*
        AppConfig를 보면 분명 emberRepository의 경우 세번 실행되어야하지만, 실제 AppConfig에서는 단 한번만의 실행이 됨을 확인함
        왜 그럴까?
        AppConfig 빈 출력 결과를 보면
        bean.getClass() = class hello.core.AppConfig$$EnhancerBySpringCGLIB$$2b0f67d
        hello.core.AppConfig가 아닌 AppConfig@CGLIB로 다른 class가 생성되었음을 확인할 수 있다.
        스프링이 CGLIB라는 바이트코드 조작 라이브러리를 사용해 AppConfig 클래스를 상속받은 임의의 다른 클래스를 만들고, 이 클래스를 스프링 빈으로 등록한 것

        이를 통해 스프링은 memberRepository 호출이 단 한번 이뤄져 싱글톤이 가능하도록한다.

        간단히 AppConfig@CGLIB 코드의 로직은 어떻게 돌아갈까?

        memberRepository에서 memberMemoryRepository를 생성하려고 할 때

        if 해당 객체가 스프링 컨테이너에 등록이 되어있는지를 확인하고, -> 있으면 생성 X, 스프링 컨테이너에서 해당 객체 반환
        else 없으면 -> 새로 생성하고 스프링 컨테이너에 등록

        AOP에서도 이와 동일한 매커니즘 사용함

        당연하게도 AppConfig에서 @Configuration을 제외하면, CGLIB가 적용안되어 싱글톤 보장이 안된다.
        따라서 @Configuration을 사용해 스프링 싱글톤의 마법을 사용하자
         */
    }
}
