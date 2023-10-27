package basic02;

public class App {

	public static void main(String[] args) {
		/*
		MessageBean bean = new MessageBeanKr();
		bean.sayHello("홍길동");
		
		MessageBean bean2 = new MessageBeanEn();
		bean2.sayHello("Tom");
		*/
		//부모는 자식의 글을 참조할 수 있다.		
		MessageBean bean = new MessageBeanKr();
		bean.sayHello("홍길동");
		
		bean = new MessageBeanEn();
		bean.sayHello("Tommy");

	}

}
