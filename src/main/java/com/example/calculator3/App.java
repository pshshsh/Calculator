//계산기 레벨 3 : 열거형까지만 구현
package com.example.calculator3;

import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    ArithmeticCalculator calculator = new ArithmeticCalculator();

    while (true) {
      // 첫 번째 숫자 입력
      double num1 = 0;
      while (true) {
        System.out.println("첫 번째 숫자를 입력하세요: ");
        num1 = sc.nextDouble();
        if (num1 >= 0) {
          break; // 0 이상인 숫자 입력 시 반복 종료
        }
        System.out.println("0 이상인 숫자를 입력해주세요.");
      }

      // 두 번째 숫자 입력
      double num2 = 0;
      while (true) {
        System.out.println("두 번째 숫자를 입력하세요: ");
        num2 = sc.nextDouble();
        if (num2 >= 0) {
          break; // 0 이상인 숫자 입력 시 반복 종료
        }
        System.out.println("0 이상인 숫자를 입력해주세요.");
      }

      // 사칙연산 입력
      OperatorType.OperationType operation = null;
      while (true) {
        System.out.println("사칙연산 기호를 입력하세요 (+, -, *, /): ");
        char operator = sc.next().charAt(0);

        // 입력된 기호를 열거형으로 변환 ( + -> ADD)
        switch (operator) {
          case '+':
            operation = OperatorType.OperationType.ADD;
            break;
          case '-':
            operation = OperatorType.OperationType.MINUS;
            break;
          case '*':
            operation = OperatorType.OperationType.MULTIPLE;
            break;
          case '/':
            if (num2 == 0) { // 나누기연산인데 2번째 숫자가 0일경우 다시 두번째숫자입력
              System.out.println("나눗셈 연산에서 분모는 0이 될 수 없습니다. 두 번째 숫자를 다시 입력하세요:");
              while (true) {
                num2 = sc.nextDouble();
                if (num2 > 0)
                  break;
                System.out.println("0 이상인 숫자를 입력해주세요.");
              }
            }
            operation = OperatorType.OperationType.DIVIDE;
            break;
          default:
            System.out.println("+, -, *, / 중에 입력해주세요.");
            continue; // 잘못된 연산 기호 입력 시 다시 반복
        }
        break; // 올바른 연산 기호 입력 시 반복 종료
      }

      // 계산
      double result = calculator.calculate(num1, num2, operation);
      System.out.println("계산 결과: " + result);

      // 저장된 결과 출력
      System.out.println("현재까지 저장된 계산된 값: " + calculator.getResults());

      // 결과 삭제 여부
      System.out.println("첫 번째 값을 삭제하시겠습니까? (yes 입력 시 삭제): ");
      String delete = sc.next();
      if (delete.equalsIgnoreCase("yes")) {
        calculator.removeResult();
        System.out.println("삭제 후 저장된 계산 값: " + calculator.getResults());
      }

      // 계산 반복 여부
      System.out.println("계속 계산하시겠습니까? (exit 입력 시 종료): ");
      String input = sc.next();
      if (input.equalsIgnoreCase("exit")) {
        break;
      }
    }

    // 프로그램 종료
    System.out.println("프로그램 종료");
    sc.close();
  }
}
