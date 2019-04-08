package cn.msuno.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import cn.msuno.proxy.dynamic.DynamicProxy;
import cn.msuno.proxy.proxy.ProxyB;
import cn.msuno.proxy.proxy.ProxyBean;

public class DynamicTest {

	public static void main(String[] args) {
		ProxyB bean = new ProxyBean();
		InvocationHandler handler = new DynamicProxy(bean);
		ProxyB proxy = (ProxyB)Proxy.newProxyInstance(handler.getClass().getClassLoader(), bean.getClass().getInterfaces(), handler);
		proxy.print();
	}
}
