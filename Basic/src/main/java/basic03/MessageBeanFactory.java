package basic03;

public class MessageBeanFactory {
	/* 싱글톤 패턴*/
	//먼저 생성자를 막아놔야함
	private MessageBeanFactory() {}
	// 공장을 세워준다.
	private static MessageBeanFactory factory = new MessageBeanFactory();
	public static MessageBeanFactory newInstance() {
		return factory;
	}
	
	public MessageBean createMessage(String nation) {
		if(nation.equals("kr")) {
			return new MessageBeanKr();
		} else {
			return new MessageBeanEn();
		}
	}
}
