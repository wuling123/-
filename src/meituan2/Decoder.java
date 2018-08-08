package meituan2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class D extends Decoder {

	public D(int i) {
		super();

	}

}

public class Decoder {
	public Decoder(int i) {
	}

	public Decoder() {

	}

	public static void change(StringBuffer s1, StringBuffer s2) {
		s1.append("World");
		System.out.println(s2);
		s2 = s1;
		System.out.println(s2);
	}

	final static int m = 1;

	public static void main(String[] args) {
		Integer a = 1;
		Integer b = 1;
		b++;
		System.out.println(a);
		System.out.println(b);
		StringBuffer s1 = new StringBuffer("Hello");
		StringBuffer s2 = new StringBuffer("Hello");
		change(s1, s2);
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(5 >> (7 >> 2));
		int sh = 1;
		sh = sh + 1 + '1';
		int ch = 'b';
		System.out.println(ch + "--" + sh);
		System.out.println('c' + "");
		Class<D> c = D.class;
		Class<? extends D> CL = new D(1).getClass();
		// List<Object> list=new ArrayList<String>(); 错误，泛型检查不通过
		String a1 = "ab";
		String b2 = "b";
		String b3 = "a" + b2;
		System.out.println(a1 == b3);
		System.out.println(a1.intern());
		System.out.println(new Integer(3) == 3.0);
	}

}
