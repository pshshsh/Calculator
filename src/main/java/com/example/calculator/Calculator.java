package com.example.calculator;

import java.util.Scanner;

public class Calculator {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (true) {
      int num1 = 0;
      while (true) {
        System.out.println("첫번째 숫자를 입력하세요: ");
        num1 = sc.nextInt();
        if (num1 < 0) {
          System.out.println("0이상인 정수를 입력해주세요");
          continue;
        }
        break;
      }

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
        char ch = sc.next().charAt(0);
        int result = 0;

        switch (ch) {
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
            if (num2 == 0) {
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
      String input2 = sc.next();
      if (input2.equalsIgnoreCase("exit")) {
        break;
      }

    }
  }

}