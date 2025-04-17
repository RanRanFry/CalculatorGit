package CalculatorAssignment.level2;

import java.util.ArrayList;
import java.util.Scanner;

public class App2 { public static void main(String[] args) {
    //데이터 입력을 받기 위한 객체 생성
    Scanner sc = new Scanner(System.in);

    Calculator calc = new Calculator();
    ArrayList <Integer> list = calc.getList();
    //숫자 입력받기

    while (true){
        System.out.println("계산을 하시겠습니까? q를 입력해주세요 \n 그만하시려면 'exit'을 입력해주세요");
        String playerAnswer = sc.next();

        if (playerAnswer.equals("exit")) {
            break;
        }

        int num1 = calc.getIntNumber();
        int num2 = calc.getIntNumber();
        char operator = getOperator(sc);
        int result = calc.calculate();


        //계산하고 답 저장
        int answer = app.calculate(operator, num1, num2); //왜 이 함수에  static이 필요한가?
        calc.addResult(answer);
        System.out.println("계산결과: " + result + "를 저장");
        calc.addResult(result);

    }

    //리스트 정보 확인
    ArrayList <Integer> list = calc.getList(); //간접 접근 게터 사용

    calc.setList("Browny");
    System.out.println(calc.getName);


    for (int value : list){
        System.out.println(value);
    }

    //가장 먼저 저장되어 있는 값 삭제
    calc.removeResult(list);
    calc.removeResult(list);
    System.out.println("삭제 후  출력");

    for (int value : list){
        System.out.println(value);
    }

}   boolean flag = false;
    public String getOperator(){

        flag = true;
        char operator ='a'; //반복문 조건
        while (flag) {
            System.out.println("연산자를 입력하세요.(+ - * / %)");
            operator = sc.next().charAt(0);
            if ((operator != '+') && (operator != '-') && (operator != '*') &&( operator != '/') && (operator != '%')) {
                System.out.println("잘못된 입력입니다. 다시 입력하세요.");
            } else {
                flag = false;
            }
        }
        return operator;

    }
}
