package cn.msuno.proxy;

import cn.msuno.proxy.cglib.CgLibProxy;
import cn.msuno.proxy.proxy.ProxyBean;

public class CgLibTest {

	public static void main(String[] args) {
		CgLibProxy cg = new CgLibProxy();
		ProxyBean proxy = (ProxyBean)cg.getInstance(new ProxyBean());
		proxy.print();
	}
	
}
