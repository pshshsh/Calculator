//계산기 레벨 1
package com.example.calculator;

import java.util.Scanner;

public class Calculator {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);//입력받는 sc 변수생성
    while (true) { //무한루프
      int num1 = 0; //입력받은 숫자 저장 변수
      while (true) {
        System.out.println("첫번째 숫자를 입력하세요: ");
        num1 = sc.nextInt();
        if (num1 < 0) {
          System.out.println("0이상인 정수를 입력해주세요");
          continue; // 0미만이면 조건식 처음으로 돌아감
        }
        break; // 0이상이면 반복문 종료
      }
      // 두번째 숫자입력 ( 형식은 첫번째 숫자반복)
      int num2 = 0;
      while (true) {
        System.out.println("두번째 숫자를 입력하세요: ");
        num2 = sc.nextInt();
        if (num2 < 0) {
          System.out.println("0이상인 정수를 입력해주세요");
          continue;
        }
        break;
      }
      while(true){
        System.out.println("사칙연산 기호를 입력하세요: ");
        char operator = sc.next().charAt(0);//사칙연산 입력받고 operator에 저장
        int result = 0; // 계산 결과 저장 변수

        switch (operator) {
          case '+':
            result = num1 + num2;
            System.out.println("결과: " + result);
            break;

          case '-':
            result = num1 - num2;
            System.out.println("결과: " + result);
            break;
          case '*':
            result = num1 * num2;
            System.out.println("결과: " + result);
            break;
          case '/':
            if (num2 == 0) { //2번째 숫자 0을 받고 나누기를 누르면 두번째 숫자 다시입력
              System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
              System.out.println("두번째 숫자 다시 입력하시오:");
              num2 = sc.nextInt();
              continue;
            } else {
              result = num1 / num2;
              System.out.println("결과: " + result);
              break;
            }
          default:
            System.out.println("+, -, *, / 중에 입력해주세요.");
            continue;
        }
        break;

      }

      System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
      String input = sc.next();
      if (input.equalsIgnoreCase("exit")) {
        break;
      }

    }
    System.out.println("프로그램 종료");
    sc.close();
  }

}