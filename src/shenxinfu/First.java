package shenxinfu;

import java.util.*;
public class First{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int [] a = new int [k];
        for(int i = 0;i<k;i++){
            a[i] = sc.nextInt();
        }
        int flag = 0;
        if ((k>2*n-2)){
             for (int j = 0;j<n-1;j++){
                if (a[j] != a[j+1])
                    flag =1;
             }
        }else if (k< 2*n -4)
            flag = 1;
       
      
       if (1==flag)
            System.out.println("No");
       else
            System.out.println("Yes");
       sc.close(); 
    }
}

