package basic03;

public class App {

	public static void main(String[] args) {
		/*
		MessageBean bean = new MessageBeanKr();
		bean.sayHello("홍길동");
		
		MessageBean bean2 = new MessageBeanEn();
		bean2.sayHello("Tom");
		*/
		//부모는 자식의 글을 참조할 수 있다.		
		/*
		MessageBean bean = new MessageBeanKr();
		bean.sayHello("홍길동");
		
		bean = new MessageBeanEn();
		bean.sayHello("Tommy");
		*/
		//공장의 위치를 알아낸다.. 생성X
		MessageBeanFactory factory = MessageBeanFactory.newInstance();
		//공장에게 어느 물건이 필요한지 말한다.
		MessageBean bean = factory.createMessage("kr");
		bean.sayHello("신돌석");
		
		bean = factory.createMessage("en");
		bean.sayHello("Tom");
		
	}

}
