package com.detu.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.junit.Test;

public class ProxyTest {
	@Test
	public void test1() {
		TargetInterface objProxy = (TargetInterface) Proxy.newProxyInstance(
				Target.class.getClassLoader(), 
				new Class[] {TargetInterface.class}, 
				new  InvocationHandler() {
					
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						System.out.println("执行目标方法前");
						Object invoke = method.invoke(new Target(), args);
						System.out.println("执行目标方法后");

						return invoke;
					}
				});
		objProxy.method1();
		String method2 = objProxy.method2();
		System.out.println(method2);
	}

}
