package CalculatorAssignment.level1;

import java.util.Scanner;


public class App {
    public static void main(String[] args) {
        //데이터 입력을 받기 위한 객체 생성
        Scanner sc = new Scanner(System.in);

        //숫자 입력받기

        while (true){
            System.out.println("계산을 하시겠습니까? 그만하시려면 'exit'을 입력해주세요");
            String playerAnswer = sc.next();

            if (playerAnswer.equals("exit")) {
                break;
            }
            System.out.print("숫자를 입력하세요 num1: ");
            int num1 = sc.nextInt();
            System.out.print("숫자를 입력하세요 num2: ");
            int num2 = sc.nextInt();
            System.out.println("연산자를 입력하세요.");
            char operator = sc.next().charAt(0);
            //계산하고 답 저장
            int answer = calculate(operator, num1, num2); //왜 이 함수에  static이 필요한가?
            System.out.println("계산결과: " + answer);
        }




    }




    public static int calculate(char operator, int num1, int num2) {

        int result = 0;
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

                try {
                    if (num2 == 0) {
                        throw new ArithmeticException("0으로 나누기 불가"); //중요 구문 외우기
                    }
                     result =  num1 / num2;

                    System.out.println(result);
                } catch (ArithmeticException e) {
                    System.out.println("오류 " + e.getMessage());
                }
                break;
            case '%':
                    try{
                        if (num2 == 0) {
//                            result = String.valueOf(result);
                            throw new ArithmeticException("오류 0으로 나누기 불가");

                        }
                        result =  num1 % num2;
                        break;

                   } catch (ArithmeticException e){
                        System.out.println("오류" + e.getMessage());
                    }
                    break;


        }
        return result;
    }
}
