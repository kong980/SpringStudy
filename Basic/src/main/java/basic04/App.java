package basic04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	//spring project를 시작할 수 있는 역할
	private static ApplicationContext ctx;
	public static void main(String[] args) {
		//클래스 패스에서 읽어올 수 있다. 의존성과는 전혀 관계없는 객체이다.
		ctx = new ClassPathXmlApplicationContext("config/basic04_config.xml");
		//System.out.println(ctx);
		
		//("name", type)
		MessageBean bean = ctx.getBean("msgKr", basic04.MessageBean.class);
		bean.sayHello("홍길동");
		
		bean = ctx.getBean("msgEn", basic04.MessageBean.class);
		bean.sayHello("Tommy");
		
		bean = ctx.getBean("mkr", basic04.MessageBean.class);
		bean.sayHello("유비");
		
		bean = ctx.getBean("mskr", basic04.MessageBean.class);
		bean.sayHello("장비");
		
		bean = ctx.getBean("kr", basic04.MessageBean.class);
		bean.sayHello("관우");

	}

}
