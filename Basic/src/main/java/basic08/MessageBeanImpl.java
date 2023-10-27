package basic08;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

//Impl(접미사): 인터페이스를 물려받았구나!
public class MessageBeanImpl implements MessageBean{
	private String name;
	private int age;
	private String greeting;	
	private Outputter outputter;

	// 생성자
	public MessageBeanImpl() {}

	public MessageBeanImpl(String name, int age) {
		this.name = name;
		this.age = age;
	}
	/*@Autowired는 메서드나 생성자에서 사용 가능한데, setter에 사용하는 것 보다는
	 * 생성자에 사용하는게 더 좋다고 하신거같음 
	//2.생성자
	@Autowired
	public MessageBeanImpl(Outputter outputter) {
		this.outputter = outputter;
	}
	*/
	
	
	//setter 메서드 값으로 전달받음
	public void setName(String name) {	this.name = name; }
	public void setAge(int age) {	this.age = age;	}
	//만약 같은 타입이 여러개 있다면?
	// expected single matching bean but found 2: outputter_rename,outputter_rename2 오류 해결 방법
	// 생성자에는 @@Qualifier 사용 불가
	/*
	//1.메서드 @Autowired를 스캔할 수 잇는 스캐너가 필요하다.->basic08_config.xml
	 *
	 */	
	@Autowired
	@Qualifier("out1")
	public void setOutputter(Outputter outputter) {
		this.outputter = outputter;
	}
	
	@Override
	public void sayHello() {
		String msg = name + " 님~~ 이제 당신은 " + age + "살 입니다.ver5";
		System.out.println(msg);
		
		try {
			outputter.output(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
