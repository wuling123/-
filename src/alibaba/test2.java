package alibaba;

import java.util.Scanner;

 public class test2{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int times = sc.nextInt();
        for (int i = 0; i < times; i++){
            int number = sc.nextInt();
            String count = FindResult(number);
            System.out.println(count);
        }
        sc.close();
    }
    private static String FindResult(int number) {
        //int length = String.valueOf(number).length();
        int length = (int)Math.log10(number)+1;
        if (length == 1){
            return String.valueOf(number);
        }else if (length == 2){
            return String.valueOf(9 + (number - 9) * 2);
        }
        long result = 189;
        //BigInteger result = new BigInteger("189");
        for (int i = 3; i < length; i++){
            //result.add(new BigInteger(String.valueOf(Math.pow(10,i) * i)));
            result += Math.pow(10,i-1) * i * 9;
        }
        //result.add(new BigInteger(String.valueOf((number - Math.pow(10,length - 1) + 1) * length)));
        result += (number - Math.pow(10,length - 1) + 1) * length;
        return String.valueOf(result);
    }
}

