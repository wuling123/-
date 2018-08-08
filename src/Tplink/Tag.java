package Tplink;

import java.util.Scanner;

/**
 * 将图转换为代码
 * Created by 李阳 on 2018/6/17.
 */
public class Tag {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int tag=calTag(a,b,c);
        System.out.println(tag);
    }
    public static int calTag(int a,int b,int c){
        int tag=0;
        String str=a+""+b+c;
        switch (str){
            case "000":tag=0;break;
            case "001":tag=3;break;
            case "010":tag=2;break;
            case "100":tag=1;break;
            case "011":tag=2;break;
            case "101":tag=2;break;
            case "110":tag=1;break;
            case "111":tag=1;break;
        }
        return tag;
    }

}
