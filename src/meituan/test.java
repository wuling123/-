package meituan;

import java.util.Comparator;  
import java.util.Iterator;  
import java.util.Map;  
import java.util.Set;  
import java.util.TreeMap;  
public class test {  
    public static void main(String[] args) {  
        Map<Double, String> map = new TreeMap<Double, String>(  
                new Comparator<Double>() {  
                    public int compare(Double obj1, Double obj2) {  
                        // Ωµ–Ú≈≈–Ú  
                        return obj2.compareTo(obj1);  
                    }  
                });  
        map.put(2.33, "ccccc");  
        map.put(2.33, "aaaaa");  
        map.put(3.0, "bbbbb");  
        map.put(4.0, "ddddd");  
          
        Set<Double> keySet = map.keySet();  
        Iterator<Double> iter = keySet.iterator();  
        while (iter.hasNext()) {  
            Double key = iter.next();  
            System.out.println(key + ":" + map.get(key));  
        }  
        double a=2.0/7;
        System.out.println(a==2.0/7);
    }  
}  

