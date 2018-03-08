//: com.yuli.ddd.domain.guard.TermGuard.java


package com.yuli.ddd.domain.guard;


public class TermGuard implements Guard<Term> {

	@Override
	public void againstInvalidFor(Term term, String message) {
		if (term != Term.ANNUALLY && term != Term.MONTHLY) {
			throw new IllegalArgumentException(message);
		}
	}

}///:~