//: com.yuli.ddd.domain.guard.ClassRoom.java


package com.yuli.ddd.domain.guard;


import lombok.NonNull;


public class ClassRoom {

	private final Guard<Term> termGuard;

	public ClassRoom(Guard<Term> termGuard) {
		this.termGuard = termGuard;
	}

	/*
	 * Complexity in code makes it harder for to understand what the code is
	 * doing:
	 *   - The smallest unit of our code tends to be the function or method
	 *   - Should be able to look at a given function and quickly determine
	 *     what it’s doing
	 *   - This tends to be much easier if the function is small, well-named,
	 *     and focused.
	 * One factor that’s constantly working against simplicity is conditional
	 * complexity
	 *   - Most often taking the form of if and switch statements
	 *   - When not properly managed, these two constructs can quickly cause
	 *     functions to shift from simple and easily understood to long, obtuse,
	 *     and scary
	 *
	 * One way to reduce some of the complexity is through the use of guard
	 * clauses
	 *
	 * This is an example of a function that does not use guard clauses:
	 */
	public void subscribe(User user, Subscription subscription, Term term) {

		if (user != null) {
			if (subscription != null) {
				if (term == Term.ANNUALLY) {
					// subscribe annually
				} else if (term == Term.MONTHLY) {
					// subscribe monthly
				} else {
					throw new IllegalArgumentException(term.name());
				}
			} else {
				throw new NullPointerException(Subscription.class.getName());
			}
		} else {
			throw new NullPointerException(User.class.getName());
		}
	}

	/*
	 * Refactored to eliminate the need for the else clause
	 * This is accomplished by:
	 *   - Simply inverting the logic of the if statements
	 *   - Putting the exception throwing statements inside of these if
	 *     statements
	 *
	 * The result looks like this:
	 */
	public void subscribeImproved(User user, Subscription subscription,
	                              Term term) {

		if (user == null) {
			throw new NullPointerException(User.class.getName());
		}

		if (subscription == null) {
			throw new NullPointerException(Subscription.class.getName());
		}

		if (term == Term.ANNUALLY) {
			// subscribe annually
		} else if (term == Term.MONTHLY) {
			// subscribe monthly
		} else {
			throw new IllegalArgumentException(term.name());
		}
	}

	/*
	 * The checks for null is clearly a violation of the DRY principle
	 * This code can be pulled out into a helper Annotation:
	 */
	public void subscribeImprovedAgain(@NonNull User user,
	                                   @NonNull Subscription subscription,
	                                   @NonNull Term term) {

		if (term == Term.ANNUALLY) {
			// subscribe annually
		} else if (term == Term.MONTHLY) {
			// subscribe monthly
		} else {
			throw new IllegalArgumentException(term.name());
		}
	}

	/*
	 * The checks for common behavior of throwing a particular type of exception
	 * is clearly a violation of the DRY principle
	 *
	 * This code can be pulled out into a helper method:
	 */
	public void subscribeAdvance(@NonNull User user,
	                             @NonNull Subscription subscription,
	                             @NonNull Term term) {

		this.termGuard.againstInvalidFor(term, Term.class.getName());

		if (term == Term.ANNUALLY) {
			// subscribe annually
			return;
		}

		// subscribe monthly
	}

}///:~