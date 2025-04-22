package CalculatorAssignment.level2;

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
            System.out.println("버튼을 누르세요. 메뉴 버튼: 1. 연산 , 2.계산결과 목록 , 3. 계산결과 제거");
            int menuNum = sc.nextInt();

            switch (menuNum) { //메뉴열기
                case 1: //연산 페이지
                    int num1 = calc.getIntNumber(sc);
                    int num2 = calc.getIntNumber(sc);
                    char operator = calc.getOperator(sc);
                    int result = calc.calculate(operator, num1, num2);

                    // 답 저장
                    System.out.println("계산결과: " + result + "을(를) 저장");
                    calc.addResult(result);
                    break;

                case 2:
                    System.out.println(calc.getList());  //현재 리스트 값 출력
                    System.out.println("\n");
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
                        System.out.println("\n");


                    }

                    break;

                default:
                    continue;

            }
        }


        //리스트 정보 확인
          //간접 접근 게터 사용
        //System.out.println(calc.brandName);
        //calc.brandName = "TomBrowny"
        System.out.println(calc.getBrand());
        calc.setBrand("Browny");
        System.out.println(calc.getBrand());

        System.out.println("현재 값 출력");
        for (int value : list) {
            System.out.println(value);
        }



        System.out.println("삭제 후  출력");
        for (int value : list) {
            System.out.println(value);
        }

    }
}
