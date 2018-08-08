package Tplink;

/**
 * 查找第二大的数
 * Created by 李阳 on 2018/6/17.
 */
public class FindSecond {
    public static void main(String[] args) {
        int[] data={3,2,1,4,5};
        int sec_max = find_sec_max(data, 5);
        System.out.println(sec_max);
    }
    public static int find_sec_max(int[] data,int count){
        int max1 = 0;
        int max2 = 0;
        for(int i=1; i<count; i++)
        {
            if(data[i] > data[max1])
            {
                max2 = max1;
                max1 = i;
            }
            else if(data[i] >  data[max2] && data[i] < data[max1])
                max2 = i;
        }
        return data[max2];
    }
}