package Tplink;

import java.util.Scanner;

/**��ƽ�������������
 * Created by ���� on 2018/6/17.
 */
public class QuickSqrt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        int result = quickSqrt(input);
        System.out.println(result);
        int[][] c=new int[2][2];

    }
    public static int quickSqrt(int x) {
        if(x<=1) {
            return x;
        }

        int begin = 1;
        int end   = x;
        int middle = 0;
        while(begin<=end) {
            middle = begin + (end - begin)/2;
            //��Ҫд��middle*middle==x�������
            if(middle==x/middle) {
                return middle;
            } else {
                if (middle<x/middle) {
                    begin = middle + 1;
                } else {
                    end = middle - 1;
                }
            }

        }
        //��������endһ��<begin�����Է���end
        return end;
    }
}