package com.huqiliang.proxy.tank;
import com.huqiliang.proxy.interf.Moveable;
import java.lang.reflect.Method;
public class TankTimeProxy implements com.huqiliang.proxy.interf.Moveable {
com.huqiliang.proxy.tank.InvocationHandler h;
public TankTimeProxy(InvocationHandler h) {
    this.h = h;
}
public void move(){
try{
Method md=com.huqiliang.proxy.interf.Moveable.class.getMethod("move");
    h.Invoke(this,md);
}
catch(Exception e) {
e.printStackTrace();
}
}
}