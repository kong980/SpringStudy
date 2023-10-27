package basic07;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//이 class의 역할은 설정 파일의 역할을 한다. = basic07_config.xml
@Configuration	
public class ApplicationContextConfigure {
	//메서드 생성
	@Bean
	public MessageBean getMessageKr() {
		//주입방법
		MessageBeanKr kr = new MessageBeanKr();
		kr.setAge(20);
		kr.setName("신돌석");
		kr.setOutputter(output());
		return kr;
	}
	@Bean
	public MessageBean getMessageEn() {
		MessageBeanEn En = new MessageBeanEn();
		En.setAge(30);
		En.setName("Tom");
		En.setOutputter(output());
		return En;
	}
	@Bean
	public Outputter output() {
		FileOutputter f = new FileOutputter();
		f.setFilePath("c:\\temp\\out.txt");
		return f;
		
	}
}
