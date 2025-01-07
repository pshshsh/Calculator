package com.example.calculator2;

import java.util.ArrayList;

public class Calculator2 {
  // 필드 영역 : 정수 저장하는 동적 배열 선언 및 생성
  private ArrayList<Integer> results = new ArrayList();

  // 메서드 (매개변수 지정)
  public int calculate(int num1, int num2, char operator) {
    int result = 0;
    // 사칙 연산 입력된거에 맞게 계산
    switch (operator) {
      case '+':
        result = num1 + num2;
        break;

      case '-':
        result = num1 - num2;
        break;
      case '*':
        result = num1 * num2;
        break;
      case '/':
        result = num1 / num2;
        break;

      default:
        System.out.println("+, -, *, / 중에 입력해주세요.");

    }
    results.add(result); // results배열에 계산된 값 자동 추가
    return result; // 계산된 결과 값 리턴
  }

  // Getter 메서드
  public ArrayList<Integer> getResults() {
    return results; //private 선언된 results필드를  접근할수있는 메서드
  }

  public int removeResult() {
    return results.remove(0); //results에서 첫번째 숫자 삭제
  }
}





