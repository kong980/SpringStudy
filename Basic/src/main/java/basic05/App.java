package basic05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	//spring project를 시작할 수 있는 역할
	private static ApplicationContext ctx;
	
	public static void main(String[] args) {
		//클래스 패스에서 읽어올 수 있다. 의존성과는 전혀 관계없는 객체이다.
		ctx = new ClassPathXmlApplicationContext("config/basic05_config.xml");
		//System.out.println(ctx);
		
		//객체 생성은 basic05_config.xml 설정자에서 해줘야한다.
		//type에 부모class를 넣어줘야 더 범용적으로 사용 할 수 있다.
		MessageBean bean = ctx.getBean("messageBean", MessageBean.class);
		// 값을 넣어주지 않으면 null! null 님~~ 이제 당신은 0살 입니다.
		//값을 넣어주는 방법은 두 가지 1. basic05_congfig
		bean.sayHello(); 		
		
	}

}
