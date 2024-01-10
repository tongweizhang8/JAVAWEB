package com.powernode.threadlocal;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 自定义一个ThreadLocal类
 */
public class MyThreadLocal<T> {
    /**
     * 所有需要和当前线程绑定的数据要放在这个容器中
     */
    private Map<Thread,T> map = new HashMap<>();

    /**
     * 向Thread中绑定数据
     * @param object
     */
    public void set(T object){
        map.put(Thread.currentThread(), object);

    }

    /**
     * 从ThreadLocal中获取数据
     * @return
     */
    public T get(){
        return  map.get(Thread.currentThread());
    }

    /**
     * 移除ThreadLocal当中的数据
     */
    public void remove(){
        map.remove(Thread.currentThread());
    }
}
