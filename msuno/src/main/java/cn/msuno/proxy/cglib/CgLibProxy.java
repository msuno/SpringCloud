package cn.msuno.proxy.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CgLibProxy implements MethodInterceptor {
	private Object obj;
	
	public Object getInstance(Object obj) {
		this.obj = obj;
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(this.obj.getClass());
		enhancer.setCallback(this);
		return enhancer.create();
	}

	public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
		System.out.println("before cglib");
		arg3.invokeSuper(arg0, arg2);
		return null;
	}

	
}
