package com.detu.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest2 {
	public static void main(String[] args) {
		Target target = new Target();
		TargetInterface proxy =  (TargetInterface) Proxy.newProxyInstance(
				target.getClass().getClassLoader(), 
				target.getClass().getInterfaces(), 
				new InvocationHandler() {
					
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						Object invoke = method.invoke(target, args);
						return invoke;
					}
				}
			);
		proxy.method1();
		String method2 = proxy.method2();
		int method3 = proxy.method3(100);
		System.out.println(method2);
		System.out.println(method3);
		
	}

}
