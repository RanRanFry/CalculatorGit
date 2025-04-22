package CalculatorAssignment.level2;

import CalculatorAssignment.level3.Operation;

import java.util.ArrayList;
import java.util.Scanner;

public class App2 {
    public static void main(String[] args) {
        //데이터 입력을 받기 위한 객체 생성
        Scanner sc = new Scanner(System.in);

        Calculator calc = new Calculator();
        ArrayList<Integer> list = calc.getList();
        //숫자 입력받기
        boolean flag = true;
        while (flag) {
            if(!calc.checkString(sc)){ break;}
            System.out.println("메뉴 버튼: 1. 연산 , 2.계산결과 목록 , 3. 계산결과 제거, 4. 작성자명, 5. 작성자명 변경");
            sc.nextLine();

            int menuNum = sc.nextInt();


            switch (menuNum) {
                case 1: //연산 페이지
                    int num1 = calc.getIntNumber(sc);
                    int num2 = calc.getIntNumber(sc);
                    char operator = calc.getOperator(sc);
                    int result = calc.calculate(operator, num1, num2);

                    // 답 저장
                    System.out.println("계산결과: " + result + "을(를) 저장");
                    calc.addResult(result);
                    break;

                case 2:                 //현재 리스트 값 출력
                    System.out.println(calc.getList());
                    break;

                case 3:
                    //가장 먼저 저장되어 있는 값 삭제
                    try{
                        calc.removeResult(list);
                        if(calc.getList().size() == 0){
                            throw new IndexOutOfBoundsException();
                        }

                    }catch(IndexOutOfBoundsException e){

                        System.out.println("리스트에 원소가 없습니다. 원소를 추가해주세요."+e.getMessage());
                    }

                    break;

                case 4:
                    System.out.println("현재 작성자 명: "+calc.getOwner());
                    break;
                case 5:
                    System.out.println("변경할 작성자 명을 입력해주세요.");
                    String name = sc.next();
                    sc.nextLine();
                    calc.setOwner(name);
                    System.out.println(calc.getOwner());
                    break;

                default:
                    continue;

            }
        }

    }
}
