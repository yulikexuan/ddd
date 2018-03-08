//: com.yuli.ddd.domain.guard.Guard.java


package com.yuli.ddd.domain.guard;


public interface Guard<T> {

	void againstInvalidFor(T t, String message);

}///:~