## Prep

### F2

last = null if q is empty
QueueNode<E> n = this.first;
E e = this.first.element;

### F3

assertFalse
assertArrayEquals

## Discussion

### D7

a. No, because ArrayList does not inherit from Queue.
Meaning, we don't get offer etc.
We could probably implement the methods ourselves, but it would
require more work. hehe.

b. Alot faster using already written methods in the queue interface.

Don't know about time complexity, but probably more optimized using 
the already written functions.

More "freedom" implementing by ourselves.

c. When learning about data structures and algorithms.
Really nische use case that would require our own implementation.
Maybe offer would always put it in the middle (i dunno).

d. No. Even "100% code coverage" is a myth, since it only counts
what lines of codes are executed when testing (i believe?).
There are always multiple ways one line of code can respond,
and thus the only way to be certain of a flawless class implementation
is if all these cases are tested, which almost surely is not the case
even if you get all greenies.
