package basic07;

import java.io.IOException;

//어떤 장치로 출력할 것인지 : 하나의 인터페이스를 통해서 다양한 입력장치를 만들 수 있다.
public interface Outputter {
	
	void output(String msg) throws IOException;
}
