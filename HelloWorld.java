package day01;//1. 패키지 선언문
//2. import문
//import 패키지명.클래스명;
import java.lang.System;
//3. class 선언문
//public class 클래스명{ 명령문....  }
//클래스명과 파일명을 동일하게 (대소문자도 동일하게)
//클래스명=>대문자로 시작. camel표기법 사용
//[1] 원시코드를 컴파일 (javac)==> HelloWorld.class파일이 생성됨
//[2] 인터프리터(java)로 class 파일을 해석
public class  HelloWorld {
    //main()메서드 (동사형, 소문자로 시작,camel표기법)
    public static void main(String[] args) {
        System.out.println("Hello World ~~");
        System.out.println("안녕하세요?");
        System.out.print("Hi Java? ");
        System.out.println("Bye Bye~~");
        //컴파일: Ctrl+S (저장)
        //실행 : Ctrl+F11 
    }
}