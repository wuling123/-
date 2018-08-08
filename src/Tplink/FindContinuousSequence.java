package Tplink;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
/**��Ŀ�������ҳ����к�ΪS��������������
 * n+(n+1)+(n+2)+...+(n+k)=s
 * ����n=(2s-(k^2+k))/2(k+1)
 * kԽС��˵��nԽ��������ǰ��õ�������Ӧ���������뵽��������У���˿�����ջװÿһ��k��Ӧ������
 * Created by ���� on 2018/6/12.
 */
public class FindContinuousSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        ArrayList<ArrayList<Integer>> sequence = findContinuousSequence(input);
        if(sequence.size()<=0){
            System.out.println("������");
        }else {
            for (ArrayList<Integer> list:sequence){
                for (Integer integer:list)
                    System.out.print(integer+" ");
                System.out.println();
            }
        }

    }
    public static ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {
        if (sum<=0) return null;
        Stack<ArrayList<Integer>> stack=new Stack<>();
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        int k=1;
        int k2Addk=k*k+k;
        int n=1;
        while (2*sum>k2Addk){
            if((2*sum-k2Addk)%(2*(k+1))==0){
                n=(2*sum-k2Addk)/(2*(k+1));
                ArrayList<Integer> element=new ArrayList<>();
                for (int i=0;i<=k;i++){
                    element.add(n+i);
                }
                stack.push(element);
            }
            k++;
            k2Addk=k*k+k;
        }
        while (!stack.isEmpty()){
            result.add(stack.pop());
        }
        return result;
    }
}