package com.example.calculator3;

public class OperatorType {
  enum OperationType {
    ADD("+"){
      @Override
      public double calculate(double a, double b){
        return a + b;
      }
    },
    MINUS("-"){
      @Override
      public double calculate(double a, double b){
        return a - b;
      }
    },
    MULTIPLE("*"){
      @Override
      public double calculate(double a, double b){
        return a * b;
      }
    },
    DIVIDE("/"){
      @Override
      public double calculate(double a, double b){
        return a / b;
      }
    };

    private final String operator; //사칙연산을 담을 필드를 추가해줘야됨

    OperationType(String operator) {
      this.operator = operator; // ADD("+")가 호출되면 ,operator 필드에 + 저장
    } // 생성자를 추가해줘야된다 ADD("+")이부분이 생성자 호출부분이기 떄문
      
    public String getOperator() {
      return operator; //private인 operator 필드를 외부에서 읽을수 있도록
    }

    public abstract double calculate(double a, double b);//추상 메서드


  }
}



