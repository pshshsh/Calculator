package com.example.calculator2;

import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in); //입력 받은 수 저장하는 변수
    Calculator2 calculator = new Calculator2(); //Calculator2 클래스의 객체 생성 및 객체를 calculator 변수에 저장

    while (true) {
      // 첫 번째 숫자 입력
      int num1 = 0;
      while (true) {
        System.out.println("첫 번째 숫자를 입력하세요: ");
        num1 = sc.nextInt();
        if (num1 < 0) {
          System.out.println("0 이상인 정수를 입력해주세요.");
          continue; // 0미만 숫자 입력하면 다시 입력으로 반복
        }
        break; //  제대로 입력하면 반복문 종료
      }

      // 두 번째 숫자 입력
      int num2 = 0;
      while (true) {
        System.out.println("두 번째 숫자를 입력하세요: ");
        num2 = sc.nextInt();
        if (num2 < 0) {
          System.out.println("0 이상인 정수를 입력해주세요.");
          continue; //  0미만 숫자 입력하면 다시 입력으로 반복
        }
        break; // 제대로 입력하면 반복문 종료
      }

      // 사칙연산 입력
      char operator = ' ';
      while (true) {
        System.out.println("사칙연산 기호를 입력하세요 (+, -, *, /): ");
        operator = sc.next().charAt(0);
        // 나눗셈에서 두 번째 숫자가 0일 경우
        if (operator == '/' && num2 == 0) {
          System.out.println("나눗셈 연산에서 분모는 0이 될 수 없습니다.");
          System.out.println("두 번째 숫자를 다시 입력하세요:");
          while (true) {
            num2 = sc.nextInt(); // 두번째 숫자 0과 /을 입력하면 두 번째 숫자를 다시 입력받음
            if (num2 < 0) {
              System.out.println("0 이상인 정수를 입력해주세요.");
              continue;
            }
            break; // 2번째 숫자 제대로 입력하면 반복문 종료
          }
          continue; // 사칙연산 입력으로 돌아감
        }

        // 잘못된 연산 기호 입력 시 처리
        if (operator != '+' && operator != '-' && operator != '*' && operator != '/') {
          System.out.println("+, -, *, / 중에 입력해주세요.");
          continue; // 연산 기호 입력으로 돌아감
        }

        break; // 올바른 연산 기호 입력 시 반복 종료
      }

      // 계산
      int result = calculator.calculate(num1, num2, operator);// calculator객체의 calculate 메서드 호출하고 return값을 result에 저장
      System.out.println("계산 결과: " + result); // 계산 결과 표시
      // 결과
      System.out.println("현재까지 저장된 계산된 값: " + calculator.getResults()); //getResults메서드를 통해 현재 저장된 값 받아옴
      // 삭제
      System.out.println("첫번째 값 삭제 하시겠습니까? yes 누르면 삭제");
      String delete = sc.next();
      if(delete.equalsIgnoreCase("yes")){
        calculator.removeResult(); // yes 누르면 removeResult 실행
        System.out.println("삭제 후 저장된 계산 값 : " + calculator.getResults());
      }


      // 계산을 반복할지 결정
      System.out.println("계속 계산하시겠습니까? (exit 입력 시 종료): ");
      String input = sc.next();
      if (input.equalsIgnoreCase("exit")) {
        break;
      }
    }
    // exit를 누르면 프로그램 종료
    System.out.println("프로그램 종료");
    sc.close();
  }
}
