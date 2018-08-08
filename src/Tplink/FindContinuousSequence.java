package Tplink;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
/**题目描述：找出所有和为S的连续正数序列
 * n+(n+1)+(n+2)+...+(n+k)=s
 * 所以n=(2s-(k^2+k))/2(k+1)
 * k越小，说明n越大，所以最前面得到的序列应该最后面加入到输出序列中，因此考虑用栈装每一个k对应的序列
 * Created by 李阳 on 2018/6/12.
 */
public class FindContinuousSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        ArrayList<ArrayList<Integer>> sequence = findContinuousSequence(input);
        if(sequence.size()<=0){
            System.out.println("不存在");
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