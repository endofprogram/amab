package org.eop.amab.compile.expression.node;

/**
 * @author lixinjie
 * @since 2017-05-21
 */
public class ExpressionNode {

	public static void main(String[] args) throws NoSuchFieldException, SecurityException {
		int a = 1;
		int b = 2;
		System.out.println(++ a+ (b += 1));
		System.out.println(a += a+++ (b+=1) );
		System.out.println(a);
		System.out.println(b);
		System.out.println(new Object[0].getClass());
		System.out.println(a = 10);
		System.out.println(int.class.getName());
		System.out.println(Integer.class.getName());
		Object c = 100000000;
		Object d = 100000000;
		System.out.println(c.getClass());
		System.out.println(c == d);
		Character e = 'a';
		Character f = 'a';
		System.out.println(e == f);
	}
}
