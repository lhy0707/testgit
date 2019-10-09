package com.detu.proxy;

public class Target implements TargetInterface{

	@Override
	public void method1() {
		System.out.println("method1");
		
	}

	@Override
	public String method2() {
		System.out.println("method2");
		return "method2";
	}

	@Override
	public int method3(int args) {
		return args;
	}
	

}
