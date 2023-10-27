package basic06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	//spring project를 시작할 수 있는 역할
	private static ApplicationContext ctx;
	
	public static void main(String[] args) {
		
		//ctx = new ClassPathXmlApplicationContext("config/basic06_config.xml");
		// @어노테이션을 읽어들일 수 있는 클래스가 필요함 -> 스캐너 준비
		// 스캐너 준비 basic06에 있는 아이들을 쭈욱~ 스캐닝함
		ctx = new AnnotationConfigApplicationContext("basic06");
		//System.out.println(ctx2);
		
		//class이름을 가져다 쓸 수 있다. 첫 글자는 소문자로
		MessageBean bean = ctx.getBean("msgKr", basic06.MessageBean.class);
		bean.sayHello();
		
		bean = ctx.getBean("msgEn", basic06.MessageBean.class);
		bean.sayHello();
	

	}

}
