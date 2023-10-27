package com.netsol7.member;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.netsol7.member.model.RegisterRequest;
import com.netsol7.member.service.ChangePasswordService;
import com.netsol7.member.service.MemberInfoPrinter;
import com.netsol7.member.service.MemberListPrinter;
import com.netsol7.member.service.MemberRegisterService;

public class App {
	//application_context
	private static ApplicationContext ctx;
	
    public static void main( String[] args ) throws IOException{
    	//클래스 패스에서 읽어올 수 있다. 의존성과는 전혀 관계없는 객체이다.
    	ctx = new ClassPathXmlApplicationContext("config/application_context_config.xml");
    	
    	//키보드로 입력받기
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	while(true) {
	    	System.out.println("명령어를 입력하세요 : ");
	    	String command = br.readLine();
	    	
	    	if(command.equalsIgnoreCase("exit")) {
	    		System.out.println("프로그램을 종료합니다.");
	    		break;
	    	}
	    	
	    	if(command.startsWith("new ")) {
	    		newCommand(command.split(" "));	    		
	    		continue;
	    	}
	    	
	    	else if(command.startsWith("change ")) {
	    		changeCommand(command.split(" "));	    		
	    		continue;
	    	}
	    	//전체 조회를 출력할 수 있도록
	    	else if(command.equals("list")) {
	    		listCommand();
	    		continue;
	    	}
	    	//한 칸 띄운이유 : 이메일 주소를 같이 넣을 수 있도록 
	    	else if(command.startsWith("info ")) {
	    		infoCommand(command.split(" "));
	    		continue;
	    	}
	    	printHelp();
	    	
    	}//while문 End
    }
    private static void newCommand(String cmd[]) {
    	if(cmd.length != 5) {
			printHelp();
			return;
		}
		//MemberRegisterService에게 넘겨
		RegisterRequest req = new RegisterRequest();
		req.setEmail(cmd[1]);
		req.setName(cmd[2]);
		req.setPassword(cmd[3]);
		req.setConfirmPassword(cmd[4]);
		
		MemberRegisterService regSvc = ctx.getBean("memberRegSvc", MemberRegisterService.class);
		if(!req.isPasswordEqualToconfirmPassword()) {
			System.out.println("암호와 암호확인이 맞지 않습니다.\n");
			return;
		}
		else {
    		//누구한테 부탁해야해요?
    		regSvc.regist(req);
    		System.out.println("잘 등록되었습니다.");
		}
    }
    private static void changeCommand(String cmd[]) {
    	if(cmd.length != 4) {
			printHelp();
			return;
		}
		//이메일과 비밀번호만 받기때문에 사소한 DTO는 만들 필요까지는 없다. 
		//변수를 각각 개별적으로 주어도 상관 없다.
		//서비스에 전달
		ChangePasswordService changePwdSvc = ctx.getBean("memberPwdSvc", ChangePasswordService.class);
		//System.out.println("가나다라마바사" + changePwdSvc);
		changePwdSvc.changePassword(cmd[1], cmd[2], cmd[3]);
		System.out.println("암호를 변경했습니다.");
		
    }
    private static void infoCommand(String cmd[]) {
    	if(cmd.length != 2) {
			printHelp();
			return;
		}
    	MemberInfoPrinter infoPrinter = ctx.getBean("infoPrinter", MemberInfoPrinter.class);
    	infoPrinter.printMemberInfo(cmd[1]);
    	
    	
    }
    private static void listCommand() {
    	MemberListPrinter listPrinter = ctx.getBean("listPrinter", MemberListPrinter.class);
    	listPrinter.printAll();
    }
    //딱 한개만만들거니까
    private static void printHelp() {
    	System.out.println();
    	System.out.println("잘못된 명령어 입니다.");
    	System.out.println("new 이메일 이름 암호 암호확인");
    	System.out.println("change 이메일 현암호 바꿀암호");
    	System.out.println("info 이메일");
    	System.out.println();
    }
}
