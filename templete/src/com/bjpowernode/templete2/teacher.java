package com.bjpowernode.templete1;

/**
 * 存在的问题：
 * 1.算法没有得到重复的利用
 * 2.代码没有得到复用
 */
public class teacher {
    //这个方法表述老师的一天
    public void day(){
        //和student算法相同
        qichuang();
        xishu();
        chizaofan();
        dosome();
        chiwanfan();
        shuijiao();
    }
    public void qichuang(){
        System.out.println("起床");
    }
    public void xishu(){
        System.out.println("洗漱");
    }
    public void chizaofan(){
        System.out.println("吃早饭");
    }
    public void dosome(){
        System.out.println("老师教课");
    }
    public void chiwanfan(){
        System.out.println("吃晚饭");
    }
    public void shuijiao(){
        System.out.println("睡觉");
    }
}
