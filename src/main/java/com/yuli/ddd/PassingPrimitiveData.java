//: com.yuli.ddd.PassingPrimitiveData.java


package com.yuli.ddd;


public class PassingPrimitiveData {

    public static void modify(int x, int y) {
        x = 5;
        y = 10;
        System.out.println("Inside modify method: x = " + x);
        System.out.println("Inside modify method: y = " + y);
    }

    public static void modifyWrappers(Integer x, Integer y) {
        x = new Integer(5);
        y = new Integer(10);
        System.out.println("Inside modifyWrappers method: Integer x = " + x);
        System.out.println("Inside modifyWrappers method: Integer y = " + y);
    }

}///:~