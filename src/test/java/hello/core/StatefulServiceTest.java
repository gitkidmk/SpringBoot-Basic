package hello.core;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {
    @Test
    void statefuleServiceSingleTon(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        //ThreadA : A 사용자 1만원 주문
        int order1 = statefulService1.order("userA", 10000);
        //ThreadB : B 사용자 2만원 주문
        int order2 = statefulService2.order("userB", 20000);

        //ThreadA : 사용자A 주문 금액 조회
        System.out.println("price = " + order1);

        Assertions.assertThat(order1).isEqualTo(10000);
    }
    static class TestConfig{
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }

}