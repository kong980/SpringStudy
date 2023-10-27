package basic05;

import java.io.IOException;

//Impl(접미사): 인터페이스를 물려받았구나!
public class MessageBeanImpl implements MessageBean{
	private String name;
	private int age;
	private String greeting;
	//생성해둔 객체를 가지고 오기만 하면되자나! 여기에 변수를 추가해줌
	private Outputter outputter;

	// 생성자
	public MessageBeanImpl() {}

	public MessageBeanImpl(String name, int age, String greeting) {
		this.name = name;
		this.age = age;
		this.greeting = greeting;
	}
	//setter 메서드 값으로 전달받음
	public void setName(String name) {	this.name = name; }
	public void setAge(int age) {	this.age = age;	}
	public void setGreeting(String greeting) {	this.greeting = greeting; }
	//setter 메서드 추가 주입받을 준비 참조받아 주소를 전달받음
	public void setOutputter(Outputter outputter) {
		this.outputter = outputter;
	}	
	@Override
	public void sayHello() {
		String msg = greeting + "! " + name + " 님~~ 이제 당신은 " + age + "살 입니다.";
		System.out.println(msg);
		
		try {
			outputter.output(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
