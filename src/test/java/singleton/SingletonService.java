package singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();

    // 오직 이 메서드를 통해서 객체 조회가 가능하다
    public static SingletonService getInstance(){
        return instance;
    }

    // 객체 인스턴스가 new로 새로 생성되는 것을 막는다
    private SingletonService(){

    }

    // 사실 이 서비스만 쓰고싶은데, singleton을 위해 위의 모든 코드가 들어간다. -> 스프링 컨테이너는 이 불편함 + DIP, OCP위반을 해결한다.
    public void logic(){
        System.out.println("싱글톤 서비스 호출");
    }
}
