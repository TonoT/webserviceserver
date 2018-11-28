package demo.hw.server;

import javax.xml.namespace.QName;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.headers.Header;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.w3c.dom.Element;

public class LoginIntercept extends AbstractPhaseInterceptor<SoapMessage> {

	public LoginIntercept() {
		super(Phase.PRE_INVOKE);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handleMessage(SoapMessage msg) throws Fault {
		Header header = msg.getHeader(new QName("user"));
		if (header != null) {
			/** * 解析header */
			Element rootEle = (Element) header.getObject();
			Element name = (Element) rootEle.getElementsByTagName("name").item(0);
			Element password = (Element) rootEle.getElementsByTagName("password").item(0);
			String name_1 = name.getTextContent();
			String password_1 = password.getTextContent();
			if ("xzg".equals(name_1) && "1234".equals(password_1)) {
				return;
			} else {
				throw new RuntimeException("用户名或密码不正确！");
			}
		}
	}

}
