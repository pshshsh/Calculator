package com.example.calculator3;

import java.util.ArrayList;

public class ArithmeticCalculator {
  // 필드 영역 : 정수 저장하는 동적 배열 선언 및 생성
  private ArrayList<Double> results = new ArrayList();

  // 메서드 (매개변수 지정)
  public double calculate(double num1, double num2,  OperatorType.OperationType operation) {
    double result = operation.calculate(num1, num2); // 리턴된 값을 result에 담기
    // 사칙 연산 입력된거에 맞게 계산

    results.add(result); // results배열에 계산된 값 자동 추가
    return result; // 계산된 결과 값 리턴
  }

  // Getter 메서드
  public ArrayList<Double> getResults() {
    return results; //private 선언된 results필드를  접근할수있는 메서드
  }

  public double removeResult() {
    return results.remove(0); //results에서 첫번째 숫자 삭제
  }
}