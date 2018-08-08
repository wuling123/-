package alibaba;

import java.util.HashSet;
import java.util.Scanner;

public class Countsize {

	public static void main(String[] args) {
		HashSet<String> vec1= new HashSet<String>();
		HashSet<String> vec2= new HashSet<String>();
		HashSet<String> vec3= new HashSet<String>();
		vec1.add("char");
		vec1.add("unsigned char");
		vec1.add("char*");
		vec1.add("unsigned char*" );
		vec2.add("short");
		vec2.add("unsigned short");
		vec2.add("short*");
		vec2.add("unsigned short*" );
		vec3.add("int");
		vec3.add("unsigned int");
		vec3.add("long");
		vec3.add("unsigned long");
		vec3.add("unsigned int*");
		vec3.add("int*");
		vec3.add("long*");
		vec3.add("unsigned long*");
		int num=0;
		//int ÄãºÃ=2;
		Scanner sc = new Scanner(System.in);
		try {
			String[] str = sc.nextLine().split(" ");
			if(str.length==3||str.length==2) {
			
            if(vec1.contains(str[0])||vec1.contains(str[0]+" "+str[1])) {
            	num=1;
            }else
            if(vec2.contains(str[0])||vec2.contains(str[0]+" "+str[1])) {
            	num=2;
            }else
            if(vec3.contains(str[0])||vec3.contains(str[0]+" "+str[1])) {
            	num=4;
            }else {System.out.println(0);
            return;}
            //System.out.println(str.length);
           // if(!str[str.length-1].matches(""))
            String[] str2 = str[str.length-1].split("\\[");
            
            num =num*Integer.parseInt(str2[str2.length-1].substring(0, str2[str2.length-1].length()-2));
            System.out.println(num);}
			else{System.out.println(0);}
		}catch(Exception e) {
			System.out.println(0);
		}finally{
			sc.close();
	}
		


	}

}
