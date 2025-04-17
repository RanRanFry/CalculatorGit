package CalculatorAssignment.level2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Calculator {
    //1.속성
    private ArrayList<Integer> list = new ArrayList<>();
    private String name = "연명부";

    //2.생성자


    //3. 기능(메서드)




    //게터
    public ArrayList<Integer> getList(){
        return list;
    }


    public String  getName(){return name;}

    //세터
    public void  setBrand(String name){
        this.name = name;
    }



    //정수 입력받기
    public int getIntNumber(Scanner sc) {
        System.out.println("정수를 입력하세요.");

        boolean flag = true;
        int num =0;
        while(flag){
            try{
                num = sc.nextInt();

            } catch (InputMismatchException i){
                System.out.println("정수만 넣어주세요." + i.getMessage());

            }flag = false;

        }return num;




    //연산자 입력받기
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



    //연산 함수
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
                    result = num1 / num2;

                    System.out.println(result);
                } catch (ArithmeticException e) {
                    System.out.println("오류 " + e.getMessage());
                }
                break;
            case '%':
                try {
                    if (num2 == 0) {
    //                            result = String.valueOf(result);
                        throw new ArithmeticException("오류 0으로 나누기 불가");

                    }
                    result = num1 % num2;
                    break;

                } catch (ArithmeticException e) {
                    System.out.println("오류" + e.getMessage());
                }
                break;


        }
        return result;
    }
    //리스트 추가
    public void addResult(int result) {
        list.add(result);
    }


    //가장 먼저 저장된 인덱스 제거
    public void removeResult(ArrayList list) {
        list.remove(0);
    }
    }
}

