package basic08;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	private static ApplicationContext ctx;
	
	public static void main(String[] args) {
		//클래스 패스에서 읽어올 수 있다. 의존성과는 전혀 관계없는 객체이다.
		ctx = new ClassPathXmlApplicationContext("config/basic08_config.xml");
		
		MessageBean bean = ctx.getBean("msg", MessageBean.class);
		bean.sayHello();
		
	}

}
