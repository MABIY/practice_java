package chap9;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

/**
 * @author : lh
 * @since : 2020/6/13, Sat
 **/
public class C implements A, B {
    @Override
    public void hello() {
        B.super.hello();
    }

    public static void main(String[] args) {
        new C().hello();
    }
}
